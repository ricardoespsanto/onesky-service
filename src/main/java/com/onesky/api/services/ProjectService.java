package com.onesky.api.services;

import com.onesky.model.ProjectDetail;
import com.onesky.model.ProjectLanguageList;

import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Project specific services.
 * <p>
 * See the <a href="https://github.com/onesky/api-documentation-platform/blob/master/resources/project.md">Project API documentation</a>.
 */
public interface ProjectService {

    /**
     * Retrieve details of a project
     *
     * @param projectId the id of the project
     * @return the details of the project
     */
    @GET("projects/{project_id}")
    ProjectDetail getProjectDetails(@Path("project_id") String projectId);

    /**
     * List languages of a project
     *
     * @param projectId the id of the project
     * @return A Project Language List
     */
    @GET("projects/{project_id}/languages")
    ProjectLanguageList listAllLanguagesForAProject(@Path("project_id") String projectId);

}
