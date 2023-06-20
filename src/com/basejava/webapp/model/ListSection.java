package com.basejava.webapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListSection extends Section {
    private static final long serialVersionUID = 1L;
    private final List<String> content = new ArrayList<>();

    public List<String> getContent() {
        return content;
    }

    public void addContentItem(String item) {
        content.add(item);
    }

    @Override
    public String toString() {
        String result = "";
        for (String item : content) {
            result += "  - " + item + "\n";
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListSection that = (ListSection) o;
        return Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }
}