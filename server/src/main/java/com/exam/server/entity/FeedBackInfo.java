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

    private String eventName;

    @Enumerated(EnumType.STRING)
    private Location location;

    @Enumerated(EnumType.STRING)
    private Rating rating;


    public FeedBackInfo(String userName, String feedbackMessage, Location location, Rating rating) {
        this.userName = userName;
        this.feedbackMessage = feedbackMessage;
        this.location = location;
        this.rating = rating;
    }
}
