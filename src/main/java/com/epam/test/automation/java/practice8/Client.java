package com.epam.test.automation.java.practice8;

import java.math.BigDecimal;
import java.util.Arrays;


public class Client {
    private final Deposit[] deposits;

    public Client() {
        deposits = new Deposit[10];
    }


    public boolean addDeposit(Deposit deposit) {
        for (int i = 0; i < 10; i++) {
            if (deposits[i] == null) {
                deposits[i] = deposit;
                return true;
            }
        }
        return false;
    }

    public BigDecimal totalIncome() {
        BigDecimal sum = new BigDecimal(0);
        for (int i = 0; i < 10; i++) {
            if (deposits[i] != null) {
                sum = sum.add(deposits[i].income());
            }
        }
        return sum;
    }

    public BigDecimal maxIncome() {
        int max = 0;
        for (int i = 0; i < 10; i++) {
            if (deposits[i] != null && deposits[i].income().compareTo(deposits[max].income()) > 0)
                max = i;
        }
        assert deposits[max] != null;
        return deposits[max].income();
    }

    public BigDecimal getIncomeByNumber(int number) {

        BigDecimal incomeByNumber = BigDecimal.valueOf(0);
        if (deposits[number - 1] != null) {
            for (int i = 0; i < deposits.length; i++) {

                if (number == i + 1) {
                    incomeByNumber = deposits[i + 1].income();
                }
            }
        }
        return incomeByNumber;

    }


}
