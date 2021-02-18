package com.company.controller;

import com.company.model.Decimal;
import com.company.model.Binary;

public class BinaryCalculator extends NumericCalculator implements BinaryCalcInterface {

    public Binary add(Binary binary1, Binary binary2) {
        double a = binaryToDecimal(binary1).getDecimal();
        double b = binaryToDecimal(binary2).getDecimal();
        double result = a + b;
        Decimal decimal = new Decimal(result);
        return decimalToBinary(decimal);
    }

    public Binary subtract(Binary binary1, Binary binary2) {
        double a = binaryToDecimal(binary1).getDecimal();
        double b = binaryToDecimal(binary2).getDecimal();
        double result = a - b;
        Decimal decimal = new Decimal(result);
        return decimalToBinary(decimal);
    }

    public Binary multiply(Binary binary1, Binary binary2) {
        double a = binaryToDecimal(binary1).getDecimal();
        double b = binaryToDecimal(binary2).getDecimal();
        double result = a * b;
        Decimal decimal = new Decimal(result);
        return decimalToBinary(decimal);
    }

    public Binary divide(Binary binary1, Binary binary2) {
        double a = binaryToDecimal(binary1).getDecimal();
        double b = binaryToDecimal(binary2).getDecimal();
        double result = a / b;
        Decimal decimal = new Decimal(result);
        return decimalToBinary(decimal);
    }

    /**
     * Converts a decimal to binary
     *
     * @param decimal
     * @return string representation of a binary
     */
    public Binary decimalToBinary(Decimal decimal) {
        if (((int) decimal.getDecimal()) == 0) {
            return new Binary(0);
        }
        int binary[] = new int[40];
        int index = 0;
        while (((int) decimal.getDecimal()) > 0) {
            binary[index++] = ((int) decimal.getDecimal()) % 2;
            decimal.setDecimal((decimal.getDecimal())/2);
        }
        String binaryNumber = "";
        for (int i = index - 1; i >= 0; i--) {
            binaryNumber += (binary[i]);
        }
        return new Binary(Integer.parseInt(binaryNumber));
    }

    /**
     * Converts binary to decimal
     *
     * @param binary
     * @return decimal
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
        return new Decimal((double) decimal);
    }
}
