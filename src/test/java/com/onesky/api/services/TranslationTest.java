package com.onesky.api.services;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.onesky.api.ServiceBuilder;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import okhttp3.ResponseBody;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class TranslationTest {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule();

    @Ignore
    @Test
    public void exportTranslationInFiles() {
        String projectId = "1";
        String sourceFileName = "a";
        stubFor(get(urlEqualTo("/projects/" + projectId + "/translations"))
                .willReturn(aResponse().withHeader("source_file_name", sourceFileName).withBodyFile("TranslationTestFile")));

        ResponseBody translationInFiles = ServiceBuilder.build("", "").create(TranslationService.class)
                .exportTranslationInFiles(projectId, "", sourceFileName);

        Assert.assertTrue(translationInFiles.contentLength() > 0);
    }

}
