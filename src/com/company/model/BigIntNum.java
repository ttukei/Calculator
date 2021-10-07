package com.company.model;

import java.math.BigInteger;

/**
 * Stores and manages big integers.
 */
public class BigIntNum extends Number{

    /**
     * A big integer.
     */
    private BigInteger bigIntNum;

    /**
     * Constructs an instance of a big integer.
     *
     * @param bigIntNum A big integer.
     */
    public BigIntNum(BigInteger bigIntNum) { this.bigIntNum = bigIntNum; }

    /**
     * Constructs an instance of big integer with no value.
     */
    public BigIntNum() { }

    /**
     * Gets big integer.
     *
     * @return Big integer.
     */
    public BigInteger getBigIntNum() { return this.bigIntNum; }

    /**
     * Sets big integer.
     *
     * @param bigIntNum Big integer to set.
     */
    public void setBigIntNum(BigInteger bigIntNum) { this.bigIntNum = bigIntNum; }

    /**
     * Creates a string representation of big integer.
     *
     * @return String representation of big integer.
     */
    public String toString() { return String.valueOf(getBigIntNum()); }
}
