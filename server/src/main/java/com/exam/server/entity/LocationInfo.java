package com.exam.server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class LocationInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String email;
    private Integer phone;

    @Enumerated(EnumType.STRING)
    private Location location;

    public LocationInfo() {}


    public LocationInfo(String name, String email, Integer phone, Location location) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.location = location;
    }
}

