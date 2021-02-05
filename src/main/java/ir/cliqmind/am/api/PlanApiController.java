package ir.cliqmind.am.api;

import ir.cliqmind.am.dao.*;
import ir.cliqmind.am.domain.PlanPrice;
import ir.cliqmind.am.dto.*;
import ir.cliqmind.am.error.NotFoundException;
import ir.cliqmind.am.error.ValidationException;
import ir.cliqmind.am.mapper.PlanMapper;
import ir.cliqmind.am.mapper.ResponseMessageBuilder;
import ir.cliqmind.am.mapper.TransactionMapper;
import ir.cliqmind.am.service.PlanServiceBusiness;
import ir.cliqmind.am.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/plan")
public class PlanApiController {

    private static final Logger log = LoggerFactory.getLogger(PlanApiController.class);

    @Autowired
    private PlanRepo planRepo;

    @Autowired
    private PlanPriceRepo planPriceRepo;

    @Autowired
    private PlanFeatureRepo planFeatureRepo;

    @Autowired
    private PlanActivationHistoryRepo planActivationHistoryRepo;

    @Autowired
    private TransactionRepo transactionRepo;

    @Autowired
    private PlanServiceBusiness planServiceBusiness;

    private PlanMapper planBuilder;

    private ResponseMessageBuilder responseMessageBuilder;

    private TransactionMapper transactionBuilder;

    public PlanApiController(){
        planBuilder = new PlanMapper();
        responseMessageBuilder = new ResponseMessageBuilder();
        transactionBuilder = new TransactionMapper();
    }

    @Transactional
    @PutMapping("/{id}/activate")
    public ResponseEntity<ResponseMessage> activatePlan(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(activate(id, true), HttpStatus.OK);
    }

