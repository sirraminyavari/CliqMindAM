package ir.cliqmind.am.dao;

import ir.cliqmind.am.domain.Transaction;
import ir.cliqmind.am.dto.GetTransactionsRequest;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface TransactionRepoCustom {

    List<Transaction> getTransactionsRequest(GetTransactionsRequest query);

    Map<String, Double> getCreditBalance(UUID userId, String currency);
}
