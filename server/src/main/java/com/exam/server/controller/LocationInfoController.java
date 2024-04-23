package com.exam.server.controller;

import com.exam.server.entity.LocationInfo;
import com.exam.server.repository.LocationInfoRepository;
import com.exam.server.service.LocationService;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class LocationInfoController {
    private LocationService locationService;


    public LocationInfoController(LocationService locationService) {
        this.locationService = locationService;
    }

    @MutationMapping
    public LocationInfo addLocation(@Argument LocationInfo locationInfo) {
        locationService.save(locationInfo);
        return locationInfo;
    }
    @QueryMapping
    public LocationInfo getLocationInfoByName(@Argument String name) {
        return locationService.getLocationByName(name);
    }
}