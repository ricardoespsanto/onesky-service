package com.onesky.api.services;

import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Translation {

    String PROJECT_ID_PARAMETER = "project_id";

    /**
     * This action will create files from translations with specified locale.
     * When translation file is ready, this action will simply response with the file.
     *
     * @param projectId
     */
    @GET("/projects/{project_id}/translations")
    void exportTranslationInFiles(@Path(PROJECT_ID_PARAMETER) String projectId);

    /**
     * This action will create files from translations of specified file.
     * When translation file is ready, this action will simply response with the file.
     * Currently supported format is I18NEXT_MULTILINGUAL_JSON.
     * @param projectId
     */
    @GET("/projects/{project_id}/translations/multilingual")
    void exportTranslationInMultilingualFiles(@Path(PROJECT_ID_PARAMETER) String projectId);

    /**
     * This action is available for project of App Store Description and will export translations with
     * specified locale in JSON format.
     *
     * @param projectId
     */
    @GET("/projects/{project_id}/translations/app-descriptions")
    void appDescription(@Path("project_id") String projectId);

    /**
     * Return the progress of the translation of a specific file
     * @param projectId
     */
    @GET("/projects/{project_id}/translations/status")
    void translationStatus(@Path(PROJECT_ID_PARAMETER) String projectId);
}
