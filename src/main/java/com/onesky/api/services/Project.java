package com.onesky.api.services;

import com.onesky.model.ProjectDetail;
import com.onesky.model.ProjectList;

import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Project {

    String PROJECT_ID_PARAMETER = "project_id";

    @GET("/project-groups/{project_group_id}/projects")
    ProjectList getAllProjectsOfAProjectGroup(@Path(PROJECT_ID_PARAMETER) String projectId);

    @GET("/projects/{project_id}")
    ProjectDetail getProjectDetails(@Path(PROJECT_ID_PARAMETER) String projectId);

    @POST("/project-groups/{project_group_id}/projects")
    void createANewProject(@Path(PROJECT_ID_PARAMETER) String projectId);

    @PUT("/projects/{project_id}")
    void updateAProject(@Path(PROJECT_ID_PARAMETER) String projectId);

    /**
     *
     * @param projectId
     */
    @DELETE("/projects/{project_id}")
    void deleteAProject(@Path(PROJECT_ID_PARAMETER) String projectId);

    /**
     * List languages of a project
     * @param projectId
     */
    @GET("/projects/{project_id}/languages")
    void listAllLanguagesForAProject(@Path(PROJECT_ID_PARAMETER) String projectId);

}
