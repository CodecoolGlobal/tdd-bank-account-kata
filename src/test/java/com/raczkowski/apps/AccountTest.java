package com.raczkowski.apps;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AccountTest {

    @Test
    public void should_deposit_money_and_return_transactions() {
        // given:
        List<String> before = Lists.emptyList();
        List<String> after = Collections.singletonList(String.format("%s || 600 || 600", getTodaysDate()));
        Account account = new Account();

        // when:
        List<String> beforeResult = account.getTransactionHistory();
        account.deposit(600);
        List<String> afterResult = account.getTransactionHistory();

        // then:
        assertTrue(beforeResult.containsAll(before));
        assertTrue(afterResult.containsAll(after));
    }

    @Test
    public void should_withdraw_money_and_return_transactions() {
        // given:
        List<String> before = Lists.emptyList();
        List<String> after = Collections.singletonList(String.format("%s || -600 || -600", getTodaysDate()));
        Account account = new Account();

        // when:
        List<String> beforeResult = account.getTransactionHistory();
        account.withdraw(600);
        List<String> afterResult = account.getTransactionHistory();

        // then:
        assertTrue(beforeResult.containsAll(before));
        assertTrue(afterResult.containsAll(after));
    }

    @Test
    public void should_new_account_return_empty_transactions() {
        // given:
        Account account = new Account();

        // when:
        List<String> result = account.getTransactionHistory();

        // then:
        assertEquals(0, result.size());
    }

    @Test
    public void should_perform_many_operations_and_return_correct_transactions_history() {
        // given:
        List<String> before = Lists.emptyList();
        List<String> after = Arrays.asList(
                String.format("%s || 600 || 600", getTodaysDate()),
                String.format("%s || -300 || 300", getTodaysDate()),
                String.format("%s || 600 || 900", getTodaysDate()),
                String.format("%s || -100 || 800", getTodaysDate())
        );

        Account account = new Account();

        // when:
        List<String> beforeResult = account.getTransactionHistory();
        account.deposit(600);
        account.withdraw(300);
        account.deposit(600);
        account.withdraw(100);
        List<String> afterResult = account.getTransactionHistory();

        // then:
        assertTrue(beforeResult.containsAll(before));
        assertTrue(afterResult.containsAll(after));
    }

    private String getTodaysDate() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(new Date());
    }

}