package org.mdeforge.apigatewayservice.Artifacts;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArtifactConfiguration {

    @Value("${artifactservice.url}")
    private String artifactservice_url;

    @Value("${mdeforgeviewservice.url}")
    private String mdeforgeviewservice_url;

    @Bean
    RouteLocator gatewayArtifactServiceRouter(RouteLocatorBuilder builder){
        return builder.routes()
                .route(r -> r.path("/artifact/ecoremetamodel").and().method("POST")
                        .filters(f-> f.rewritePath("/artifact/ecoremetamodel","/createArtifact/ecoreMetamodel"))
                        .uri(artifactservice_url))
                .build();

    }

}
