package com.basejava.webapp.model;

import java.util.ArrayList;
import java.util.List;

public class DateSection extends Section {
    private final List<Organization> content;

    DateSection() {
        content = new ArrayList<>();
    }

    public List<Organization> getContent() {
        return content;
    }

    public void addContentItem(Organization item) {
        content.add(item);
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < content.size(); i++) {
            result += content.get(i);
            if (i < content.size() - 1) {
                result += "\n";
            }
        }
        return result;
    }
}