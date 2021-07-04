package com.company.model;

/**
 * Stores and manages redundancy factor.
 */
public class RedundancyFactor {

    /**
     * Redundancy factor.
     */
    private double redundancyFactor;

    /**
     * Constructs an instance of redundancy factor.
     *
     * @param redundancyFactor Redundancy factor.
     */
    public RedundancyFactor(double redundancyFactor) {
        this.redundancyFactor = redundancyFactor;
    }

    /**
     * Creates an instance of redundancy factor with no values.
     */
    public RedundancyFactor() { }

    /**
     * Gets redundancy factor.
     *
     * @return Redundancy factor.
     */
    public double getRedundancyFactor() {
        return redundancyFactor;
    }

    /**
     * Sets redundancy factor.
     *
     * @param redundancyFactor Redundancy factor.
     */
    public void setRedundancyFactor(double redundancyFactor) {
        this.redundancyFactor = redundancyFactor;
    }

    /**
     * Creates a string representation of redundancy factor.
     *
     * @return String representation of redundancy factor.
     */
    public String toString() {
        return String.valueOf(this.redundancyFactor);
    }
}
