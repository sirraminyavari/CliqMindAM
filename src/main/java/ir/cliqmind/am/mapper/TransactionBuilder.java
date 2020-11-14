package ir.cliqmind.am.mapper;

import ir.cliqmind.am.dto.TransactionRollback;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

public class TransactionBuilder {

    public ir.cliqmind.am.domain.Transaction addTransactionRequest(ir.cliqmind.am.dto.AddTransactionRequest input){
        ir.cliqmind.am.domain.Transaction result = new ir.cliqmind.am.domain.Transaction();
        result.setUserId(input.getUserId());
        result.setDeposit(input.isIsDeposit());
        result.setAmount(input.getAmount());
        result.setCurrency(input.getCurrency());
        result.setTransactionCode(input.getCode());
        result.setType(Arrays.stream(ir.cliqmind.am.domain.Transaction.TransactionType.values()).filter(
                e -> e.name().equalsIgnoreCase(input.getType())).findAny().orElse(null));
        result.setTime(new Timestamp(System.currentTimeMillis()));
        return result;
    }

    public ir.cliqmind.am.dto.Transaction addTransactionRequest(ir.cliqmind.am.domain.Transaction input){
        return new ir.cliqmind.am.dto.Transaction()
                .id(input.getId())
                .userId(input.getUserId())
                .isDeposit(input.getDeposit())
                .amount(input.getAmount())
                .currency(input.getCurrency())
                .code(input.getTransactionCode())
                .type(input.getType().name());
    }

    private Date time(Timestamp input){
        return new Date(input.getTime());
    }

}
