package com.exam.server.service;

import com.exam.server.entity.FeedBackInfo;
import com.exam.server.repository.FeedBackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedBackService {

    @Autowired
    private FeedBackRepository feedBackRepository;

    public void addFeedback(FeedBackInfo info){
        feedBackRepository.save(info);
    }
    public List<FeedBackInfo> findAllByLocation(String location){
        return  feedBackRepository.findAllByLocation(location);
    }
    public List<FeedBackInfo> getAllFeedBackInfo(){
        return feedBackRepository.findAll();
    }
}

