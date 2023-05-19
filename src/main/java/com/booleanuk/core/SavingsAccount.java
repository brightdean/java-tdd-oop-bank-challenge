package com.booleanuk.core;

import java.math.BigDecimal;

public class SavingsAccount extends Account{
    public SavingsAccount(double initialBalance) throws IllegalArgumentException{
        super(10, false, 2.0f, BigDecimal.valueOf(initialBalance));
    }
}
