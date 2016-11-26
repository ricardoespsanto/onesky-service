package com.onesky.api.services;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.onesky.api.ServiceBuilder;
import com.onesky.model.UploadedFilesResponse;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@RunWith(BlockJUnit4ClassRunner.class)
public class FileTest {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule();

    @Test
    public void listUploadedFiles() {
        String projectId = "1";
        stubFor(get(urlMatching(".*/projects/" + projectId + "/files.*"))
                .willReturn(aResponse().withStatus(200).withBodyFile("FileTestResponse.json")));

        UploadedFilesResponse uploadedFilesResponse = ServiceBuilder.build("", "").create(FilesService.class)
                .listUploadedFiles(projectId);

        Assert.assertEquals(2, uploadedFilesResponse.getMeta().getRecordCount());
        Assert.assertEquals("strings.po", uploadedFilesResponse.getUploadedFiles().get(0).getFileName());
    }
}
