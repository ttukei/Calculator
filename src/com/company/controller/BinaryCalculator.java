package com.company.controller;

import com.company.model.Decimal;
import com.company.model.Binary;

/**
 * Performs binary arithmetic operations and conversions..
 */
public class BinaryCalculator extends NumericCalculator implements BinaryCalcInterface {

    /**
     * Creates a binary calculator.
     */
    public BinaryCalculator() {}

    /**
     * Adds two binary numbers.
     *
     * @param binary1 First binary number.
     * @param binary2 Second binary number.
     * @return Sum of binary numbers.
     */
    public Binary add(Binary binary1, Binary binary2) {
        double a = binaryToDecimal(binary1).getDecimal();
        double b = binaryToDecimal(binary2).getDecimal();
        double result = a + b;
        Decimal decimal = new Decimal(result);
        return decimalToBinary(decimal);
    }

    /**
     * Subtracts two binary numbers
     *
     * @param binary1 First binary number.
     * @param binary2 Second binary number.
     * @return Difference of two binary numbers.
     */
    public Binary subtract(Binary binary1, Binary binary2) {
        double a = binaryToDecimal(binary1).getDecimal();
        double b = binaryToDecimal(binary2).getDecimal();
        double result = a - b;
        Decimal decimal = new Decimal(result);
        return decimalToBinary(decimal);
    }

    /**
     * Multiplies two binary numbers
     *
     * @param binary1 First binary number.
     * @param binary2 Second binary number.
     * @return Product of two binary numbers.
     */
    public Binary multiply(Binary binary1, Binary binary2) {
        double a = binaryToDecimal(binary1).getDecimal();
        double b = binaryToDecimal(binary2).getDecimal();
        double result = a * b;
        Decimal decimal = new Decimal(result);
        return decimalToBinary(decimal);
    }

    /**
     * Divides two binary numbers
     *
     * @param binary1 First binary number.
     * @param binary2 Second binary number.
     * @return Ratio of two binary numbers.
     */
    public Binary divide(Binary binary1, Binary binary2) {
        double a = binaryToDecimal(binary1).getDecimal();
        double b = binaryToDecimal(binary2).getDecimal();
        double result = a / b;
        Decimal decimal = new Decimal(result);
        return decimalToBinary(decimal);
    }

    /**
     * Converts decimal to binary.
     *
     * @param decimal Decimal to convert.
     * @return Binary representation of inputted decimal.
     */
    public Binary decimalToBinary(Decimal decimal) {
        if (((int) decimal.getDecimal()) == 0) {
            return new Binary(0);
        }
        int[] binary = new int[40];
        int index = 0;
        while (((int) decimal.getDecimal()) > 0) {
            binary[index++] = ((int) decimal.getDecimal()) % 2;
            decimal.setDecimal((decimal.getDecimal())/2);
        }
        StringBuilder binaryNumber = new StringBuilder();
        for (int i = index - 1; i >= 0; i--) {
            binaryNumber.append(binary[i]);
        }
        return new Binary(Integer.parseInt(binaryNumber.toString()));
    }

    /**
     * Converts binary to decimal.
     *
     * @param binary Binary to convert.
     * @return Decimal representation of inputted binary.
     */
    public Decimal binaryToDecimal(Binary binary) {
        int decimal = 0;
        int power = 0;
        while (true) {
            if (binary.getBinary() == 0) {
                break;
            } else {
                int temp = binary.getBinary() % 10;
                decimal += temp * Math.pow(2, power);
                binary.setBinary(binary.getBinary()/10);
                power++;
            }
        }
        return new Decimal(decimal);
    }
}
