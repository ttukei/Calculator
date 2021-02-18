package com.company.tests;

import com.company.controller.BigIntegerCalculator;
import com.company.model.BigIntNum;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class BigIntegerCalculatorTest {

    BigIntegerCalculator bigintegerCalculator = new BigIntegerCalculator();

    BigInteger val1 = new BigInteger("34524438974598723409587203948720983670293847509283745098");
    BigInteger val2 = new BigInteger("34523458298347095828934095827349087029348572394857023498" +
            "75029348760239485702934875029834750293847098237609823475098234750982347509827034985");

    BigIntNum bigIntNum1 = new BigIntNum(val1);
    BigIntNum bigIntNum2 = new BigIntNum(val2);

    @Test
    void add() {
        assertEquals(val1.add(val2), bigintegerCalculator.add(bigIntNum1, bigIntNum2).getBigIntNum());
    }

    @Test
    void subtract() {
        assertEquals(val1.subtract(val2), bigintegerCalculator.subtract(bigIntNum1, bigIntNum2).getBigIntNum());
    }

    @Test
    void multiply() {
        assertEquals(val1.multiply(val2), bigintegerCalculator.multiply(bigIntNum1, bigIntNum2).getBigIntNum());
    }

    @Test
    void divide() {
        assertEquals(val1.divide(val2), bigintegerCalculator.divide(bigIntNum1, bigIntNum2).getBigIntNum());
    }

}