package ir.cliqmind.am.dao;

import ir.cliqmind.am.domain.Plan;
import ir.cliqmind.am.domain.PlanActivationHistory;
import ir.cliqmind.am.domain.Transaction;
import ir.cliqmind.am.dto.UpradePlanRequest;

import java.util.List;

public interface PlanActivationHistoryRepoCustom {

    Transaction performBuyTransaction(ir.cliqmind.am.dto.BuyPlanRequest buyPlanRequest, Plan plan, java.sql.Date expirationDate);

    Transaction performRenewTransaction(ir.cliqmind.am.dto.RenewPlansRequest body, List<Plan> plans, List<PlanActivationHistory> activatedPlans);

    List<PlanActivationHistory> findAll(ir.cliqmind.am.dto.GetPlanActivationHistoryRequest body);

    Transaction performUpgradeTransaction(UpradePlanRequest body, Plan planFrom, Plan planTo, List<PlanActivationHistory> activatedPlans);
}
