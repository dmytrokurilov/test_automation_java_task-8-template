package com.epam.test.automation.java.practice8;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class Client implements Iterable<Deposit> {
    private final List<Deposit> depositsList;

    public Client() {
        depositsList = Arrays.asList(new Deposit[10]);
    }

    public Iterator<Deposit> iterator() {
        return depositsList.iterator();
    }

    public boolean addDeposit(Deposit deposit) {
        for (int i = 0; i < 10; i++) {
            if (depositsList.get(i) == null) {
                depositsList.set(i, deposit);
                return true;
            }
        }
        return false;
    }

    public BigDecimal totalIncome() {
        BigDecimal sum = new BigDecimal(0);
        for (int i = 0; i < 10; i++) {
            if (depositsList.get(i) != null) {
                sum = sum.add(depositsList.get(i).income());
            }
        }
        return sum;
    }

    public BigDecimal maxIncome() {
        int max = 0;
        for (int i = 0; i < 10; i++) {
            if (depositsList.get(i) != null && depositsList.get(i).income().compareTo(depositsList.get(max).income()) > 0)
                max = i;
        }
        assert depositsList.get(max) != null;
        return depositsList.get(max).income();
    }

    public BigDecimal getIncomeByNumber(int number) {

        BigDecimal incomeByNumber = BigDecimal.valueOf(0);
        if (depositsList.get(number - 1) != null) {
            for (int i = 0; i < depositsList.size(); i++) {

                if (number == i + 1) {
                    incomeByNumber = depositsList.get(i + 1).income();
                }
            }
        }
        return incomeByNumber;
    }

    public void sortDeposits() {
        Collections.sort(depositsList, Collections.reverseOrder());
    }

    public int countPossibleToProlongDeposit() {
        int countPossibleToProlongDeposit = 0;
        for (Deposit deposit : depositsList) {
            if ((deposit instanceof Prolongable) && ((Prolongable) deposit).canToProlong()) {
                countPossibleToProlongDeposit++;
            }
        }
        return countPossibleToProlongDeposit;
    }

}
