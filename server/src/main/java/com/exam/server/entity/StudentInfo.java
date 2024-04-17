package com.exam.server.entity;

import com.exam.server.model.Degree;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@Setter
public class StudentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private Integer age;
    private Integer currentClass;
    private Integer classNumber;
    private Degree degree;

    public StudentInfo() {}

    public StudentInfo(String firstName, String lastName,
                       Integer age, Integer currentClass, Integer classNumber,
                       Degree degree) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.currentClass = currentClass;
        this.classNumber = classNumber;
        this.degree = degree;
    }
}
