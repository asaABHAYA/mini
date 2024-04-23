package com.exam.server.controller;

import com.exam.server.entity.FeedBackInfo;
import com.exam.server.service.FeedBackService;
import lombok.extern.log4j.Log4j2;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Log4j2
@Controller
public class FeedBackController {
    private final FeedBackService feedBackService;

    public FeedBackController(FeedBackService feedBackService) {this.feedBackService = feedBackService;}

    @QueryMapping
    public List<FeedBackInfo> getFeedBackInfo(@Argument String location) {
        return feedBackService.findAllByLocation(location);
    }

    @MutationMapping
    public FeedBackInfo addFeedback(@Argument FeedBackInfo feedBackInfo) {
        feedBackService.addFeedback(feedBackInfo);
        return feedBackInfo;
    }


}

