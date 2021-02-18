package com.company.model;

public class Hexadecimal extends com.company.model.Number {

    private String hexadecimal;

    public Hexadecimal(String hexadecimal) { this.hexadecimal = hexadecimal; }

    public Hexadecimal() {}

    public String getHexadecimal() { return this.hexadecimal; }

    public void setHexadecimal(String hexadecimal) { this.hexadecimal = hexadecimal; }

    public String toString() { return getHexadecimal(); }
}
