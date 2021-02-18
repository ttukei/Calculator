package com.company.view;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class InputValidator {

    private Scanner console;

    public InputValidator() {
        this.console = new Scanner(System.in);
    }

    public void setConsole(Scanner console) {
        this.console = console;
    }

    public Scanner getConsole() {
        return console;
    }

    /**
     * Filters input
     *
     * @return a number between 1 and 3
     */
    public int numBetween1and5() {
        Boolean flag = true;
        int selection = -1;
        while (flag) {
            if (getConsole().hasNextInt()) {
                selection = getConsole().nextInt();
                if (selection > 5 || selection < 1) {
                    System.out.print("Please select a number between 1 and 5:");
                    getConsole().nextLine();
                } else {
                    flag = false;
                }
            } else {
                System.out.print("Please select a number between 1 and 5:");
                getConsole().nextLine();
            }
        }
        return selection;
    }

    /**
     * Filters input
     *
     * @return a number between 1 and 4
     */
    public int numBetween1and4() {
        Boolean flag = true;
        int selection = -1;
        while (flag) {
            if (getConsole().hasNextInt()) {
                selection = getConsole().nextInt();
                if (selection > 4 || selection < 1) {
                    System.out.print("Please select a number between 1 and 4:");
                } else {
                    flag = false;
                }
            } else {
                getConsole().next();
                System.out.print("Please select a number between 1 and 4:");
            }
        }
        return selection;
    }

    /**
     * Filters input
     *
     * @return an arithmetic operator
     */
    public String arithmeticOperation() { // FIXME: arithmeticOperation does not handle input well
        String operator = "";
        Boolean flag = true;
        while(flag) {
            if (getConsole().hasNextLine()) {
                operator = getConsole().next();
                if (!(operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/"))) {
                    System.out.print("Pick an arithmetic operation (+, -, *, /): ");
                } else {
                    flag = false;
                }
            } else {
                getConsole().next();
                System.out.print("Pick an arithmetic operation (+, -, *, /): ");
            }
        }
        return operator;
    }

    /**
     * Filters input
     *
     * @return true/false for purposes of restarting the program
     */
    public boolean restart() {
        boolean flag = true;
        boolean restart = false;
        System.out.print("Restart? YES|NO: ");
        String response;
        do {
            if (getConsole().hasNext()) {
                response = getConsole().next();
                if (response.equalsIgnoreCase("yes")) {
                    restart = true;
                    flag = false;
                } else if (response.equalsIgnoreCase("no")) {
                    restart = false;
                    flag = false;
                } else {
                    System.out.print("YES|NO: ");
                    getConsole().nextLine();
                }
            }
        } while(flag);
        return restart;
    }

    /**
     * Filters input
     *
     * @return valid binary
     */
    public int binaryNumberValidator() {
        String[] invalidDigits = {"2", "3", "4", "5", "6", "7", "8", "9"};
        int binaryNumber = 0;
        boolean invalidBinaryNumber = true;
        boolean flag = true;
        do {
            if (getConsole().hasNextInt()) {
                binaryNumber = getConsole().nextInt();
                invalidBinaryNumber = Arrays.stream(invalidDigits).anyMatch(Integer.toString(binaryNumber)::contains);
                if (binaryNumber < 0) {
                    System.out.println("The number must be positive: ");
                    getConsole().nextLine();
                } else if (invalidBinaryNumber) {
                    System.out.println("The number may only contain 0's and 1's: ");
                    getConsole().nextLine();
                } else {
                    flag = false;
                }
            } else {
                System.out.println("The number may only contain 1's and 0's: ");
                getConsole().nextLine();
            }
        }while(flag);
        return binaryNumber;
    }

    /**
     * Filters input
     *
     * @return valid integer
     */
    public int integerNumberValidator() {
        boolean invalidInput = true;
        int decimal = 0;
        do {
            if (getConsole().hasNextInt()) {
                decimal = getConsole().nextInt();
                invalidInput = false;
            } else {
                System.out.print("The decimal may only be numeric: ");
                getConsole().nextLine();
            }
        } while(invalidInput);
        return decimal;
    }

    /**
     * Filters input
     *
     * @return valid hexadecimal
     */
    public String hexadecimalNumberValidator() {
        String[] invalidLetters = {"G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
                "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        boolean invalidInput = true;
        boolean containsInvalidLetters = false;
        String hexadecimal = "";
        do {
            hexadecimal = getConsole().next();
            containsInvalidLetters = Arrays.stream(invalidLetters).anyMatch(hexadecimal::contains);
            if (containsInvalidLetters) {
                System.out.println("The number may only contains letters A-F: ");
                getConsole().nextLine();
            } else {
                invalidInput = false;
            }
        } while (invalidInput);
        return hexadecimal;
    }

    /**
     * Filters input
     *
     * @return valid double
     */
    public double doubleNumberValidator() {
        boolean invalidInput = true;
        double decimal = 0;
        do {
            if (getConsole().hasNextInt()) {
                decimal = getConsole().nextInt();
                invalidInput = false;
            } else {
                System.out.print("The decimal may only be numeric: ");
                getConsole().nextLine();
            }
        } while(invalidInput);
        return decimal;
    }


    /**
     * Filters input
     *
     * @return valid unit
     */
    public String unitValidator() {
        boolean invalidInput = true;
        String[] dataTypes = {"b", "kb", "mb", "gb", "tb", "B", "KB", "MB", "GB", "TB"};
        String response = "";
        do {
            if (getConsole().hasNext()) {
                response = getConsole().next();
                if (Arrays.stream(dataTypes).anyMatch(response::contains)) {
                    invalidInput = false;
                } else {
                    System.out.println("Please enter one of the following ");
                    System.out.print("b, kb, mb, gb, tb, B, KB, MB, GB, TB: ");
                    getConsole().nextLine();
                }
            } else {
                System.out.println("Please enter one of the following ");
                System.out.print("b, kb, mb, gb, tb, B, KB, MB, GB, TB: ");
            }
        } while (invalidInput);
        return response;
    }

    public int rawBinary() {
        return getConsole().nextInt();
    }

    public double rawDouble() {
        return getConsole().nextDouble();
    }

    public BigInteger rawBigInteger() { return getConsole().nextBigInteger(); }

    public String rawHexadecimal() { return getConsole().next(); }

}