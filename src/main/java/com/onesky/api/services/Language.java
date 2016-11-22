package com.onesky.api.services;

import com.onesky.model.ProjectLanguageList;

import retrofit2.http.GET;

public interface Language {

    @GET("/locales")
    ProjectLanguageList listAllLocales();
}
