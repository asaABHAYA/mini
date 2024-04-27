package com.exam.server.controller;

import com.exam.server.entity.FeedBackInfo;
import com.exam.server.entity.SiteFeedBack;
import com.exam.server.service.FeedBackService;
import java.util.List;

import com.exam.server.service.SiteFeedBackService;
import lombok.extern.log4j.Log4j2;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Log4j2
@Controller
public class SiteFeedBackController {
    private final SiteFeedBackService siteFeedBackService;

    public SiteFeedBackController(SiteFeedBackService siteFeedBackService) {
        this.siteFeedBackService = siteFeedBackService;
    }

    @QueryMapping
    public List<SiteFeedBack> getSiteFeedBackInfo() {
        return siteFeedBackService.getAllSiteFeedback();
    }

    @MutationMapping
    public SiteFeedBack saveSiteFeedBackInfo(@Argument SiteFeedBack siteFeedBack) {
        return siteFeedBackService.addSiteFeefBack(siteFeedBack);
    }
}

