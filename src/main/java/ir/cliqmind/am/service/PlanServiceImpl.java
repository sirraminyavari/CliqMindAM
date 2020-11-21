package ir.cliqmind.am.service;

import ir.cliqmind.am.dao.PlanFeatureRepo;
import ir.cliqmind.am.dao.PlanPriceRepo;
import ir.cliqmind.am.dao.PlanRepo;
import ir.cliqmind.am.dto.*;
import ir.cliqmind.am.error.NotFoundException;
import ir.cliqmind.am.mapper.PlanBuilder;
import ir.cliqmind.am.mapper.ResponseMessageBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PlanServiceImpl implements PlanService{


    private static final Logger log = LoggerFactory.getLogger(PlanServiceImpl.class);

    @Autowired
    private PlanRepo planRepo;

    @Autowired
    private PlanPriceRepo planPriceRepo;

    @Autowired
    private PlanFeatureRepo planFeatureRepo;

    private PlanBuilder planBuilder;

    private ResponseMessageBuilder responseMessageBuilder;

    @Autowired
    public PlanServiceImpl(){
        planBuilder = new PlanBuilder();
        responseMessageBuilder = new ResponseMessageBuilder();
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
        return null;
    }

    @Override
    public CalculatePlanPriceResponse calculatePrice(CalculatePlanPriceRequest body) {
        log.info("calculatePlanPrice {}", body);
        return null;
    }

    @Override
    public CalculatePlanRenewalPriceResponse calculateRenewalPrice(CalculatePlanRenewalPriceRequest body) {
        log.info("calculatePlanRenewalPrice {}", body);
        return null;
    }

    @Override
    public Transaction calculateUpgradePrice(CalculatePlanUpgradeRequest body) {
        log.info("calculatePlanUpgradePrice {}", body);
        return null;
    }

    @Override
    public GetPlanActivationHistoryResponse getActivationHistory(GetPlanActivationHistoryRequest body) {
        log.info("getPlanActivationHistory {}", body);
        return null;
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
        return null;
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
        return null;
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

    private ir.cliqmind.am.domain.Plan findPlan(Integer id){
        return planRepo.findById(id).orElse(null);
    }
}
