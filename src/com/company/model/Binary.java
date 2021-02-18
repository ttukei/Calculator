package com.company.model;

public class Binary extends Number {

    private int binary;

    public Binary(int binary) { this.binary = binary; }

    public Binary() {}

    public int getBinary() {
        return this.binary;
    }

    public void setBinary(int number) { this.binary = number; }

    public String toString() { return "" + getBinary(); }
}
