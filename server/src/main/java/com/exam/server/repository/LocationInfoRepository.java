package com.exam.server.repository;

import com.exam.server.entity.LocationInfo;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationInfoRepository extends JpaRepository<LocationInfo, Integer> {
    @NotNull
    public LocationInfo save(@NotNull LocationInfo locationInfo);

    public LocationInfo getLocationInfoByName(String locationName);
}
