package com.company.controller;

import com.company.model.Binary;
import com.company.model.Decimal;

/**
 * Specifies conversion behaviors of a binary calculator.
 */
public interface BinaryCalcInterface {

    /**
     * Converts decimal to binary.
     *
     * @param decimal Decimal to convert.
     * @return Binary representation of inputted decimal.
     */
    Binary decimalToBinary(Decimal decimal);

    /**
     * Converts binary to decimal.
     *
     * @param binary Binary to convert.
     * @return Decimal representation of inputted binary.
     */
    Decimal binaryToDecimal(Binary binary);
}
