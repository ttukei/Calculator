package com.company.controller;

import com.company.model.Number;

/**
 *  Specifies behavior of child classes.
 */
public abstract class Calculator {

    /**
     * Adds two numbers.
     * To be implemented by child classes.
     *
     * @param number1 First number.
     * @param number2 Second number.
     */
    public void add(Number number1, Number number2) {
    }

    /**
     * Subtracts two numbers.
     * To be implemented by child classes.
     *
     * @param number1 First number.
     * @param number2 Second number.
     */
    public void subtract(Number number1, Number number2) {
    }

    /**
     * Multiplies two numbers.
     * To be implemented by child classes.
     *
     * @param number1 First number.
     * @param number2 Second number.
     */
    public void multiply(Number number1, Number number2) {
    }

    /**
     * Divides two numbers.
     * To be implemented by child classes.
     *
     * @param number1 First number.
     * @param number2 Second number.
     */
    public void divide(Number number1, Number number2) {
    }
}
