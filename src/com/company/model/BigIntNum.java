package com.company.model;

import java.math.BigInteger;

public class BigIntNum extends Number{

    private BigInteger bigIntNum;

    public BigIntNum(BigInteger bigIntNum) { this.bigIntNum = bigIntNum; }

    public BigIntNum() {}

    public BigInteger getBigIntNum() { return this.bigIntNum; }

    public void setBigIntNum(BigInteger bigIntNum) { this.bigIntNum = bigIntNum; }

    public String toString() { return "" + getBigIntNum(); }
}
