package com.onesky.api.services;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.onesky.api.ServiceBuilder;
import com.onesky.model.ProjectLanguageList;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import lombok.extern.java.Log;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@Log
public class LanguageTest {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule();

    @Test
    public void listAllLocales() {
        stubFor(get(urlMatching(".*/locales.*"))
                .willReturn(aResponse().withStatus(200).withBodyFile("LanguageTestResponse.json")));
        ProjectLanguageList projectLanguageList = ServiceBuilder.build("", "").create(LanguageService.class).listAllLocales();

        Assert.assertEquals(3, projectLanguageList.getLanguages().size());
        Assert.assertEquals(3, projectLanguageList.getMeta().getRecordCount());

        Assert.assertEquals("English (United States)", projectLanguageList.getLanguages().get(0).getEnglishName());
        Assert.assertEquals("日本語", projectLanguageList.getLanguages().get(1).getLocalName());
        Assert.assertEquals("ko", projectLanguageList.getLanguages().get(2).getLocale());
        Assert.assertEquals("KR", projectLanguageList.getLanguages().get(2).getRegion());
    }

}
