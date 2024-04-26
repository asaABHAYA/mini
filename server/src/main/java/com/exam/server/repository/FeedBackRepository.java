package com.exam.server.repository;

import com.exam.server.entity.FeedBackInfo;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedBackRepository extends JpaRepository<FeedBackInfo, Integer> {

    public List<FeedBackInfo> findAllByLocation(String location);

    public List<FeedBackInfo> findAll();

    @NotNull
    @Override
    public FeedBackInfo save(@NotNull FeedBackInfo feedBackInfo);
}
