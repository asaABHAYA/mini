package com.exam.server.service;

import com.exam.server.entity.SiteFeedBack;

import java.util.List;

import com.exam.server.repository.SiteFeedBackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiteFeedBackService {

    @Autowired
    private SiteFeedBackRepository siteFeedBackRepository;

    public List<SiteFeedBack> getAllSiteFeedback(){
        return siteFeedBackRepository.findAll();
    }

    public SiteFeedBack addSiteFeefBack(SiteFeedBack siteFeedBack){
        return siteFeedBackRepository.save(siteFeedBack);
    }
}

