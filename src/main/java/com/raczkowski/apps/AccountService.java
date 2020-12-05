package com.raczkowski.apps;

import java.util.List;

public interface AccountService {
    void deposit(int amount);

    void withdraw(int amount);

    List<String> getTransactionHistory();
}