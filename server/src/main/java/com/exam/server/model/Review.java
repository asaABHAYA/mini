package com.exam.server.model;

import lombok.Getter;

@Getter
public enum Review {
    ONE_STAR(""),
    TWO_STAR(""),
    THREE_STAR(""),
    FOUR_STAR(""),
    FIVE_STAR("");


    private final String review;

    Review(String review) {
        this.review = review;
    }

}
