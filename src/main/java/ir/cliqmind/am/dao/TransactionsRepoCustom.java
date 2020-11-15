package ir.cliqmind.am.dao;

import ir.cliqmind.am.dto.GetTransactionsRequest;
import ir.cliqmind.am.domain.Transaction;
import ir.cliqmind.am.dto.TransferCreditRequest;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface TransactionsRepoCustom {

    List<Transaction> getTransactionsRequest(GetTransactionsRequest query);

    Map<String, Double> getCreditBalance(UUID userId, String currency);
}
