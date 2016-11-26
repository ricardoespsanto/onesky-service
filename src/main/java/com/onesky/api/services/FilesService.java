package com.onesky.api.services;

import com.onesky.model.UploadedFilesResponse;

import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * File specific endpoints
 * <p>
 * See the <a href="https://github.com/onesky/api-documentation-platform/blob/master/resources/file.md">File API documentation</a>.
 */
public interface FilesService {

    /**
     * List all uploaded files for a given project
     *
     * @param projectId the id of the project
     * @return An Uploaded Files Response
     */
    @GET("projects/{project_id}/files")
    UploadedFilesResponse listUploadedFiles(@Path("project_id") String projectId);

}
