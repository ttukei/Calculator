package com.company.model;

/**
 * Stores and manages hexadecimal numbers.
 */
public class Hexadecimal extends com.company.model.Number {

    /**
     * Hexadecimal number.
     */
    private String hexadecimal;

    /**
     * Constructs an instance of a hexadecimal number.
     *
     * @param hexadecimal Hexadecimal.
     */
    public Hexadecimal(String hexadecimal) { this.hexadecimal = hexadecimal; }

    /**
     * Constructs an instance of a hexadecimal number with no value.
     */
    public Hexadecimal() {}

    /**
     * Gets hexadecimal.
     *
     * @return Hexadecimal number.
     */
    public String getHexadecimal() { return this.hexadecimal; }

    /**
     * Sets hexadecimal.
     *
     * @param hexadecimal Hexadecimal number.
     */
    public void setHexadecimal(String hexadecimal) { this.hexadecimal = hexadecimal; }

    /**
     * Creates a string representation of a hexadecimal number.
     *
     * @return String representation of a hexadecimal number.
     */
    public String toString() { return getHexadecimal(); }
}
