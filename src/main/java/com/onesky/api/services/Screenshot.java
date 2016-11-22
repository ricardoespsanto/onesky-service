package com.onesky.api.services;

import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Screenshot {

    String PROJECT_ID_PARAMETER = "project_id";

    @GET("/projects/{project_id}/screenshots")
    void uploadScreenshot(@Path(PROJECT_ID_PARAMETER) String projectId);
}
