package ir.cliqmind.am.service;

import ir.cliqmind.am.dto.*;

public interface TransactionService {

    Transaction addTransaction(AddTransactionRequest body);

    Transactions getTransactions(GetTransactionsRequest body);

    ResponseMessage rollbackTransaction(RollbackTransactionRequest body);

}
