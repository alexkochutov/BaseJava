package com.basejava.webapp.model;

import java.util.ArrayList;
import java.util.List;

public class ListSection extends Section {
    private final List<String> content;

    ListSection() {
        content = new ArrayList<>();
    }

    public List<String> getContent() {
        return content;
    }

    public void addContentItem(String item) {
        content.add(item);
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < content.size(); i++) {
            result += "    - " + content.get(i);
            if (i < content.size() - 1) {
                result += "\n";
            }
        }
        return result;
    }
}