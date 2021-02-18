package com.company.controller;

import com.company.model.BigIntNum;

import java.math.BigInteger;

public class BigIntegerCalculator extends NumericCalculator {

    public BigIntegerCalculator() {
    }


    public BigIntNum add(BigIntNum bigInteger1, BigIntNum bigInteger2) {
        BigInteger bigIntNum1 = bigInteger1.getBigIntNum();
        BigInteger bigIntNum2 = bigInteger2.getBigIntNum();
        BigIntNum result = new BigIntNum(bigIntNum1.add(bigIntNum2));
        return result;
    }

    public BigIntNum subtract(BigIntNum bigInteger1, BigIntNum bigInteger2) {
        BigInteger bigIntNum1 = bigInteger1.getBigIntNum();
        BigInteger bigIntNum2 = bigInteger2.getBigIntNum();
        BigIntNum bigIntNum = new BigIntNum(bigIntNum1.subtract(bigIntNum2));
        return bigIntNum;
    }

    public BigIntNum multiply(BigIntNum bigInteger1, BigIntNum bigInteger2) {
        BigInteger bigIntNum1 = bigInteger1.getBigIntNum();
        BigInteger bigIntNum2 = bigInteger2.getBigIntNum();
        BigIntNum bigIntNum = new BigIntNum(bigIntNum1.multiply(bigIntNum2));
        return bigIntNum;
    }

    public BigIntNum divide(BigIntNum bigInteger1, BigIntNum bigInteger2) {
        BigInteger bigIntNum1 = bigInteger1.getBigIntNum();
        BigInteger bigIntNum2 = bigInteger2.getBigIntNum();
        BigIntNum bigIntNum = new BigIntNum(bigIntNum1.divide(bigIntNum2));
        return bigIntNum;
    }
}
