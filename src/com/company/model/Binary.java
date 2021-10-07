package com.company.model;

/**
 * Stores and manages binary numbers.
 */
public class Binary extends Number {

    /**
     * Binary number.
     */
    private int binary;

    /**
     * Constructs an instance of a binary number.
     * @param binary Binary number.
     */
    public Binary(int binary) { this.binary = binary; }

    /**
     * Constructs an instance of a binary number with no values.
     */
    public Binary() {}

    /**
     * Gets binary.
     *
     * @return Binary number.
     */
    public int getBinary() {
        return this.binary;
    }

    /**
     * Sets binary number.
     *
     * @param number Binary number.
     */
    public void setBinary(int number) { this.binary = number; }

    /**
     * Creates a string representation of a binary number.
     *
     * @return String representation of a binary number.
     */
    public String toString() { return "" + getBinary(); }
}
