package com.company.controller;

import com.company.model.Decimal;

/**
 * Performs decimal arithmetic operations
 */
public class DecimalCalculator extends NumericCalculator {

    /**
     *  Creates a decimal calculator.
     */
    public DecimalCalculator() {}

    /**
     * Adds two decimal numbers.
     *
     * @param decimal1 First decimal number.
     * @param decimal2 Second decimal number.
     * @return Sum of two decimal numbers.
     */
    public Decimal add(Decimal decimal1, Decimal decimal2) {
        double a = decimal1.getDecimal();
        double b = decimal2.getDecimal();
        return new Decimal(a + b);
    }

    /**
     * Adds two decimal numbers.
     *
     * @param decimal1 First decimal number.
     * @param decimal2 Second decimal number.
     * @return Sum of two decimal numbers.
     */
    public Decimal subtract(Decimal decimal1, Decimal decimal2) {
        double a = decimal1.getDecimal();
        double b = decimal2.getDecimal();
        return new Decimal(a - b);
    }

    /**
     * Multiplies two decimal numbers.
     *
     * @param decimal1 First decimal number.
     * @param decimal2 Second decimal number.
     * @return Product of two decimal numbers.
     */
    public Decimal multiply(Decimal decimal1, Decimal decimal2) {
        double a = decimal1.getDecimal();
        double b = decimal2.getDecimal();
        return new Decimal(a * b);
    }

    /**
     * Divides two decimal numbers.
     *
     * @param decimal1 First decimal number.
     * @param decimal2 Second decimal number.
     * @return Ratio of two decimal numbers.
     */
    public Decimal divide(Decimal decimal1, Decimal decimal2) {
        double a = decimal1.getDecimal();
        double b = decimal2.getDecimal();
        return new Decimal(a / b);
    }
}
