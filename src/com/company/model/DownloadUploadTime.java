package com.company.model;

/**
 * Stores and manages upload and download time.
 */
public class DownloadUploadTime {

    /**
     * Days.
     */
    private int days;
    /**
     * Hours.
     */
    private int hours;
    /**
     * Minutes.
     */
    private int minutes;
    /**
     * Seconds.
     */
    private double seconds;

    /**
     * Creates an instance of time with days, hours, minutes, and seconds.
     *
     * @param days Days
     * @param hours Hours
     * @param minutes Minutes
     * @param seconds Seconds
     */
    public DownloadUploadTime(int days, int hours, int minutes, int seconds) {
        this.days = days;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    /**
     * Constructs an instance of time with no value.
     */
    public DownloadUploadTime() {}

    /**
     * Gets days.
     *
     * @return Days.
     */
    public int getDays() {
        return days;
    }

    /**
     * Gets hours.
     *
     * @return Hours.
     */
    public int getHours() {
        return hours;
    }

    /**
     * Gets minutes
     *
     * @return Minutes.
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * Gets seconds.
     *
     * @return Seconds.
     */
    public double getSeconds() {
        return seconds;
    }

    /**
     * Sets days.
     *
     * @param days Days.
     */
    public void setDays(int days) {
        this.days = days;
    }

    /**
     * Sets hours.
     *
     * @param hours Hours.
     */
    public void setHours(int hours) {
        this.hours = hours;
    }

    /**
     * Sets minutes.
     *
     * @param minutes Minutes
     */
    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    /**
     * Sets seconds.
     *
     * @param seconds Seconds
     */
    public void setSeconds(double seconds) {
        this.seconds = seconds;
    }

    /**
     * Creates a string representation of time.
     *
     * @return String representation of time.
     */
    public String toString() {
        return "Days: " + this.days +
                "\nHours: " + this.hours +
                "\nMinutes: " + this.minutes +
                "\nSeconds: " + this.seconds;
    }
}
