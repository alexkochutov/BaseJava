package com.basejava.webapp.model;

public class Period {
    private String startDate;
    private String endDate;
    private String title;
    private String description;

    Period(String startDate, String endDate, String title, String description) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String toString() {
        String result = "";
        result += "           " + startDate + " - " + ((endDate == null) ? "Until today" : endDate) + "\n";
        result += "           " + title + "\n";
        if (description != null) {
            result += "           " + description + "\n";
        }
        return result;
    }
}