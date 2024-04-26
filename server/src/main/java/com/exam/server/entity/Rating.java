package com.exam.server.entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Rating {
    FIVE_STARS("⭐️⭐️⭐️⭐️⭐️️️️"),
    FOUR_STARS("⭐️⭐️⭐️⭐️"),
    THREE_STARS("⭐️⭐️⭐️"),
    TWO_STARS("⭐️⭐️"),
    ONE_STAR("⭐️");

    private final String star;

    Rating(String s) {
        star = s;
    }

    @JsonValue
    public String getStar() {
        return star;
    }
}
