package com.onesky.api.services;

import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ImportTask {

    String PROJECT_ID_PARAMETER = "project_id";

    @GET("/projects/{project_id}/import-tasks")
    void listImportTask(@Path(PROJECT_ID_PARAMETER) String projectId);

    @GET("/projects/{project_id}/import-tasks/:import_id")
    void showImportTask(@Path(PROJECT_ID_PARAMETER) String projectId);

}
