package com.company.model;

/**
 * Stores and manages decimals.
 */
public class Decimal extends Number{

    /**
     * Decimal number.
     */
    private double decimal;

    /**
     * Constructs an instance of a decimal number.
     *
     * @param decimal Decimal numebr.
     */
    public Decimal(double decimal) { this.decimal = decimal; }

    /**
     * Constructs an instance of a decimal number with no value.
     */
    public Decimal() {}

    /**
     * Gets decimal.
     *
     * @return Decima number.
     */
    public double getDecimal() { return this.decimal; }

    /**
     * Sets decimal.
     *
     * @param decimal Decimal number.
     */
    public void setDecimal(double decimal) { this.decimal = decimal; }

    /**
     * Creates a string representation of a decimal number.
     *
     * @return String representation of a decimal number.
     */
    public String toString() { return String.valueOf(getDecimal()); }
}
