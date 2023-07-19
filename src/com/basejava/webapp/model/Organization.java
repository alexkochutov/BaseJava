package com.basejava.webapp.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class Organization implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String website;
    private final List<Period> list = new ArrayList<>();

    public Organization() {}

    public Organization(String name, String website) {
        Objects.requireNonNull(name, "Name MUST NOT be null");
        this.name = name;
        this.website = website == null? "" : website;
    }

    public Organization(String name, String website, List<Period> list) {
        this(name, website);
        this.list.addAll(list);
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

    @Override
    public String toString() {
        String result = "    " + name + "\n";
        if (website != null) {
            result += "    " + website + "\n";
        }
        for (Period item : list) {
            result += item.toString();
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return name.equals(that.name) && Objects.equals(website, that.website) && Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, website, list);
    }
}