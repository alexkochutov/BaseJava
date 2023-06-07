package com.basejava.webapp.model;

import java.util.ArrayList;
import java.util.List;

public class Organization {
    private final String name;
    private final String website;
    private final List<Period> list = new ArrayList<>();

    Organization(String name, String website) {
        this.name = name;
        this.website = website;
    }

    public String getName() {
        return name;
    }

    public String getWebsite() {
        return website;
    }

    public List<Period> getList() {
        return list;
    }

    public void addItem(Period item) {
        list.add(item);
    }

    public String toString() {
        String result = "";
        result += "    <> " + name + "\n";
        result += "       " + ((website == null) ? "Website isn`t specified" : website) + "\n";
        for (Period item : list) {
            result += item;
        }
        return result;
    }
}