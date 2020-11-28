package ir.cliqmind.am.dao;

import ir.cliqmind.am.domain.Plan;
import ir.cliqmind.am.domain.Transaction;

public interface PlanActivationHistoryRepoCustom {

    Transaction performBuyTransaction(ir.cliqmind.am.dto.BuyPlanRequest buyPlanRequest, Plan plan, java.sql.Date expirationDate);

}
