package com.epam.test.automation.java.practice8;

import java.math.BigDecimal;
import java.math.RoundingMode;

class BaseDeposit extends Deposit {
    public BaseDeposit(BigDecimal depositAmount, int depositPeriod) {

        super(depositAmount, depositPeriod);

    }

    @Override
    public BigDecimal income() {
        BigDecimal result = amount;
        for (int i = 1; i <= period; i++) {
            result = result.add((result.multiply(BigDecimal.valueOf(5))).divide(BigDecimal.valueOf(100)));
        }
        result = result.setScale( 2, RoundingMode.HALF_DOWN);
        result = result.subtract(amount);
        return result;
    }

}
