package com.exam.server.model;

public record UserLoginGQL(
        String firstName,
        String lastName,
        String email,
        Integer phoneNo,
        String password) {
}
