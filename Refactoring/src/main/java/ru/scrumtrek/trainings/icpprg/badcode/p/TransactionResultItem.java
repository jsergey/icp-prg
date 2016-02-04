package ru.scrumtrek.trainings.icpprg.badcode.p;


import java.text.Collator;

public class TransactionResultItem {
    private Integer accountId;
    private Integer transactionTypeId;
    private boolean mainTransaction;
    private Double amount;

    public Integer getAccountId() {
        return accountId;
    }

    public Integer getTransactionTypeId() {
        return transactionTypeId;
    }

    public boolean getMainTransaction() {
        return mainTransaction;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
