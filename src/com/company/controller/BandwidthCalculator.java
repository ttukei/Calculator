package com.company.controller;

import com.company.model.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Performs bandwidth operations.
 */
public class BandwidthCalculator extends Calculator {

    public BandwidthCalculator() {}

    /**
     * Converts data units.
     *
     * @param data Value of data to be converted.
     * @param unit Unit of data to be converted.
     * @return collection of conversions of inputted data.
     */
    public Map<Data, Unit> dataUnitConverter(Data data, Unit unit) {
        Map<Data, Unit> conversions = new HashMap<>();
        Data bitValue = toBit(data, unit);
        double accumulator = 1000;
        conversions.put(bitValue, Unit.BIT);
        Unit[] units = Unit.values();
        for (int i = 1; i < 5; i++) {
            conversions.put(new Data(bitValue.getData() * 1/accumulator), units[i]);
            accumulator *= 1000;
        }
        accumulator = 1000;
        for (int i = 5; i < 9; i++) {
            conversions.put(new Data(bitValue.getData() * 125.0/accumulator), units[i]);
            accumulator *= 1000;
        }
        return conversions;
    }

    /**
     * Calculates download/upload time given the data to upload and bandwidth.
     *
     * @param data Value of data to be uploaded/downloaded.
     * @param unit Unit of data to be uploaded/downloaded.
     * @param bandwidth Volume of information per unit of time.
     * @return download and upload time
     */
    public DownloadUploadTime downloadUploadTime(Data data, Unit unit, Bandwidth bandwidth) {
        DownloadUploadTime time = new DownloadUploadTime();
        time.setSeconds((toByte(data, unit).getData() * 8) / toBit(bandwidth.getData(), bandwidth.getUnit()).getData());
        if (time.getSeconds() == 0) {
            return time;
        } else {
            if (time.getSeconds() >= 86400) {
                int days = (int) time.getSeconds()/86400;
                double remainingHours = (time.getSeconds()%86400);
                int hours = (int) remainingHours/3600;
                double remainingMinutes = remainingHours % 3600;
                int minutes = (int) remainingMinutes/60;
                double seconds = remainingMinutes% 60;
                time.setDays(days);
                time.setHours(hours);
                time.setMinutes(minutes);
                time.setSeconds(seconds);
            } else if (time.getSeconds() >= 3600) {
                int hours = (int) time.getSeconds()/3600;
                double remainingMinutes = time.getMinutes() % 3600;
                int minutes = (int) remainingMinutes/60;
                double seconds = remainingMinutes% 60;
                time.setDays(0);
                time.setHours(hours);
                time.setMinutes(minutes);
                time.setSeconds(seconds);
            } else if (time.getSeconds() >= 60) {
                int minutes = (int) time.getSeconds()/60;
                double seconds = time.getSeconds()% 60;
                time.setDays(0);
                time.setHours(0);
                time.setMinutes(minutes);
                time.setSeconds(seconds);
            } else {
                time.setDays(0);
                time.setHours(0);
                time.setMinutes(0);
            }
        }
        return time;
    }

    /**
     * Converts data to bit.
     *
     * @param data Value of data to be converted.
     * @param unit Unit of data to be converted.
     * @return bit value of inputted data
     */
    private Data toBit(Data data, Unit unit) {
        return switch (unit) {
            case BIT ->  new Data(data.getData());
            case KILOBIT -> new Data(data.getData() * 0.001);
            case MEGABIT -> new Data(data.getData() * 1.0E-6);
            case GIGABIT -> new Data(data.getData() * 1.0E-9);
            case TERABIT -> new Data(data.getData() * 1.0E-12);
            case BYTE -> new Data(data.getData() * 0.125);
            case KILOBYTE -> new Data(data.getData() * 0.000125);
            case MEGABYTE -> new Data(data.getData() * 1.25E-7);
            case GIGABYTE -> new Data(data.getData() * 1.25E-10);
            case TERABYTE -> new Data(data.getData() * 1.25E-13);
        };
    }

    /**
     * Converts data to byte.
     *
     * @param data Value of data to be converted.
     * @param unit Unit of data to be converted.
     * @return byte value of inputted data
     */
    private Data toByte(Data data, Unit unit) {
        return switch (unit) {
            case BYTE -> new Data(data.getData());
            case BIT -> new Data(data.getData() * 0.125);
            case KILOBIT -> new Data(data.getData() * 125);
            case MEGABIT -> new Data(data.getData() * 125000);
            case GIGABIT -> new Data(data.getData() * 1.25E+8);
            case TERABIT -> new Data(data.getData() * 1.25E+11);
            case KILOBYTE -> new Data(data.getData() * 1000);
            case MEGABYTE -> new Data(data.getData() * 1E+6);
            case GIGABYTE -> new Data(data.getData() * 1E+9);
            case TERABYTE -> new Data(data.getData() * 1E+12);
        };
    }

    // FIXME
    /**
     * Calculates website bandwidth given the websites statistics.
     *
     * @param websiteStats The websites page views, average page size, and redundancy factor;
     * @return website bandwidth
     */
    public Bandwidth websiteBandwidth(WebsiteStats websiteStats, RedundancyFactor redundancyFactor) {
        // 1 page view per second == 0.008Mb/sec == 1,000 bytes average page size
        // 1 page view per second == 0.000008/sec == 1 byte
        Bandwidth websiteBandwidth = new Bandwidth();
        // websiteBandwidth.setData();
        websiteBandwidth.setUnit(Unit.MEGABIT);
       return websiteBandwidth;
    }

    /**
     * Calculates the website bandwidth
     *
     * @param monthlyUsage Monthly data usage.
     * @param monthlyUsageUnit Unit of monthly data usage.
     * @param convertTo Unit of bandwidth to return.
     * @return hosting bandwidth
     */
    public Bandwidth hostingBandwidthConverter(Data monthlyUsage, Unit monthlyUsageUnit, Unit convertTo) {
        Data monthlyUsageInBytes = toByte(monthlyUsage, monthlyUsageUnit);
        return switch (convertTo) {
            case BIT -> new Bandwidth(new Data(monthlyUsageInBytes.getData() * 3.0420564301468E-6), Unit.BIT);
            case KILOBIT -> new Bandwidth(new Data(monthlyUsageInBytes.getData() * 3.0420564301468E-9), Unit.KILOBIT);
            case MEGABIT -> new Bandwidth(new Data(monthlyUsageInBytes.getData() * 3.0420564301468E-12), Unit.MEGABIT);
            case GIGABIT -> new Bandwidth(new Data(monthlyUsageInBytes.getData() * 3.0420564301468E-15), Unit.GIGABIT);
            case TERABIT -> new Bandwidth(new Data(monthlyUsageInBytes.getData() * 3.0420564301468E-18), Unit.TERABIT);
            default -> throw new IllegalStateException("Unexpected value: " + convertTo);
        };
    }

}
