package org.mdeforge.mdeforgeui.Service;

import org.mdeforge.mdeforgeui.Model.EcoreMetamodel;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.File;

import static org.springframework.web.reactive.function.BodyInserters.fromMultipartData;

@Service
public class ArtifactService {

    private WebClient client;

    public ArtifactService(WebClient client) {
        this.client = client;
    }

    public String createEcoreMetamodelArtifact(EcoreMetamodel artifact, File file){

        WebClient.RequestHeadersSpec<?> request = client.post()
                .uri("/artifact/ecoremetamodel")
                .body(fromMultipartData("file", new FileSystemResource(file)).with("artifact", artifact));

        String response = request.retrieve()
                .bodyToMono(String.class)
                .block();

        return response;
    }
}
