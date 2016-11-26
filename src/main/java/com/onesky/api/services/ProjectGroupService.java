package com.onesky.api.services;

import com.onesky.model.ProjectGroupList;
import com.onesky.model.ProjectList;

import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Project Group specific endpoints.
 * <p>
 * See the <a href="https://github.com/onesky/api-documentation-platform/blob/master/resources/project_group.md">Project group API documentation</a>.
 */
public interface ProjectGroupService {

    /**
     * List projects of a project group
     *
     * @param projectId the id of the project
     * @return A List of Projects
     */
    @GET("project-groups/{project_group_id}/projects")
    ProjectList getAllProjectsOfAProjectGroup(@Path("project_group_id") String projectId);

    /**
     * Retrieve all project groups
     *
     * @return a Project Group list
     */
    @GET("project-groups")
    ProjectGroupList getAllProjectGroups();

    /**
     * Retrieve details of a project group
     *
     * @param projectGroupId the id of the project group
     * @return a ProjectList
     */
    @GET("project-groups/{project_group_id}")
    ProjectList getDetailsOfProjectGroup(@Path("project_group_id") String projectGroupId);
}
