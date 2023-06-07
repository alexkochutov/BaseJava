package com.basejava.webapp.model;

public enum ContactType {
    MOBILE("Мобильный телефон"),
    MAIL("Электронная почта"),
    SKYPE("Скайп"),
    LINKEDIN("Профиль LinkedIn"),
    GITHUB("Профиль GitHub"),
    STACKOVERFLOW("Профиль StackOverFlow"),
    HOMEPAGE("Домашняя страница");

    private String type;

    ContactType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}