package com.company.model;

public class Decimal extends Number{

    private Double decimal;

    public Decimal(Double decimal) { this.decimal = decimal; }

    public Decimal() {}

    public double getDecimal() { return this.decimal; }

    public void setDecimal(Double decimal) { this.decimal = decimal; }

    public String toString() { return "" + getDecimal(); }
}
