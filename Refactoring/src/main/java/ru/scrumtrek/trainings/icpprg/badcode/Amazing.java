package ru.scrumtrek.trainings.icpprg.badcode;

import ru.scrumtrek.trainings.icpprg.badcode.p.Account;
import ru.scrumtrek.trainings.icpprg.badcode.p.AccountType;
import ru.scrumtrek.trainings.icpprg.badcode.p.TransactionResultItem;

import java.text.Collator;
import java.util.List;

public class Amazing {

    private Integer salesTaxPayableAccountId;

    public void updateAmountValues(List<TransactionResultItem> transactionResultItems) {
        for (TransactionResultItem transaction : transactionResultItems) {
            Account account = getAccountById(transaction.getAccountId());
            if ((transaction.getMainTransaction()
                    && !transaction.getTransactionTypeId().equals(4)
                    && !transaction.getTransactionTypeId().equals(5)
                    && !transaction.getTransactionTypeId().equals(6))
                    ||
                    (!transaction.getMainTransaction() &&
                            (transaction.getTransactionTypeId().equals(5) &&
                                    ((account.getAccountTypeId().equals(AccountType.INCOME_TYPE_ID) ||
                                            account.getAccountTypeId().equals(AccountType.OTHER_INCOME_TYPE_ID)) &&
                                            transaction.getAmount() > 0)
                                    || (transaction.getAccountId().equals(getSalesTaxPayableAccountId()) && transaction.getAmount() > 0)
                                    || ((account.getAccountTypeId().equals(AccountType.EXPENSE_TYPE_ID) ||
                                    account.getAccountTypeId().equals(AccountType.OTHER_EXPENSE_TYPE_ID)) && transaction.getAmount() < 0))
                            || (transaction.getTransactionTypeId().equals(1) &&
                            (account.getAccountTypeId().equals(AccountType.INCOME_TYPE_ID) ||
                                    account.getAccountTypeId().equals(AccountType.OTHER_INCOME_TYPE_ID)) &&
                            transaction.getAmount() < 0)
                            || (transaction.getTransactionTypeId().equals(2) &&
                            (account.getAccountTypeId().equals(AccountType.INCOME_TYPE_ID) ||
                                    account.getAccountTypeId().equals(AccountType.OTHER_INCOME_TYPE_ID)) &&
                            transaction.getAmount() > 0)
                    )) {
                Double amount = transaction.getAmount();
                transaction.setAmount(-amount);
            }
        }
    }

    private Account getAccountById(Integer accountId) {
        return null;
    }


    public Integer getSalesTaxPayableAccountId() {
        return salesTaxPayableAccountId;
    }
}
