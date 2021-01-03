package ir.cliqmind.am.service;

import ir.cliqmind.am.dao.*;
import ir.cliqmind.am.dto.*;
import ir.cliqmind.am.error.NotFoundException;
import ir.cliqmind.am.error.ValidationException;
import ir.cliqmind.am.mapper.PlanBuilder;
import ir.cliqmind.am.mapper.ResponseMessageBuilder;
import ir.cliqmind.am.mapper.TransactionBuilder;
import ir.cliqmind.am.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PlanServiceImpl implements PlanService{


    private static final Logger log = LoggerFactory.getLogger(PlanServiceImpl.class);

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

    private PlanBuilder planBuilder;

    private ResponseMessageBuilder responseMessageBuilder;

    private PlanServiceBusiness planServiceBusiness;

    private TransactionBuilder transactionBuilder;

    @Autowired
    public PlanServiceImpl(PlanServiceBusiness planServiceBusiness){
        this.planServiceBusiness = planServiceBusiness;
        planBuilder = new PlanBuilder();
        responseMessageBuilder = new ResponseMessageBuilder();
        transactionBuilder = new TransactionBuilder();
    }

    @Override
    public ResponseMessage activate(ActivatePlanRequest body) {
        log.info("activatePlan {}", body);
        return activate(body.getId(), true);
    }

    @Override
    public ResponseMessage deactivate(DeactivatePlanRequest body) {
        log.info("deactivatePlan {}", body);
        return activate(body.getId(), false);
    }

    @Override
    public Plan add(AddPlanRequest body) {
        log.info("addPlan {}", body);
        ir.cliqmind.am.domain.Plan entity = planRepo.save(planBuilder.add(body));
        Plan response = planBuilder.plan(entity);
        log.debug("addPlan result = {}", response);
        return response;
    }

    @Override
    public ResponseMessage edit(EditPlanRequest body) {
        log.info("editPlan {}", body);
        ir.cliqmind.am.domain.Plan entity = findPlan(body.getId());
        if(entity == null || entity.getId() == null){
            throw new NotFoundException("plan does not exist");
        }
        entity.setName(body.getName());
        entity.setDescription(body.getDescription());
        entity.setUserBased(body.isUserBased());
        entity.setEnableAmount(body.isEnableAmount());
        entity.setMaximumAmount(body.getMaximumAmount());
        entity.setDurationInMonths(body.getDurationInMonths());
        entity.setPlanFeatures(planBuilder.planFeatures(body.getFeatures(), entity.getId()));
        entity.setPlanPrice(planBuilder.planPrices(body.getPrice(), entity.getId()));
        planRepo.edit(entity);
        return responseMessageBuilder.success();
    }

    @Override
    public Transaction buy(BuyPlanRequest body) {
        log.info("buyPlan {}", body);
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
        Date today = DateUtil.today();
        List<ir.cliqmind.am.domain.PlanActivationHistory> activatedPlans = planActivationHistoryRepo.findByOwnerIdAndPlan(
                body.getOwnerId(), plan.getId());
        log.debug("activatedPlans = {}", activatedPlans);
        java.sql.Date expirationDate = null;
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
        return transactionBuilder.transaction(transaction);
    }

    private boolean checkBalance(UUID userId, String currency, double amount) {
        double balance = transactionRepo.getCreditBalance(userId, currency).getOrDefault(currency, 0d);
        if(balance < amount){
            return false;
        }
        return true;
    }

    @Override
    public CalculatePlanPriceResponse calculatePrice(CalculatePlanPriceRequest body) {
        log.info("calculatePlanPrice {}", body);
        ir.cliqmind.am.domain.Plan plan = findPlanWithFeaturesPrice(body.getPlanId());
        if(plan == null || plan.getId()==null){
            throw new NotFoundException("plan does not exist");
        }
        Double price = planServiceBusiness.calculatePrice(body, plan);
        return planBuilder.calculatePrice(price);
    }

    @Override
    public CalculatePlanRenewalPriceResponse calculateRenewalPrice(CalculatePlanRenewalPriceRequest body) {
        log.info("calculatePlanRenewalPrice {}", body);
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
        Double price = planServiceBusiness.calculateRenewalPrice(body, plans, activatedPlans);
        return planBuilder.calculatePlanRenewalPriceResponse(price);
    }

    @Override
    public CalculatePlanUpgradePriceResponse calculateUpgradePrice(CalculatePlanUpgradeRequest body) {
        log.info("calculatePlanUpgradePrice {}", body);
        if(body.getFromPlanId()==null || body.getToPlanId()==null){
            throw new ValidationException("empty plans");
        }
        ir.cliqmind.am.domain.Plan planFrom = findPlanWithFeaturesPrice(body.getFromPlanId());
        ir.cliqmind.am.domain.Plan planTo = findPlanWithFeaturesPrice(body.getToPlanId());
        List<ir.cliqmind.am.domain.PlanActivationHistory> activatedPlans = planActivationHistoryRepo.findByOwnerId(body.getOwnerId());
        Double price = planServiceBusiness.calculateUpgradePrice(body, planFrom, planTo, activatedPlans);
        return planBuilder.calculatePlanUpgradePriceResponse(price);
    }

    @Override
    public GetPlanActivationHistoryResponse getActivationHistory(GetPlanActivationHistoryRequest body) {
        log.info("getPlanActivationHistory {}", body);
        List<ir.cliqmind.am.domain.PlanActivationHistory> planActivationHistories = planActivationHistoryRepo.findAll(body);
        log.debug("getPlanActivationHistory result = {}", planActivationHistories);
        return new GetPlanActivationHistoryResponse().
                totalCount(planActivationHistories==null ? 0 : planActivationHistories.size())
                .items(planActivationHistories==null ? null :
                        planActivationHistories.stream().map(pah -> planBuilder.planActivationHistory(pah)).collect(Collectors.toList()));
    }

    @Override
    public GetPlansResponse get(GetPlansRequest body) {
        log.info("getPlan {}", body);
        Iterable<ir.cliqmind.am.domain.Plan> entities = null;
        if(body.isActive()==null){
            entities = planRepo.findAllById(body.getIds());
        }
        else{
            entities = planRepo.find(body.getIds(), body.isActive());
        }
        List<ir.cliqmind.am.domain.PlanPrice> price = planPriceRepo.find(entities);
        if(price != null){
            Map<Integer, List<ir.cliqmind.am.domain.PlanPrice>> mapped = price.stream().collect(Collectors.groupingBy(pp -> pp.getId().getPlanId()));
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
        return planBuilder.plan(entities);
    }

    @Override
    public Transaction renew(RenewPlansRequest body) {
        log.info("renewPlan {}", body);
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
        return transactionBuilder.transaction(transaction);
    }

    @Override
    public ResponseMessage setFeatures(SetPlanFeaturesRequest body) {
        log.info("setPlanFeatures {}", body);
        ir.cliqmind.am.domain.Plan entity = findPlan(body.getId());
        if(entity == null || entity.getId() == null){
            throw new NotFoundException("plan does not exist");
        }
        entity.setPlanFeatures(planBuilder.planFeatures(body.getFeatures(), entity.getId()));
        planRepo.setFeatures(entity);
        return responseMessageBuilder.success();
    }

    @Override
    public ResponseMessage setPrice(SetPlanPriceRequest body) {
        log.info("setPlanPrice {}", body);
        ir.cliqmind.am.domain.Plan entity = findPlan(body.getId());
        if(entity == null || entity.getId() == null){
            throw new NotFoundException("plan does not exist");
        }
        entity.setPlanPrice(planBuilder.planPrices(body.getPrice(), entity.getId()));
        planRepo.setPrice(entity);
        return responseMessageBuilder.success();
    }

    @Override
    public Transaction upgrade(UpradePlanRequest body) {
        log.info("upgradePlan {}", body);
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
        return transactionBuilder.transaction(transaction);
    }

    private ResponseMessage activate(Integer id, boolean active){
        ir.cliqmind.am.domain.Plan entity = findPlan(id);
        if(entity == null || entity.getId() == null){
            throw new NotFoundException("plan does not exist");
        }
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

    private ir.cliqmind.am.domain.Plan findPlan(Integer id){
        return planRepo.findById(id).orElse(null);
    }
}
