package ir.cliqmind.am.mapper;

import ir.cliqmind.am.dto.TransactionRollback;
import ir.cliqmind.am.dto.Transactions;
import ir.cliqmind.am.dto.TransferCreditRequest;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

public class TransactionBuilder {

    public ir.cliqmind.am.domain.Transaction addTransactionRequest(ir.cliqmind.am.dto.AddTransactionRequest input) {
        ir.cliqmind.am.domain.Transaction result = new ir.cliqmind.am.domain.Transaction();
        result.setUserId(input.getUserId());
        result.setDeposit(true);
        result.setAmount(input.getAmount());
        result.setCurrency(input.getCurrency());
        result.setTransactionCode(input.getCode());
        result.setType(Arrays.stream(ir.cliqmind.am.domain.Transaction.TransactionType.values()).filter(
                e -> e.name().equalsIgnoreCase(input.getType())).findAny().orElse(null));
        result.setTime(new Timestamp(System.currentTimeMillis()));
        return result;
    }

    public ir.cliqmind.am.dto.Transaction addTransactionRequest(ir.cliqmind.am.domain.Transaction input) {
        return new ir.cliqmind.am.dto.Transaction()
                .id(input.getId())
                .userId(input.getUserId())
                .isDeposit(input.getDeposit())
                .amount(input.getAmount())
                .currency(input.getCurrency())
                .code(input.getTransactionCode())
                .type(input.getType().name());
    }

    public Transactions getTransactions(List<ir.cliqmind.am.domain.Transaction> input) {
        return new Transactions()
                .totalCount(input == null ? 0 : input.size())
                .transactions(input == null ? null :
                        input.stream().map(t -> transaction(t)).collect(Collectors.toList()));
    }

    public ir.cliqmind.am.dto.Transaction transaction(ir.cliqmind.am.domain.Transaction input) {
        return new ir.cliqmind.am.dto.Transaction()
                .id(input.getId())
                .userId(input.getUserId())
                .isDeposit(input.getDeposit())
                .amount(input.getAmount())
                .currency(input.getCurrency())
                .code(input.getTransactionCode())
                .type(input.getType().name())
                .rollback(new TransactionRollback()
                        .time(input.getRollbackTime())
                        .doneByUserId(input.getRollbackByUserId())
                        .description(input.getRollbackDescription()));
    }

    public List<ir.cliqmind.am.domain.Transaction> transferBalance(TransferCreditRequest body) {
        List<ir.cliqmind.am.domain.Transaction> result = new ArrayList<>();
        Timestamp time = new Timestamp(System.currentTimeMillis());
        result.add(transfer(body.getFromUserId(), body.getCurrency(), body.getAmount(), false, time,
                body.getCode()));
        result.add(transfer(body.getToUserId(), body.getCurrency(), body.getAmount(), true, time,
                body.getCode()));
        return result;
    }

    public ir.cliqmind.am.domain.Transaction transfer(
            UUID userId, String currency, double amount, boolean deposit, Timestamp time, String code) {
        ir.cliqmind.am.domain.Transaction result = new ir.cliqmind.am.domain.Transaction();
        result.setTime(time);
        result.setType(ir.cliqmind.am.domain.Transaction.TransactionType.TRANSFER);
        result.setCurrency(currency);
        result.setAmount(amount);
        result.setTransactionCode(deposit ? code : code+"_t");
        result.setUserId(userId);
        result.setDeposit(deposit);
        return result;
    }
}