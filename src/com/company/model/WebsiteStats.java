package com.company.model;

/**
 * Stores and manages website statistics
 */
public class WebsiteStats {

    /**
     * Websites page views.
     */
    private double pageViews;
    /**
     * Websites average page size.
     */
    private double averagePageSize;

    /**
     * Constructs an instance of websites statistics.
     *
     * @param pageViews Page views.
     * @param averagePageSize Average page size.
     */
    public WebsiteStats(double pageViews, double averagePageSize) {
        this.pageViews = pageViews;
        this.averagePageSize = averagePageSize;
    }

    /**
     * Gets the page views.
     *
     * @return Page views.
     */
    public double getPageViews() {
        return pageViews;
    }

    /**
     * Gets the average page size.
     *
     * @return Average page size.
     */
    public double getAveragePageSize() {
        return averagePageSize;
    }

    /**
     * Sets the average page size.
     *
     * @param averagePageSize Average page size.
     */
    public void setAveragePageSize(double averagePageSize) {
        this.averagePageSize = averagePageSize;
    }

    /**
     * Sets the page views.
     *
     * @param pageViews Page views.
     */
    public void setPageViews(double pageViews) {
        this.pageViews = pageViews;
    }

    /**
     * Creates a string representation of a websites statistics.
     *
     * @return String representation of a websites statistics.
     */
    public String toString() {
        return "Page views: " + this.pageViews +
                "\n Average page size: " + this.averagePageSize;
    }
}

