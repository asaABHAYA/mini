package com.exam.server.model;

public record Student(String firstName, String lastName,
                      Integer age, Integer currentClass,
                      Integer classNumber, Degree degree) {
}
