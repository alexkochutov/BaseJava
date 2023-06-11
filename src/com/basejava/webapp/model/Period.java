package com.basejava.webapp.model;

import java.util.Objects;

public class Period {
    private final String startDate;
    private final String endDate;
    private final String title;
    private final String description;

    Period(String startDate, String endDate, String title, String description) {
        Objects.requireNonNull(startDate, "StartDate MUST NOT be null");
        Objects.requireNonNull(title, "Title MUST NOT be null");
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

    @Override
    public String toString() {
        String result = "        " + startDate + " - " + (endDate == null ? "Till today" : endDate) + "\n        " + title + "\n";
        if (description != null) {
            result += "        " + description + "\n";
        }
        return result + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Period period = (Period) o;
        return startDate.equals(period.startDate) && Objects.equals(endDate, period.endDate) && title.equals(period.title) && Objects.equals(description, period.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate, title, description);
    }
}