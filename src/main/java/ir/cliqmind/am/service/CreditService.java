package ir.cliqmind.am.service;

import ir.cliqmind.am.dto.*;

public interface CreditService {

    GetCreditBalanceResponse getCreditBalance(GetCreditBalanceRequest body);

    Transactions transfer(TransferCreditRequest body);

}
