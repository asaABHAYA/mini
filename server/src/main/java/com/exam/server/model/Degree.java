package com.exam.server.model;

import lombok.Getter;

@Getter
public enum Degree {
    B_TECH("B_TECH"),
    B_ARCH("B_ARCH"),
    M_TECH("M_TECH"),
    M_ARCH("M_ARCH");

    private final String degree;

    Degree(String degree) {
        this.degree = degree;
    }

}
