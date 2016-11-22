package com.onesky.api.services;

import java.util.List;

import retrofit2.http.GET;

public interface ProjectType {

    @GET("/project-types")
    List<ProjectType> getAllProjectTypes();
}
