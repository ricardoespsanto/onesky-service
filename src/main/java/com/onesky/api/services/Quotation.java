package com.onesky.api.services;

import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Quotation {

    String PROJECT_ID_PARAMETER = "project_id";

    @GET("/projects/{project_id}/quotations")
    void makeAQuotation(@Path(PROJECT_ID_PARAMETER) String projectId);
}
