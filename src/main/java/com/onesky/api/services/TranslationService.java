package com.onesky.api.services;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Translation specific endpoints.
 * <p>
 * See the <a href="https://github.com/onesky/api-documentation-platform/blob/master/resources/translation.md">Translation API documentation</a>.
 */
public interface TranslationService {

    /**
     * This action will create files from translations with specified locale.
     * When translation file is ready, this action will simply response with the file.
     *
     * @param projectId      the id of the project
     * @param locale         the locale for which the file's content was uploaded
     * @param sourceFileName the file name
     * @return The actual file as a download
     */
    @GET("projects/{project_id}/translations")
    ResponseBody exportTranslationInFiles(@Path("project_id") String projectId, @Query("locale") String locale,
            @Query("source_file_name") String sourceFileName);

}
