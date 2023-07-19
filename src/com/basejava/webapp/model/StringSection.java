package com.basejava.webapp.model;

import java.util.Objects;

public class StringSection extends Section {
    private static final long serialVersionUID = 1L;
    private String content;

    public StringSection() {}

    public StringSection(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringSection that = (StringSection) o;
        return Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }
}