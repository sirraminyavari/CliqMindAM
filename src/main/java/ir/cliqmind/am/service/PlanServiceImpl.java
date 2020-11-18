package ir.cliqmind.am.service;

import ir.cliqmind.am.dao.PlanRepo;
import ir.cliqmind.am.dto.*;
import ir.cliqmind.am.error.NotFoundException;
import ir.cliqmind.am.mapper.PlanBuilder;
import ir.cliqmind.am.mapper.ResponseMessageBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanServiceImpl implements PlanService{


    private static final Logger log = LoggerFactory.getLogger(PlanServiceImpl.class);

    @Autowired
    private PlanRepo planRepo;

    private PlanBuilder planBuilder;

    private ResponseMessageBuilder responseMessageBuilder;

    @Autowired
    public PlanServiceImpl(){
        planBuilder = new PlanBuilder();
        responseMessageBuilder = new ResponseMessageBuilder();
    }

    @Override
    public ResponseMessage activate(ActivatePlanRequest body) {
        return activate(body.getId(), true);
    }

    @Override
    public ResponseMessage deactivate(DeactivatePlanRequest body) {
        return activate(body.getId(), false);
    }

    @Override
    public Plan add(AddPlanRequest body) {
        log.info("addPlan {}", body);
        ir.cliqmind.am.domain.Plan entity = planRepo.save(planBuilder.add(body));
        Plan response = planBuilder.plan(entity);
        log.debug("addPlan, result = {}", response);
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
        return null;
    }

    @Override
    public CalculatePlanPriceResponse calculatePrice(CalculatePlanPriceRequest body) {
        return null;
    }

    @Override
    public CalculatePlanRenewalPriceResponse calculateRenewalPrice(CalculatePlanRenewalPriceRequest body) {
        return null;
    }

    @Override
    public Transaction calculateUpgradePrice(CalculatePlanUpgradeRequest body) {
        return null;
    }

    @Override
    public GetPlanActivationHistoryResponse getActivationHistory(GetPlanActivationHistoryRequest body) {
        return null;
    }

    @Override
    public GetPlansResponse get(GetPlansRequest body) {
        return null;
    }

    @Override
    public Transaction renew(RenewPlansRequest body) {
        return null;
    }

    @Override
    public ResponseMessage setFeatures(SetPlanFeaturesRequest body) {
        return null;
    }

    @Override
    public ResponseMessage setPrice(SetPlanPriceRequest body) {
        return null;
    }

    @Override
    public Transaction upgrade(UpradePlanRequest body) {
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
