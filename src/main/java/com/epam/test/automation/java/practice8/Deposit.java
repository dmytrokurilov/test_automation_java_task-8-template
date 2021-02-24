package com.epam.test.automation.java.practice8;

import java.math.BigDecimal;

public abstract class Deposit implements Comparable<Deposit> {
    public BigDecimal amount;
    final int period;

    public BigDecimal getAmount() {
        return amount;
    }

    public int getPeriod() {
        return period;
    }

    public int compareTo(Deposit other) {
        return totalAmount().compareTo(other.totalAmount());
    }

    protected Deposit(BigDecimal depositAmount, int depositPeriod) {
        amount = depositAmount;
        period = depositPeriod;
    }

    public abstract BigDecimal income();

    public BigDecimal totalAmount() {
        return amount.add(income());
    }
}
