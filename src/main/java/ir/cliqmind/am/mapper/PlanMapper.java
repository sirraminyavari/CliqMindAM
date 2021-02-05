package ir.cliqmind.am.mapper;

import ir.cliqmind.am.domain.PlanActivationHistory;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class PlanMapper {


    public ir.cliqmind.am.domain.Plan add(ir.cliqmind.am.dto.AddPlanRequest body) {
        ir.cliqmind.am.domain.Plan result = new ir.cliqmind.am.domain.Plan();
        result.setDescription(body.getDescription());
        result.setDurationInMonths(body.getDurationInMonths());
        result.setEnableAmount(body.isEnableAmount());
        result.setMaximumAmount(body.getMaximumAmount());
        result.setName(body.getName());
        result.setUserBased(body.isUserBased());
        return result;
    }

    public ir.cliqmind.am.dto.Plan plan(ir.cliqmind.am.domain.Plan entity) {
        return new ir.cliqmind.am.dto.Plan()
                .active(entity.getActive())
                .description(entity.getDescription())
                .durationInMonths(entity.getDurationInMonths())
                .enableAmount(entity.getEnableAmount())
                .id(entity.getId())
                .maximumAmount(entity.getMaximumAmount())
                .name(entity.getName())
                .userBased(entity.getUserBased())
                .features(features(entity.getPlanFeatures()))
                .price(price(entity.getPlanPrice()));
    }

    private List<ir.cliqmind.am.dto.PlanPriceItem> price(List<ir.cliqmind.am.domain.PlanPrice> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream().map(pp -> planPrice(pp)).collect(Collectors.toList());
    }

    private List<ir.cliqmind.am.dto.Feature> features(List<ir.cliqmind.am.domain.PlanFeature> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream().map(f -> planFeature(f)).collect(Collectors.toList());
    }

    private ir.cliqmind.am.dto.PlanPriceItem planPrice(ir.cliqmind.am.domain.PlanPrice entity) {
        return new ir.cliqmind.am.dto.PlanPriceItem()
                .currency(entity.getId().getCurrency())
                .price(entity.getPrice())
                .secondaryPrice(new ir.cliqmind.am.dto.PlanPriceItemSecondaryPrice()
                        .price(entity.getSecondaryPrice())
                        .expirationDate(entity.getSecondaryPriceExpirationDate())
                        .firstDate(entity.getSecondaryPriceFirstDate())
                );
    }

    private ir.cliqmind.am.dto.Feature planFeature(ir.cliqmind.am.domain.PlanFeature entity) {
        ir.cliqmind.am.dto.Feature result = new ir.cliqmind.am.dto.Feature()
                .amount(entity.getAmount());
        if (entity.getFeature() != null) {
            result
                    .id(entity.getFeature().getId())
                    .name(entity.getFeature().getName())
                    .description(entity.getFeature().getDescription())
                    .active(entity.getFeature().getActive());
        }
        return result;
    }

    private ir.cliqmind.am.domain.PlanFeature planFeature(ir.cliqmind.am.dto.PlanFeaturesInner entity, Integer planId) {
        ir.cliqmind.am.domain.PlanFeature result = new ir.cliqmind.am.domain.PlanFeature();
        ir.cliqmind.am.domain.PlanFeatureId id = new ir.cliqmind.am.domain.PlanFeatureId();
        id.setFeatureId(entity.getFeatureId());
        id.setPlanId(planId);
        result.setId(id);
        result.setAmount(entity.getAmount());
        result.setMaximumAmount(entity.getMaximumAmount());
        return result;
    }

    private ir.cliqmind.am.domain.PlanPrice planPrice(ir.cliqmind.am.dto.PlanPricesInner entity, Integer planId) {
        ir.cliqmind.am.domain.PlanPrice result = new ir.cliqmind.am.domain.PlanPrice();
        ir.cliqmind.am.domain.PlanPriceId id = new ir.cliqmind.am.domain.PlanPriceId();
        id.setCurrency(entity.getCurrency());
        id.setPlanId(planId);
        result.setId(id);
        result.setPrice(entity.getPrice());
        ir.cliqmind.am.dto.PlanPriceItemSecondaryPrice planPriceItemSecondaryPrice = entity.getSecondaryPrice();
        if(planPriceItemSecondaryPrice!=null) {
            result.setSecondaryPrice(planPriceItemSecondaryPrice.getPrice());
            result.setSecondaryPriceExpirationDate(planPriceItemSecondaryPrice.getExpirationDate());
            result.setSecondaryPriceFirstDate(planPriceItemSecondaryPrice.getFirstDate());
        }
        return result;
    }

    public List<ir.cliqmind.am.domain.PlanFeature> planFeatures(ir.cliqmind.am.dto.PlanFeatures entities, Integer planId) {
        if(entities == null){
            return null;
        }
        return entities.stream().map(pf -> planFeature(pf, planId)).collect(Collectors.toList());
    }

    public List<ir.cliqmind.am.domain.PlanPrice> planPrices(ir.cliqmind.am.dto.PlanPrices entities, Integer planId) {
        if(entities == null){
            return null;
        }
        return entities.stream().map(pp -> planPrice(pp, planId)).collect(Collectors.toList());
    }

    public ir.cliqmind.am.dto.Plans plan(Iterable<ir.cliqmind.am.domain.Plan> input){
        ir.cliqmind.am.dto.Plans result = new ir.cliqmind.am.dto.Plans();
        if(input==null){
            return result;
        }
        Iterator<ir.cliqmind.am.domain.Plan> it = input.iterator();
        while (it.hasNext()){
            result.add(plan(it.next()));
        }
        return result;
    }

    public ir.cliqmind.am.dto.Price calculatePrice(Double price) {
        return new ir.cliqmind.am.dto.Price()
                .price(price);
    }

    public ir.cliqmind.am.dto.PlanActivationItem planActivationHistory(PlanActivationHistory pah) {
        LocalDate now = LocalDate.now();
        return new ir.cliqmind.am.dto.PlanActivationItem()
                .activatedByUserId(pah.getActivatedBy())
                .amount(pah.getAmount())
                .expirationDate(pah.getExpirationDate())
                .id(pah.getId())
                .isActive(pah.getActivatedBy()!=null)
                .isExpired(pah.getExpirationDate().compareTo(now) < 0)
                .plan(plan(pah.getPlan()))
                .ownerId(pah.getOwnerId())
                .startDate(pah.getStartDate())
                .time(pah.getTime())
                .transaction(pah.getTransactionId()==null ? null : new ir.cliqmind.am.dto.Transaction().id(pah.getTransactionId()))
                .upgradedFromPlan(pah.getUpgradedFromPlanId()==null ? null : new ir.cliqmind.am.dto.Plan().id(pah.getUpgradedFromPlanId()));
    }

}