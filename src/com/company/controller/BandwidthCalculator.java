package com.company.controller;

import java.util.*;

public class BandwidthCalculator extends Calculator{

    private double data;
    private String unit;

    public BandwidthCalculator(double data, String unit) {
        this.data = data;
        this.unit = unit;
    }

    public BandwidthCalculator(double data) {
        this.data = data;
    }

    public BandwidthCalculator() {
    }

    public double getData() {
        return data;
    }

    public String getUnit() {
        return unit;
    }

    public void setData(double data) {
        this.data = data;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String toString() {
        return "Data = " + this.getData() + "\nUnit = " + this.getUnit();
    }

    /**
     * Converts one unit of data to other units of data
     *
     * @param data
     * @param unit
     * @return returns list of conversions for unit testing purposes
     */
    public List<String> dataUnitConverter(double data, String unit) {
        List<String> output = new ArrayList<>();
        double bit = convertToBit(data, unit);
        double accumulator = 1000;
        System.out.println(bit + " b");
        String[] bits = {"kb", "mb", "gb", "tb"};
        for (int i = 0; i < 4; i++) {
            System.out.println(bit * 1/accumulator + " " + bits[i]);
            accumulator *= 1000;
            output.add(bit * 1/accumulator + " " + bits[i]);
        }
        accumulator = 1000;
        String[] bytes = {"B", "KB", "MB", "GB", "TB"};
        for (int i = 0; i < 5; i++) {
            System.out.println(bit * 125.0/accumulator + " " +bytes[i]);
            accumulator *= 1000;
            output.add(bit * 125.0/accumulator + " " +bytes[i]);
        }
        return output;
    }

    /**
     *
     * @param fileSize
     * @param fileUnit
     * @param bandwidth
     * @param bandwidthUnit
     * @return returns minutes and seconds
     */
    public String downloadUploadTime(double fileSize, String fileUnit, double bandwidth, String bandwidthUnit) {
        double seconds = (convertToByte(fileSize, fileUnit) * 8) / convertToBit(bandwidth, bandwidthUnit);
        long remainingSeconds = (int) seconds % 60;
        long minutes = (int) seconds / 60;
        if (minutes > 0) {
            return minutes + " minutes and " + remainingSeconds + " seconds";
        } else {
            return remainingSeconds + " seconds";
        }
    }

    // Convert data unit to bits and return value
    private double convertToBit(double data, String unit) {
        switch (unit){
            case "b":
                return data;
            case "kb":
                return data * 1000;
            case "mb":
                return data * 1E+6;
            case "gb":
                return data * 1E+9;
            case "tb":
                return data * 1.0E+12;
            case "B":
                return data * 8;
            case "KB":
                return data * 8000;
            case "MB":
                return data * 8E+6;
            case "GB":
                return data * 8E+9;
            case "TB":
                return data * 8e+12;
            default:
                return -1;
        }
    }

    private double convertToByte(double data, String unit) {
        switch (unit) {
            case "B":
                return data;
            case "b":
                return data/8;
            case "kb":
                return data * 125;
            case "mb":
                return data * 125000;
            case "gb":
                return data * 1.25E+8;
            case "tb":
                return data * 1.25E+11;
            case "KB":
                return data * 1000;
            case "MB":
                return data * 1E+6;
            case "GB":
                return data * 1E+9;
            case "TB":
                return data * 1E+12;
            default:
                return -1;
        }
    }

    // FIXME
    public double websiteBandwidth(double avrPageViews, double avrPageSize, double redundancyFactor) {
        // 1 page view per second == 0.008Mb/sec == 1,000 bytes average page size
        // 1 page view per second == 0.000008/sec == 1 byte
       return avrPageSize * avrPageViews * 30 * redundancyFactor;
    }

    public double hostingBandwidthConverter(double monthlyUsage, String unit, String convertTo) {
        double monthlyUsageInBytes = convertToByte(monthlyUsage, unit);
        switch(convertTo) {
            case "b":
                return monthlyUsageInBytes * 3.0420564301468E-6;
            case "kb":
                return monthlyUsageInBytes * 3.0420564301468E-9;
            case "mb":
                return monthlyUsageInBytes * 3.0420564301468E-12;
            case "gb":
                return monthlyUsageInBytes * 3.0420564301468E-15;
            case "tb":
                return monthlyUsageInBytes * 3.0420564301468E-18;
            default:
                return -1;
        }

    }

}
