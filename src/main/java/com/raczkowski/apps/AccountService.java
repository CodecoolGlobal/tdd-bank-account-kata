package com.raczkowski.apps;

public interface AccountService {
    void deposit(int amount);

    void withdraw(int amount);

    void printStatement();
}