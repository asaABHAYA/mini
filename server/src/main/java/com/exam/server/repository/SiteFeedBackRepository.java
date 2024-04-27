package com.exam.server.repository;

import java.util.List;

import com.exam.server.entity.SiteFeedBack;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteFeedBackRepository extends JpaRepository<SiteFeedBack, Integer> {

    public List<SiteFeedBack> findAll();

    @NotNull
    @Override
    public SiteFeedBack save(@NotNull SiteFeedBack siteFeedBack);
}
