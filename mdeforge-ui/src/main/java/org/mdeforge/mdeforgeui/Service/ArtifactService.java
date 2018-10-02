package org.mdeforge.mdeforgeui.Service;

import org.mdeforge.mdeforgeui.Model.EcoreMetamodel;
import org.mdeforge.mdeforgeui.WebApi.EcoreMetamodelRequest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.io.File;
import java.util.List;

import static org.springframework.web.reactive.function.BodyInserters.fromMultipartData;

@Service
public class ArtifactService {

    private WebClient client;

    public ArtifactService(WebClient client) {
        this.client = client;
    }

    public List<EcoreMetamodel> searchEcoreMetamodel(String userId){

        Flux<EcoreMetamodel> flux = client.get()
                .uri("/view/ecoreMetamodels/user_id/"+userId)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(EcoreMetamodel.class);

        List<EcoreMetamodel> ecoreMetamodelList = flux.collectList().block();

        return ecoreMetamodelList;
    }

    public String createEcoreMetamodelArtifact(EcoreMetamodelRequest ecoreMetamodelRequest, File file){

        WebClient.RequestHeadersSpec<?> request = client.post()
                .uri("/artifact/ecoremetamodel")
                .body(fromMultipartData("file", new FileSystemResource(file)).with("artifact", ecoreMetamodelRequest));

        String response = request.retrieve()
                .bodyToMono(String.class)
                .block();

        return response;
    }
}
