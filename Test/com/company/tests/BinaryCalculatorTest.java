package com.company.tests;

import com.company.controller.BinaryCalculator;
import com.company.model.Binary;
import com.company.model.Decimal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryCalculatorTest {

    BinaryCalculator binaryCalculator = new BinaryCalculator();

    // TODO: add support for negative values
    Decimal decimal1 = new Decimal(100.);
    Decimal decimal2 = new Decimal(1000.);
    Decimal decimalResult = new Decimal();

    Binary binary1 = new Binary(101001);
    Binary binary2 = new Binary(10101);
    Binary binary3 = new Binary(10101010);
    Binary binary4 = new Binary(10);
    Binary binaryResult = new Binary();



    @Test
    void add() {
        binaryResult = binaryCalculator.add(binary1, binary2);
        assertEquals(111110, binaryResult.getBinary());
        binaryResult = binaryCalculator.add(binary3, binary4);
        assertEquals(10101100, binaryResult.getBinary());
    }

    @Test
    void subtract() {
        binaryResult = binaryCalculator.subtract(binary1, binary2);
        assertEquals(10100, binaryResult.getBinary());
        binaryResult = binaryCalculator.subtract(binary3, binary4);
        assertEquals(10101000, binaryResult.getBinary());
    }

    @Test
    void multiply() {
        binaryResult = binaryCalculator.multiply(binary1, binary2);
        assertEquals(1101011101, binaryResult.getBinary());
        binaryResult = binaryCalculator.multiply(binary3, binary4);
        assertEquals(101010100, binaryResult.getBinary());
    }

    @Test
    void divide() {
        binaryResult = binaryCalculator.divide(binary1, binary2);
        assertEquals(1, binaryResult.getBinary());
        binaryResult = binaryCalculator.divide(binary3, binary4);
        assertEquals(1010101, binaryResult.getBinary());
    }

    @Test
    void decimalToBinary() {
        binaryResult = binaryCalculator.decimalToBinary(decimal1);
        assertEquals(1100100, binaryResult.getBinary());
        binaryResult = binaryCalculator.decimalToBinary(decimal2);
        assertEquals(1111101000, binaryResult.getBinary());
    }

    @Test
    void binaryToDecimal() {
        decimalResult = binaryCalculator.binaryToDecimal(binary1);
        assertEquals(41.0, decimalResult.getDecimal());
        decimalResult = binaryCalculator.binaryToDecimal(binary4);
        assertEquals(2.0, decimalResult.getDecimal());
    }
}