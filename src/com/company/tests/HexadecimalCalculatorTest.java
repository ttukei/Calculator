package com.company.tests;

import com.company.controller.HexadecimalCalculator;
import com.company.model.Decimal;
import com.company.model.Hexadecimal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HexadecimalCalculatorTest {

    HexadecimalCalculator hexadecimalCalculator = new HexadecimalCalculator();

    // TODO: add support for negative values
    Decimal decimal1 = new Decimal(1000.);
    Decimal decimal2 = new Decimal(534774885.);
    Decimal decimalResult = new Decimal();

    Hexadecimal hex1 = new Hexadecimal("8ABAB");
    Hexadecimal hex2 = new Hexadecimal("B78");
    Hexadecimal hex3 = new Hexadecimal("DAD45");
    Hexadecimal hex4 = new Hexadecimal("ffff");
    Hexadecimal hexResult = new Hexadecimal();


    @Test
    void add() {
        hexResult = hexadecimalCalculator.add(hex1, hex2);
        assertEquals("8B723", hexResult.getHexadecimal());
        hexResult = hexadecimalCalculator.add(hex3, hex4);
        assertEquals("EAD44", hexResult.getHexadecimal());
    }

    @Test
    void subtract() {
        hexResult = hexadecimalCalculator.subtract(hex1, hex2);
        assertEquals("8A033", hexResult.getHexadecimal());
        hexResult = hexadecimalCalculator.subtract(hex3, hex4);
        assertEquals("CAD46", hexResult.getHexadecimal());
    }

    @Test
    void multiply() {
        hexResult = hexadecimalCalculator.multiply(hex1, hex2);
        assertEquals("6370D128", hexResult.getHexadecimal());
        hexResult = hexadecimalCalculator.multiply(hex3, hex4);
        // TODO: Add support for larger numbers
        assertEquals("DAD3752BB", hexResult.getHexadecimal());
    }

    @Test
    void divide() {
        // TODO: Add support for remainders
        hexResult = hexadecimalCalculator.divide(hex1, hex2);
        assertEquals("C1", hexResult.getHexadecimal());
        hexResult = hexadecimalCalculator.divide(hex3, hex4);
        assertEquals("D", hexResult.getHexadecimal());
    }

    @Test
    void decimalToHexadecimal() {
        hexResult = hexadecimalCalculator.decimalToHexadecimal(decimal1);
        assertEquals("3E8", hexResult.getHexadecimal());
        hexResult = hexadecimalCalculator.decimalToHexadecimal(decimal2);
        assertEquals("1FE00465", hexResult.getHexadecimal());
    }

    @Test
    void hexadecimalToDecimal() {
        decimalResult = hexadecimalCalculator.hexadecimalToDecimal(hex1);
        assertEquals(568235.0, decimalResult.getDecimal());
        decimalResult = hexadecimalCalculator.hexadecimalToDecimal(hex4);
        assertEquals(65535.0, decimalResult.getDecimal());
    }
}