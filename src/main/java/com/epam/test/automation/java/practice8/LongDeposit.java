package com.epam.test.automation.java.practice8;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LongDeposit extends Deposit implements Prolongable {
    public LongDeposit(BigDecimal depositAmount, int depositPeriod) {
        super(depositAmount, depositPeriod);
    }

    @Override
    public BigDecimal income() {
        BigDecimal incomeAmount = amount;
        if (period <= 6) {
            return BigDecimal.ZERO.setScale(0);
        }
        for (int i = 7; i <= period; i++) {
            incomeAmount = incomeAmount.add((incomeAmount.multiply(BigDecimal.valueOf(15))).divide(BigDecimal.valueOf(100)));
        }
        incomeAmount = incomeAmount.setScale(2, RoundingMode.HALF_DOWN);
        incomeAmount = incomeAmount.subtract(amount);
        return incomeAmount;
    }

    public boolean canToProlong() {
        return period < 36;
    }
}
