package com.company.controller;

import com.company.model.BigIntNum;

import java.math.BigInteger;

/**
 * Performs big integer arithmetic operations.
 */
public class BigIntegerCalculator extends NumericCalculator {

    /**
     *  Constructs a big integer calculator.
     */
    public BigIntegerCalculator() {
    }

    /**
     * Adds two big integers.
     *
     * @param bigInteger1 First big integer.
     * @param bigInteger2 Second big integer.
     * @return Sum of two big integers.
     */
    public BigIntNum add(BigIntNum bigInteger1, BigIntNum bigInteger2) {
        BigInteger bigIntNum1 = bigInteger1.getBigIntNum();
        BigInteger bigIntNum2 = bigInteger2.getBigIntNum();
        return new BigIntNum(bigIntNum1.add(bigIntNum2));
    }

    /**
     * Subtracts two big integers.
     *
     * @param bigInteger1 First big integer.
     * @param bigInteger2 Second big integer.
     * @return Difference of two big integers
     */
    public BigIntNum subtract(BigIntNum bigInteger1, BigIntNum bigInteger2) {
        BigInteger bigIntNum1 = bigInteger1.getBigIntNum();
        BigInteger bigIntNum2 = bigInteger2.getBigIntNum();
        return new BigIntNum(bigIntNum1.subtract(bigIntNum2));
    }

    /**
     * Multiplies two big integers.
     *
     * @param bigInteger1 First big integer.
     * @param bigInteger2 Second big integer.
     * @return Product of two big integers
     */
    public BigIntNum multiply(BigIntNum bigInteger1, BigIntNum bigInteger2) {
        BigInteger bigIntNum1 = bigInteger1.getBigIntNum();
        BigInteger bigIntNum2 = bigInteger2.getBigIntNum();
        return new BigIntNum(bigIntNum1.multiply(bigIntNum2));
    }


    /**
     * Divides two big integers.
     *
     * @param bigInteger1 First big integer.
     * @param bigInteger2 Second big integer.
     * @return Ratio of two big integers.
     */
    public BigIntNum divide(BigIntNum bigInteger1, BigIntNum bigInteger2) {
        BigInteger bigIntNum1 = bigInteger1.getBigIntNum();
        BigInteger bigIntNum2 = bigInteger2.getBigIntNum();
        return new BigIntNum(bigIntNum1.divide(bigIntNum2));
    }
}
