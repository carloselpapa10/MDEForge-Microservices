package org.mdeforge.mdeforgeui.Service;

import org.mdeforge.mdeforgeui.Model.EcoreMetamodel;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ArtifactService {

    private WebClient client;

    public ArtifactService(WebClient client) {
        this.client = client;
    }

    public String createEcoreMetamodelArtifact(EcoreMetamodel artifact){

        WebClient.RequestHeadersSpec<?> request = client.post()
                .uri("/artifact/ecoremetamodel")
                .accept(MediaType.APPLICATION_JSON)
                .accept(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromObject(artifact));

        String response = request.retrieve()
                .bodyToMono(String.class)
                .block();

        return response;
    }
}
