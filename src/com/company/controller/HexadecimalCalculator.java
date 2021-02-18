package com.company.controller;

import com.company.model.Decimal;
import com.company.model.Hexadecimal;

public class HexadecimalCalculator extends NumericCalculator implements HexadecimalCalcInterface{

    public Hexadecimal add(Hexadecimal hex1, Hexadecimal hex2) {
        double a = (hexadecimalToDecimal(hex1).getDecimal());
        double b = (hexadecimalToDecimal(hex2).getDecimal());
        double result = a + b;
        Decimal decimal = new Decimal(result);
        return decimalToHexadecimal(decimal);
    }

    public Hexadecimal subtract(Hexadecimal hex1, Hexadecimal hex2) {
        double a = (hexadecimalToDecimal(hex1).getDecimal());
        double b = (hexadecimalToDecimal(hex2).getDecimal());
        double result = a - b;
        Decimal decimal = new Decimal(result);
        return decimalToHexadecimal(decimal);
    }

    public Hexadecimal multiply(Hexadecimal hex1, Hexadecimal hex2) {
        double a = (hexadecimalToDecimal(hex1).getDecimal());
        double b = (hexadecimalToDecimal(hex2).getDecimal());
        double result = a * b;
        Decimal decimal = new Decimal(result);
        return decimalToHexadecimal(decimal);
    }

    public Hexadecimal divide(Hexadecimal hex1, Hexadecimal hex2) {
        double a = (hexadecimalToDecimal(hex1).getDecimal());
        double b = (hexadecimalToDecimal(hex2).getDecimal());
        double result = a / b;
        Decimal decimal = new Decimal(result);
        return decimalToHexadecimal(decimal);
    }

    /**
     * Converts decimal to hexadecimal
     *
     * @param decimal
     * @return hexadecimal
     */
    public Hexadecimal decimalToHexadecimal(Decimal decimal) {
        int remainder;
        String hexadecimal = "";
        char hex[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        while (((int)decimal.getDecimal()) > 0) {
            remainder = ((int) decimal.getDecimal()) % 16;
            hexadecimal = hex[remainder] + hexadecimal;
            decimal.setDecimal((double)((int)decimal.getDecimal()) / 16);
        }
        return new Hexadecimal(hexadecimal);
    }

    /**
     * Converts hexadecimal to decimal
     *
     * @param hexadecimal
     * @return decimal
     */
    public Decimal hexadecimalToDecimal(Hexadecimal hexadecimal) {
        String digits = "0123456789ABCDEF";
        hexadecimal.setHexadecimal(hexadecimal.getHexadecimal().toUpperCase());
        int decimal = 0;
        for (int i = 0; i < hexadecimal.getHexadecimal().length(); i++) {
            char c = hexadecimal.getHexadecimal().charAt(i);
            int d = digits.indexOf(c);
            decimal = 16 * decimal + d;
        }
        return new Decimal((double) decimal);
    }
}
