package com.basejava.webapp.model;

public class StringSection extends Section {
    private final String content;

    StringSection(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String toString() {
        return "    " + content;
    }
}