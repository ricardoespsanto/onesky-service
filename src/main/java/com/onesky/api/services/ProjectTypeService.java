package com.onesky.api.services;

import java.util.List;

import com.onesky.model.ProjectType;

import retrofit2.http.GET;

/**
 * Project Type specific endpoints.
 * <p>
 * See the <a href="https://github.com/onesky/api-documentation-platform/blob/master/resources/project_type.md">Project type API documentation</a>.
 */
public interface ProjectTypeService {

    /**
     * List all project types
     *
     * @return a List of Project types
     */
    @GET("project-types")
    List<ProjectType> getAllProjectTypes();
}
