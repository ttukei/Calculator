package com.company;

import com.company.view.*;
import com.company.model.*;
import com.company.controller.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.logging.*;

public class Main {

    private static final Logger logger = Logger.getLogger("com.company");

    // TODO Implement the websiteBandwidth method
    // TODO complete BandwidthCalculatorTest class
    public static void main(String[] args) throws InputMismatchException {
        logger.setLevel(Level.WARNING);
        final String ANSI_CYAN = "\u001B[36m";
        System.out.print(ANSI_CYAN);
        run();
    }

    public static void run() throws InputMismatchException {
        InputValidator input = new InputValidator();
        do {
            System.out.println("Select a calculator [1,5]:");
            System.out.println("""                                  
                    Binary Calculator
                    Hexadecimal Calculator
                    Bandwidth calculator
                    Decimal calculator
                    BigInteger calculator""");
            switch (input.numBetween1and5()) {
                case 1 -> {
                    System.out.print("""
                            Select a Binary Calculator Function:
                            Add, Subtract, Multiply, or Divide
                            Convert Binary to Decimal
                            Convert Decimal to Binary
                            """);
                    BinaryCalculator binaryCalculator = new BinaryCalculator();
                    switch (input.numBetween1and5()) {
                        case 1 -> {
                            System.out.println("--Add, Subtract, Multiply, or Divide--");
                            System.out.println("Pick an arithmetic operation (+, -, *, /): ");
                            String operator = input.arithmeticOperation();
                            try {
                                System.out.print("Enter the first binary number: ");
                                Binary binary1 = new Binary(input.rawBinary());
                                System.out.print("Enter the second binary number: ");
                                Binary binary2 = new Binary(input.rawBinary());
                                switch (operator) {
                                    case "+" -> System.out.println("Result = " + binaryCalculator.add(binary1, binary2));
                                    case "-" -> System.out.println("Result = " + binaryCalculator.subtract(binary1, binary2));
                                    case "*" -> System.out.println("Result = " + binaryCalculator.multiply(binary1, binary2));
                                    case "/" -> System.out.println("Result = " + binaryCalculator.divide(binary1, binary2));
                                }
                            } catch (InputMismatchException e) {
                                logger.warning(e.getMessage());
                                e.printStackTrace();
                                run();
                            }
                        }
                        case 2 -> {
                            System.out.println("--Convert Binary to Decimal--");
                            try {
                                System.out.print("Enter a binary number: ");
                                Binary binary = new Binary(input.rawBinary());
                                System.out.println("Result = " + binaryCalculator.binaryToDecimal(binary));
                            } catch (InputMismatchException e) {
                                logger.warning(e.getMessage());
                                e.printStackTrace();
                                run();
                            }
                        }
                        case 3 -> {
                            System.out.println("--Convert Decimal to Binary--");
                            try {
                                System.out.print("Enter a decimal number: ");
                                Decimal decimal = new Decimal(input.rawDouble());
                                System.out.println("Result = " + binaryCalculator.decimalToBinary(decimal));
                            } catch (InputMismatchException e) {
                                logger.warning(e.getMessage());
                                e.printStackTrace();
                                run();
                            }
                        }
                    }
                }
                case 2 -> {
                    System.out.print("""
                            Select a Hexadecimal Calculator Function (1-3):\s
                            Add, Subtract, Multiply, or Divide
                            Convert Hexadecimal to Decimal
                            Convert Decimal to Hexadecimal
                            """);
                    HexadecimalCalculator hexadecimalCalculator = new HexadecimalCalculator();
                    int hexadecimalFunction = input.numBetween1and5();
                    switch (hexadecimalFunction) {
                        case 1 -> {
                            System.out.println("--Add, Subtract, Multiply, or Divide--");
                            System.out.println("Pick an arithmetic operation (+, -, *, /): ");
                            String operator = input.arithmeticOperation();
                            System.out.print("Enter the first hexadecimal number: ");
                            Hexadecimal hex1 = new Hexadecimal(input.rawHexadecimal());
                            System.out.print("Enter the second hexadecimal number: ");
                            Hexadecimal hex2 = new Hexadecimal(input.rawHexadecimal());
                            String[] invalidLetters =
                                    {"G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
                                            "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
                            assert Arrays.stream(invalidLetters).noneMatch(hex1.getHexadecimal().toUpperCase()::contains);
                            assert Arrays.stream(invalidLetters).noneMatch(hex1.getHexadecimal().toUpperCase()::contains);
                            switch (operator) {
                                case "+" -> System.out.println("Result = " + hexadecimalCalculator.add(hex1, hex2));
                                case "-" -> System.out.println("Result = " + hexadecimalCalculator.subtract(hex1, hex2));
                                case "*" -> System.out.println("Result = " + hexadecimalCalculator.multiply(hex1, hex2));
                                case "/" -> System.out.println("Result = " + hexadecimalCalculator.divide(hex1, hex2));
                            }
                        }
                        case 2 -> {
                            System.out.println("--Convert hexadecimal to Decimal--");
                            System.out.print("Enter a hexadecimal number: ");
                            Hexadecimal hex = new Hexadecimal(input.hexadecimalNumberValidator());
                            System.out.println("Result = " + hexadecimalCalculator.hexadecimalToDecimal(hex));
                        }
                        case 3 -> {
                            System.out.println("--Convert Decimal to hexadecimal--");
                            System.out.println("Enter a decimal number: ");
                            Decimal decimal = new Decimal(input.rawDouble());
                            System.out.println("Result = " +
                                    hexadecimalCalculator.decimalToHexadecimal(decimal));
                        }
                    }
                }
                case 3 -> {
                    BandwidthCalculator bandwidthCalculator = new BandwidthCalculator();
                    System.out.println("""
                            Select a Bandwidth Calculator function (1-4):
                            Data Unit Converter
                            Download/Upload Time Calculator
                            Website Bandwidth Calculator
                            Hosting Bandwidth Converter""");
                    switch (input.numBetween1and4()) {
                        case 1 -> {
                            System.out.println("--Data Unit Converter--");
                            try {
                                System.out.print("Enter a value: ");
                                // double data = input.doubleNumberValidator();
                                double data = input.rawDouble();
                                System.out.print("Enter a unit: ");
                                String unit = input.unitValidator();
                                // bandwidthCalculator.dataUnitConverter(data, unit);
                            } catch (InputMismatchException e) {
                                logger.warning(e.getMessage());
                                e.printStackTrace();
                                run();
                            }

                        }
                        case 2 -> {
                            System.out.println("--Download/Upload Time Calculator--");
                            try {
                                System.out.print("Enter the file size: ");
                                // double fileSize = input.doubleNumberValidator();
                                double fileSize = input.rawDouble();
                                System.out.println("Enter the file unit");
                                System.out.print("B, KB, MB, GB, TB: ");
                                String fileSizeUnit = input.unitValidator();
                                System.out.print("Enter the bandwidth: ");
                                double bandwidth = input.doubleNumberValidator();
                                System.out.println("Enter the bandwidth unit");
                                System.out.print("b, kb, mb, gb, tb: ");
                                String bandwidthUnit = input.unitValidator();
                                // System.out.println(bandwidthCalculator.downloadUploadTime(fileSize, fileSizeUnit, bandwidth, bandwidthUnit));
                            } catch (InputMismatchException e) {
                                logger.warning(e.getMessage());
                                e.printStackTrace();
                                run();
                            }


                        }
                        case 3 -> {
                            System.out.println("--Website Bandwidth Calculator--");
                            try {
                                System.out.println("Enter the average page views per visitor: ");
                                // double pageViews = input.doubleNumberValidator();
                                double pageViews = input.rawDouble();
                                System.out.println("Enter the average page size: ");
                                // double pageSize = input.doubleNumberValidator();
                                double pageSize= input.rawDouble();
                                System.out.println("Enter the redundancy factor: ");
                                // double redundancyFactor = input.doubleNumberValidator();
                                double redundancyFactor = input.rawDouble();
                                // bandwidthCalculator.websiteBandwidth(pageViews, pageSize, redundancyFactor);
                            } catch (InputMismatchException e) {
                                logger.warning(e.getMessage());
                                e.printStackTrace();
                                run();
                            }
                        }
                        case 4 -> {
                            System.out.println("--Hosting Bandwidth Converter--");
                            try {
                                System.out.print("Enter the monthly usage: ");
                                // double monthlyUsage = input.doubleNumberValidator();
                                double monthlyUsage = input.rawDouble();
                                System.out.println("Enter the unit");
                                System.out.print("B, KB, MB, GB, TB: ");
                                String monthlyUsageUnit = input.unitValidator();
                                System.out.println("Enter unit to convert to: ");
                                System.out.print("b, kb, mb, gb, tb: ");
                                String convertTo = input.unitValidator();
                                // System.out.println(bandwidthCalculator.hostingBandwidthConverter(monthlyUsage,
                                //        monthlyUsageUnit, convertTo));
                            } catch (InputMismatchException e) {
                                logger.warning(e.getMessage());
                                e.printStackTrace();
                                run();
                            }
                        }
                    }
                }
                case 4 -> {
                    DecimalCalculator decimalCalculator = new DecimalCalculator();
                    System.out.println("--Add, Subtract, Multiply, or Divide--");
                    System.out.println("Pick an arithmetic operation (+, -, *, /): ");
                    String operator = input.arithmeticOperation();
                    try {
                        System.out.print("Enter the first decimal number: ");
                        Decimal decimal1 = new Decimal(input.rawDouble());
                        System.out.print("Enter the second decimal number: ");
                        Decimal decimal2 = new Decimal(input.rawDouble());
                        switch (operator) {
                            case "+" -> System.out.println("Result = " + decimalCalculator.add(decimal1, decimal2));
                            case "-" -> System.out.println("Result = " + decimalCalculator.subtract(decimal1, decimal2));
                            case "*" -> System.out.println("Result = " + decimalCalculator.multiply(decimal1, decimal2));
                            case "/" -> System.out.println("Result = " + decimalCalculator.divide(decimal1, decimal2));
                        }
                    } catch (InputMismatchException e) {
                        logger.warning(e.getMessage());
                        e.printStackTrace();
                        run();
                    }

                } case 5 -> {
                    BigIntegerCalculator bigIntegerCalculator = new BigIntegerCalculator();
                    System.out.println("--Add, Subtract, Multiply, or Divide--");
                    System.out.println("Pick an arithmetic operation (+, -, *, /): ");
                    String operator = input.arithmeticOperation();
                    try {
                        System.out.print("Enter the first BigInteger number: ");
                        BigIntNum bigIntNum1 = new BigIntNum(input.rawBigInteger());
                        System.out.print("Enter the second BigInteger number: ");
                        BigIntNum bigIntNum2 = new BigIntNum(input.rawBigInteger());
                        switch (operator) {
                            case "+" -> System.out.println("Result = " + bigIntegerCalculator.add(bigIntNum1, bigIntNum2));
                            case "-" -> System.out.println("Result = " + bigIntegerCalculator.subtract(bigIntNum1, bigIntNum2));
                            case "*" -> System.out.println("Result = " + bigIntegerCalculator.multiply(bigIntNum1, bigIntNum2));
                            case "/" -> System.out.println("Result = " + bigIntegerCalculator.divide(bigIntNum1, bigIntNum2));
                        }
                    } catch (InputMismatchException e) {
                        logger.warning(e.getMessage());
                        e.printStackTrace();
                        run();
                    }
                }
            }
        } while(input.restart());
    }
}