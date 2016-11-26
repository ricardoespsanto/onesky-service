package com.onesky.api.services;

import com.onesky.model.ProjectLanguageList;

import retrofit2.http.GET;

/**
 * Locale specific endpoints.
 * <p>
 * See the <a href="https://github.com/onesky/api-documentation-platform/blob/master/resources/locale.md">Locale API documentation</a>.
 */
public interface LanguageService {

    /**
     * List all locales
     *
     * @return A Project Language List
     */
    @GET("locales")
    ProjectLanguageList listAllLocales();
}
