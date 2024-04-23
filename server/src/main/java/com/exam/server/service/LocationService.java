package com.exam.server.service;

import com.exam.server.entity.LocationInfo;
import com.exam.server.repository.LocationInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private final LocationInfoRepository locationInfoRepository;

    public LocationService(LocationInfoRepository locationInfoRepository) {
        this.locationInfoRepository = locationInfoRepository;
    }

    public LocationInfo save(LocationInfo locationInfo) {
        locationInfoRepository.save(locationInfo);
        return locationInfo;
    }

    public LocationInfo getLocationByName(String locationName) {
        return locationInfoRepository.getLocationInfoByName(locationName);
    }
}
