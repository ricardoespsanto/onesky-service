package com.onesky.api.services;

import com.onesky.model.ProjectGroupList;
import com.onesky.model.ProjectList;

import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * https://github.com/onesky/api-documentation-platform/blob/master/resources/project_group.md
 */
public interface ProjectGroup {

    String PROJECT_GROUP_ID_PARAMETER = "project_group_id";

    /**
     * Retrieve all project groups
     *
     * @return
     */
    @GET("/project-groups")
    ProjectGroupList getAllProjectGroups();

    /**
     * Retrieve details of a project group
     *
     * @param projectGroupId the id of the project group
     * @return a ProjectList
     */
    @GET("/project-groups/{project_group_id}")
    ProjectList getDetailsOfProjectGroup(@Path(PROJECT_GROUP_ID_PARAMETER) String projectGroupId);


    @POST("/project-groups")
    void createANewProjectGroup();

    @DELETE("/project-groups/{project_group_id}")
    void deleteAProjectGroup(@Path(PROJECT_GROUP_ID_PARAMETER) String projectGroupId);

    @GET("/{project_group_id}/languages")
    void getProjectGroupLanguages(@Path(PROJECT_GROUP_ID_PARAMETER) String projectGroupId);
}
