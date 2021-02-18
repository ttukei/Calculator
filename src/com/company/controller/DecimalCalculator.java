package com.company.controller;

import com.company.model.Decimal;

public class DecimalCalculator extends NumericCalculator {

    public DecimalCalculator() {}

    public Decimal add(Decimal decimal1, Decimal decimal2) {
        double a = decimal1.getDecimal();
        double b = decimal2.getDecimal();
        double result = a + b;
        Decimal decimal = new Decimal(result);
        return decimal;
    }

    public Decimal subtract(Decimal decimal1, Decimal decimal2) {
        double a = decimal1.getDecimal();
        double b = decimal2.getDecimal();
        double result = a - b;
        Decimal decimal = new Decimal(result);
        return decimal;
    }

    public Decimal multiply(Decimal decimal1, Decimal decimal2) {
        double a = decimal1.getDecimal();
        double b = decimal2.getDecimal();
        double result = a * b;
        Decimal decimal = new Decimal(result);
        return decimal;
    }

    public Decimal divide(Decimal decimal1, Decimal decimal2) {
        double a = decimal1.getDecimal();
        double b = decimal2.getDecimal();
        double result = a / b;
        Decimal decimal = new Decimal(result);
        return decimal;
    }
}
