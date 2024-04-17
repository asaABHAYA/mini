package com.exam.server.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@Setter
public class UserLoginInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String email;
    private Integer phoneNo;

    private String password;

    public UserLoginInfo() {}

    public UserLoginInfo(Long id, String name, String email,
                         Integer phoneNo, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.password = password;
    }
}
