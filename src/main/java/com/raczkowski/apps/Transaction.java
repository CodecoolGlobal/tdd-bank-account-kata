package com.raczkowski.apps;

import java.util.Date;

public class Transaction {

    private final int amount;
    private final int balance;
    private final Date date;

    public Transaction(int amount, int balance, Date date) {
        this.amount = amount;
        this.balance = balance;
        this.date = date;
    }
}
