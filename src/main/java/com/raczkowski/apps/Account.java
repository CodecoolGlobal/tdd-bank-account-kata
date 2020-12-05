package com.raczkowski.apps;

import java.util.List;

public class Account implements AccountService {

    private final Transactions transactions;
    private int balance;

    public Account() {
        this.transactions = new Transactions();
    }

    @Override
    public void deposit(int amount) {
        balance += amount;
        transactions.addTransaction(amount, balance);
    }

    @Override
    public void withdraw(int amount) {
        balance -= amount;
        transactions.addTransaction(-amount, balance);
    }

    @Override
    public List<String> getTransactionHistory() {
        return transactions.getTransactions();
    }

}
