package com.company.controller;

import com.company.model.Hexadecimal;
import com.company.model.Decimal;

/**
 * Specifies conversion behaviors of a hexadecimal calculator.
 */
public interface HexadecimalCalcInterface {

    /**
     * Converts decimal to hexadecimal.
     *
     * @param decimal Decimal to be converted.
     * @return Hexadecimal value of inputted decimal.
     */
    Hexadecimal decimalToHexadecimal(Decimal decimal);

    /**
     * Converts hexadecimal to decimal.
     *
     * @param hexadecimal hexadecimal to be converted.
     * @return Decimal value of inputted decimal.
     */
    Decimal hexadecimalToDecimal(Hexadecimal hexadecimal);
}
