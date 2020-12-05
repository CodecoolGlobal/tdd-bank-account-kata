package com.raczkowski.apps;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Transactions {

    private List<String> transactions = new ArrayList<>();

    public void addTransaction(int amount, int balance) {
        transactions.add(formatTransactionMessage(amount, balance));
    }

    private String formatTransactionMessage(int amount, int balance) {
        return String.format("%s || %d || %d", getDateAsString(), amount, balance);
    }

    private String getDateAsString() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(new Date());
    }

    public List<String> getTransactions() {
        return transactions;
    }
}
