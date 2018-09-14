package org.mdeforge.mdeforgeui.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ArtifactService {

    @Value("${apigateway.service.url}")
    private String apigateway_service_url;

    private WebClient client;

    public ArtifactService(WebClient client) {
        this.client = client;
    }
}