    @Transactional
    @PostMapping("")
    public ResponseEntity<Plan> addPlan(@Valid @RequestBody AddPlanRequest body) {
        ir.cliqmind.am.domain.Plan entity = new ir.cliqmind.am.domain.Plan();
        entity.setName(body.getName());
        entity.setDescription(body.getDescription());
        entity.setUserBased(body.isUserBased());
        entity.setEnableAmount(body.isEnableAmount());
        entity.setMaximumAmount(body.getMaximumAmount());
        entity.setDurationInMonths(body.getDurationInMonths());
        entity.setPlanFeatures(planBuilder.planFeatures(body.getFeatures(), entity.getId()));
        entity.setPlanPrice(planBuilder.planPrices(body.getPrice(), entity.getId()));
        entity = planRepo.add(entity);
        return new ResponseEntity<>(planBuilder.plan(entity), HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/buy")
    public ResponseEntity<Transaction> buyPlan(@Valid @RequestBody BuyPlanRequest body) {
        if(!checkBalance(body.getUserId(), body.getCurrency(), body.getAmount())){
            throw new ValidationException("Credit is lower than amount");
        }
        ir.cliqmind.am.domain.Plan plan = findPlanWithFeaturesPrice(body.getPlanId());
        if(plan == null || plan.getId()==null){
            throw new NotFoundException("plan does not exist");
        }
        if(plan.getPlanFeatures()!=null && plan.getPlanFeatures().size()>0) {
            List<Integer> featureIds = plan.getPlanFeatures().stream().map(pf -> pf.getId().getFeatureId()).collect(Collectors.toList());
            List<Integer> currentPlansWithSameFeatures = planRepo.findMaximumAmountByFeatureIds(featureIds);
            log.debug("buyPlan currentPlansWithSameFeatures = {}", currentPlansWithSameFeatures);
            if(currentPlansWithSameFeatures!=null){
                currentPlansWithSameFeatures.forEach(p -> {
                    if(p < body.getAmount()){
                        throw new ValidationException(String.format("Amount is not allowed to be more than %s",
                                p));
                    }
                });
            }
        }
        LocalDate today = LocalDate.now();
        List<ir.cliqmind.am.domain.PlanActivationHistory> activatedPlans = planActivationHistoryRepo.findByOwnerIdAndPlan(
                body.getOwnerId(), plan.getId());
        log.debug("activatedPlans = {}", activatedPlans);
        LocalDate expirationDate = null;
        if(activatedPlans!=null){
            ir.cliqmind.am.domain.PlanActivationHistory currentPlan = activatedPlans.stream().filter(
                    ap -> DateUtil.dateIsInRange(today,
                            ap.getStartDate(), ap.getExpirationDate())).max(Comparator.comparingInt(h ->
                    DateUtil.diffDay(today, h.getExpirationDate()))).orElse(null);
            log.debug("buyPlan current activated plan = {}", currentPlan);
            if(currentPlan != null){
                expirationDate = currentPlan.getExpirationDate();
                log.debug("set expiration based on previously activated plan {}", expirationDate);
            }
        }
        ir.cliqmind.am.domain.Transaction transaction = planActivationHistoryRepo.performBuyTransaction(body, plan, expirationDate);
        log.debug("buyPlan transaction {}", transaction);
        return new ResponseEntity<>(transactionBuilder.transaction(transaction), HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/{id}/price")
    public ResponseEntity<Price> calculatePlanPrice(
            @PathVariable("id") Integer id, @Valid @RequestBody CalculatePlanPriceRequest body) {
        ir.cliqmind.am.domain.Plan plan = findPlanWithFeaturesPrice(body.getPlanId());
        if(plan == null || plan.getId()==null){
            throw new NotFoundException("plan does not exist");
        }
        Double price = planServiceBusiness.calculatePrice(body, plan);
        return new ResponseEntity<>(planBuilder.calculatePrice(price), HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/renewal/price")
    public ResponseEntity<Price> calculatePlanRenewalPrice(@Valid @RequestBody CalculatePlanRenewalPriceRequest body) {
        if(body.getPlans()==null || body.getPlans().size()==0){
            throw new ValidationException("empty plans");
        }
        List<Integer> planIds = body.getPlans().keySet().stream().flatMap((Function<String, Stream<Integer>>) s -> {
            try{
                return Stream.of(Integer.parseInt(s));
            }
            catch (Exception ex){
                return null;
            }
        }).collect(Collectors.toList());
        if(planIds.size()!=body.getPlans().size()){
            throw new ValidationException("invalid plan id");
        }
        List<ir.cliqmind.am.domain.Plan> plans = findPlanWithFeaturesPrice(planIds);
        if(plans == null || plans.isEmpty()){
            throw new NotFoundException("plan does not exist");
        }
        List<ir.cliqmind.am.domain.PlanActivationHistory> activatedPlans = planActivationHistoryRepo.findByOwnerId(body.getOwnerId());
        Double price = planServiceBusiness.calculateRenewalPrice(body, plans, activatedPlans);
        return new ResponseEntity<>(planBuilder.calculatePrice(price), HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/upgrade/price")
    public ResponseEntity<Price> calculatePlanUpgradePrice(@Valid @RequestBody CalculatePlanUpgradeRequest body) {
        if(body.getFromPlanId()==null || body.getToPlanId()==null){
            throw new ValidationException("empty plans");
        }
        ir.cliqmind.am.domain.Plan planFrom = findPlanWithFeaturesPrice(body.getFromPlanId());
        ir.cliqmind.am.domain.Plan planTo = findPlanWithFeaturesPrice(body.getToPlanId());
        List<ir.cliqmind.am.domain.PlanActivationHistory> activatedPlans = planActivationHistoryRepo.findByOwnerId(body.getOwnerId());
        Double price = planServiceBusiness.calculateUpgradePrice(body, planFrom, planTo, activatedPlans);
        return new ResponseEntity<>(planBuilder.calculatePrice(price), HttpStatus.OK);
    }

    @Transactional
    @PutMapping("/{id}/deactivate")
    public ResponseEntity<ResponseMessage> deactivatePlan(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(activate(id, false), HttpStatus.OK);
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<ResponseMessage> editPlan(@PathVariable("id") Integer id, @Valid @RequestBody EditPlanRequest body) {
        ir.cliqmind.am.domain.Plan entity = planRepo.findById(id).orElseThrow(() -> new NotFoundException("plan does not exist"));
        entity.setName(body.getName());
        entity.setDescription(body.getDescription());
        entity.setUserBased(body.isUserBased());
        entity.setEnableAmount(body.isEnableAmount());
        entity.setMaximumAmount(body.getMaximumAmount());
        entity.setDurationInMonths(body.getDurationInMonths());
        entity.setPlanFeatures(planBuilder.planFeatures(body.getFeatures(), entity.getId()));
        entity.setPlanPrice(planBuilder.planPrices(body.getPrice(), entity.getId()));
        planRepo.edit(entity);
        return new ResponseEntity<>(responseMessageBuilder.success(), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    @GetMapping("/activation/history")
    public ResponseEntity<GetPlanActivationHistoryResponse> getPlanActivationHistory(GetPlanActivationHistoryRequest body, Pageable pageable) {
        List<ir.cliqmind.am.domain.PlanActivationHistory> planActivationHistories = planActivationHistoryRepo.findAll(body);
        log.debug("getPlanActivationHistory result = {}", planActivationHistories);
        GetPlanActivationHistoryResponse result = new GetPlanActivationHistoryResponse();
        if(planActivationHistories!=null){
            result.addAll(planActivationHistories.stream().map(pah -> planBuilder.planActivationHistory(pah)).collect(Collectors.toList()));
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    @GetMapping("")
    public ResponseEntity<Plans> getPlans(GetPlansRequest body, Pageable pageable) {
        List<Integer> ids = body.getIds();
        if(ids!=null && ids.isEmpty()){
            ids = null;
        }
        Iterable<ir.cliqmind.am.domain.Plan> entities = planRepo.find(ids, body.isActive());
        List<ir.cliqmind.am.domain.PlanPrice> price = planPriceRepo.find(entities);
        if(price != null){
            Map<Integer, List<PlanPrice>> mapped = price.stream().collect(Collectors.groupingBy(pp -> pp.getId().getPlanId()));
            entities.forEach(plan -> {
                plan.setPlanPrice(mapped.get(plan.getId()));
            });
        }
        List<ir.cliqmind.am.domain.PlanFeature> features = planFeatureRepo.find(entities);
        if(features!=null){
            Map<Integer, List<ir.cliqmind.am.domain.PlanFeature>> mapped = features.stream().collect(Collectors.groupingBy(pp -> pp.getId().getPlanId()));
            entities.forEach(plan -> {
                plan.setPlanFeatures(mapped.get(plan.getId()));
            });
        }
        return new ResponseEntity<>(planBuilder.plan(entities), HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/renew")
    public ResponseEntity<Transaction> renewPlans(@Valid @RequestBody RenewPlansRequest body) {
        if(body.getPlans()==null || body.getPlans().size()==0){
            throw new ValidationException("empty plans");
        }
        List<Integer> planIds = body.getPlans().keySet().stream().flatMap((Function<String, Stream<Integer>>) s -> {
            try{
                return Stream.of(Integer.parseInt(s));
            }
            catch (Exception ex){
                return null;
            }
        }).collect(Collectors.toList());

        if(planIds.size()!=body.getPlans().size()){
            throw new ValidationException("invalid plan id");
        }

        List<ir.cliqmind.am.domain.Plan> plans = findPlanWithFeaturesPrice(planIds);
        if(plans == null || plans.size()==0){
            throw new NotFoundException("plan does not exist");
        }
        List<ir.cliqmind.am.domain.PlanActivationHistory> activatedPlans = planActivationHistoryRepo.findByOwnerId(body.getOwnerId());
        ir.cliqmind.am.domain.Transaction transaction = planActivationHistoryRepo.performRenewTransaction(body, plans, activatedPlans);
        log.debug("renewPlan transaction {}", transaction);
        return new ResponseEntity<>(transactionBuilder.transaction(transaction), HttpStatus.OK);
    }

    @Transactional
    @PutMapping("/{id}/features")
    public ResponseEntity<ResponseMessage> setPlanFeatures(@PathVariable("id") Integer id, @Valid @RequestBody SetPlanFeaturesRequest body) {
        ir.cliqmind.am.domain.Plan entity = planRepo.findById(id).orElseThrow(() -> new NotFoundException("plan does not exist"));
        entity.setPlanFeatures(planBuilder.planFeatures(body.getFeatures(), entity.getId()));
        planRepo.setFeatures(entity);
        return new ResponseEntity<>(responseMessageBuilder.success(), HttpStatus.OK);
    }

    @Transactional
    @PutMapping("/{id}/price")
    public ResponseEntity<ResponseMessage> setPlanPrice(@PathVariable("id") Integer id, @Valid @RequestBody PlanPrices body) {
        ir.cliqmind.am.domain.Plan entity = planRepo.findById(id).orElseThrow(() -> new NotFoundException("plan does not exist"));
        entity.setPlanPrice(planBuilder.planPrices(body, entity.getId()));
        planRepo.setPrice(entity);
        return new ResponseEntity<>(responseMessageBuilder.success(), HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/upgrade")
    public ResponseEntity<Transaction> upgradePlan(@Valid @RequestBody UpradePlanRequest body) {
        if(body.getFromPlanId()==null || body.getToPlanId()==null){
            throw new ValidationException("empty plans");
        }
        if(!checkBalance(body.getUserId(), body.getCurrency(), body.getAmount())){
            throw new ValidationException("Credit is lower than amount");
        }
        ir.cliqmind.am.domain.Plan planFrom = findPlanWithFeaturesPrice(body.getFromPlanId());
        ir.cliqmind.am.domain.Plan planTo = findPlanWithFeaturesPrice(body.getToPlanId());

        List<ir.cliqmind.am.domain.PlanActivationHistory> activatedPlans = planActivationHistoryRepo.findByOwnerId(body.getOwnerId());
        ir.cliqmind.am.domain.Transaction transaction = planActivationHistoryRepo.performUpgradeTransaction(body, planFrom, planTo, activatedPlans);
        log.debug("upgradePlan transaction {}", transaction);
        return new ResponseEntity<>(transactionBuilder.transaction(transaction), HttpStatus.OK);
    }

    private ResponseMessage activate(Integer id, boolean active){
        ir.cliqmind.am.domain.Plan entity = planRepo.findById(id).orElseThrow(() -> new NotFoundException("plan does not exist"));
        entity.setActive(active);
        planRepo.save(entity);
        return responseMessageBuilder.success();
    }

    private ir.cliqmind.am.domain.Plan findPlanWithFeaturesPrice(Integer id){
        ir.cliqmind.am.domain.Plan entity = planRepo.findById(id).orElse(null);
        if(entity!=null) {
            entity.setPlanPrice(planPriceRepo.find(entity));
            entity.setPlanFeatures(planFeatureRepo.find(entity));
        }
        return entity;
    }

    private List<ir.cliqmind.am.domain.Plan> findPlanWithFeaturesPrice(List<Integer> ids){
        List<ir.cliqmind.am.domain.Plan> entities = new ArrayList<>();
        Optional.ofNullable(planRepo.findAllById(ids)).ifPresent(
                results -> results.forEach(p->entities.add(p)));
        entities.forEach(entity -> {
            entity.setPlanPrice(planPriceRepo.find(entity));
            entity.setPlanFeatures(planFeatureRepo.find(entity));
        });
        return entities;
    }

    private boolean checkBalance(UUID userId, String currency, double amount) {
        double balance = transactionRepo.getCreditBalance(userId, currency).getOrDefault(currency, 0d);
        if(balance < amount){
            return false;
        }
        return true;
    }

}
