package com.exam.server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class FeedBackInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String userName;

    private String feedbackMessage;
    private String location;


    public FeedBackInfo(String userName, String feedbackMessage, String location) {
        this.userName = userName;
        this.feedbackMessage = feedbackMessage;
        this.location = location;
    }
}
