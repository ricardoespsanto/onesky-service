package com.onesky.api.services;

import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface File {

    String PROJECT_ID_PARAMETER = "project_id";

    @GET("/projects/{project_id}/files")
    void listUploadedFiles(@Path(PROJECT_ID_PARAMETER) String projectId);

    @POST("/projects/{project_id}/files")
    void uploadAFile(@Path(PROJECT_ID_PARAMETER) String projectId);

    @DELETE("/projects/{project_id}/files")
    void deleteAFile(@Path(PROJECT_ID_PARAMETER) String projectId);

}
