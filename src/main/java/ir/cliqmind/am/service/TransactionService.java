package ir.cliqmind.am.service;

import ir.cliqmind.am.dto.*;

public interface TransactionService {

    Transaction add(AddTransactionRequest body);

    Transactions get(GetTransactionsRequest body);

    ResponseMessage rollback(RollbackTransactionRequest body);

}
