package ir.cliqmind.am.service;

import ir.cliqmind.am.dto.*;

public interface PlanService {

    ResponseMessage activate(ActivatePlanRequest body);

    ResponseMessage deactivate(DeactivatePlanRequest body);

    Plan add(AddPlanRequest body);

    ResponseMessage edit(EditPlanRequest body);

    Transaction buy(BuyPlanRequest body);

    CalculatePlanPriceResponse calculatePrice(CalculatePlanPriceRequest body);

    CalculatePlanRenewalPriceResponse calculateRenewalPrice(CalculatePlanRenewalPriceRequest body);

    Transaction calculateUpgradePrice(CalculatePlanUpgradeRequest body);

    GetPlanActivationHistoryResponse getActivationHistory(GetPlanActivationHistoryRequest body);

    GetPlansResponse get(GetPlansRequest body);

    Transaction renew(RenewPlansRequest body);

    ResponseMessage setFeatures(SetPlanFeaturesRequest body);

    ResponseMessage setPrice(SetPlanPriceRequest body);

    Transaction upgrade(UpradePlanRequest body);

}
