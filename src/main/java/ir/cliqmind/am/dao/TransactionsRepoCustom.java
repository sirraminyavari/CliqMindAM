package ir.cliqmind.am.dao;

import ir.cliqmind.am.dto.GetTransactionsRequest;
import ir.cliqmind.am.domain.Transaction;

import java.util.List;

public interface TransactionsRepoCustom {

    List<Transaction> getTransactionsRequest(GetTransactionsRequest query);

}
