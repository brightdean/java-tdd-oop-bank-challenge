package com.booleanuk.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class Account {

    private int monthlyTransactionLimit;
    private boolean canOverdraft;
    private float interest;
    private BigDecimal balance;

    private List<Transaction> transactions;

    protected Account(BigDecimal initialBalance){
        this.balance = initialBalance.compareTo(BigDecimal.ZERO) > 0 ? initialBalance : BigDecimal.ZERO;
        this.transactions = new ArrayList<>();
    }

    protected Account(int monthlyTransactionLimit, boolean canOverdraft, float interest, BigDecimal initialBalance){
        this(initialBalance);
        this.monthlyTransactionLimit = monthlyTransactionLimit;
        this.canOverdraft = canOverdraft;
        this.interest = interest;
    }

    public int getMonthlyTransactionLimit() {
        return monthlyTransactionLimit;
    }

    public void setMonthlyTransactionLimit(int monthlyTransactionLimit) {
        this.monthlyTransactionLimit = monthlyTransactionLimit;
    }

    public boolean isCanOverdraft() {
        return canOverdraft;
    }

    public void setCanOverdraft(boolean canOverdraft) {
        this.canOverdraft = canOverdraft;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
