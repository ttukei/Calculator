package com.company.model;

/**
 * Stores and manages website bandwidth;
 */
public class Bandwidth {

    /**
     * Data value of bandwidth;
     */
    private Data data;

    /**
     * Unit of bandwidth.
     */
    private Unit unit;

    /**
     * Creates an instance of bandwidth given the data and unit
     * @param data Value of bandwidth data
     * @param unit Unit of bandwidth data
     */
    public Bandwidth(Data data, Unit unit) {
        this.data = data;
        this.unit = unit;
    }

    /**
     * Creates an instance of bandwidth with no values.
     */
    public Bandwidth() {}

    /**
     * Gets the data.
     *
     * @return Data value of the bandwidth
     */
    public Data getData() {
        return this.data;
    }

    /**
     * Gets the unit.
     *
     * @return Unit of the bandwidth.
     */
    public Unit getUnit() {
        return this.unit;
    }

    /**
     * Sets the data.
     *
     * @param data Value of data to be set.
     */
    public void setData(Data data) {
        this.data = data;
    }

    /**
     * Sets the unit.
     *
     * @param unit Unit of bandwidth to be set
     */
    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    /**
     * Creates a string representation of website bandwidth instance.
     *
     * @return String representation of bandwidth.
     */
    public String toString() {
        return this.data + " " + this.unit + "S";
    }

}
