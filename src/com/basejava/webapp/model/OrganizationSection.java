package com.basejava.webapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrganizationSection extends Section {
    private final List<Organization> content = new ArrayList<>();

    public List<Organization> getContent() {
        return content;
    }

    public void addContentItem(Organization item) {
        content.add(item);
    }

    public String toString() {
        String result = "";
        for (Organization item : content) {
            result += item;
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganizationSection that = (OrganizationSection) o;
        return Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }
}