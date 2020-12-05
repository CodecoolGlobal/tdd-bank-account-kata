package com.raczkowski.apps;

import java.util.List;

public class Account implements AccountService {

    Transactions transactions = new Transactions();
    private int balance = 0;

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
