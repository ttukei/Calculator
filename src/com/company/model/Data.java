package com.company.model;

/**
 * Stores and manages data values.
 */
public class Data extends Number {

    /**
     * Data value.
     */
    private double data;

    /**
     * Constructs an instance of data.
     * @param data Data value.
     */
    public Data(double data) {
        this.data = data;
    }

    /**
     * Gets data.
     *
     * @return Data value.
     */
    public double getData() {
        return data;
    }

    /**
     * Sets the data.
     *
     * @param data Data value.
     */
    public void setData(double data) {
        this.data = data;
    }

    /**
     * Creates a string representation of data.
     *
     * @return String representation of data.
     */
    public String toString() {
        return String.valueOf(data);
    }
}
