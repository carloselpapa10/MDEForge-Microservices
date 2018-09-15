package org.mdeforge.apigatewayservice.Workspaces;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorkspaceConfiguration {

    @Value("${workspaceservice.url}")
    private String workspaceservice_url;

    @Bean
    RouteLocator gatewayWorkspaceServiceRouters(RouteLocatorBuilder builder){
        return builder.routes()
                .route(r -> r.path("/workspace").and().method("POST")
                        .filters(f -> f.rewritePath("/workspace", "/createWorkspace/workspace"))
                    .uri(workspaceservice_url))
                .route(r -> r.path("/workspace/update").and().method("PUT")
                        .filters(f -> f.rewritePath("/workspace/update","/updateWorkspace/workspace"))
                    .uri(workspaceservice_url))
                .route(r -> r.path("/workspace/id/*").and().method("GET")
                        .filters(f -> f.rewritePath("/workspace/id/(?<workspaceId>.*)","/findWorkspace/%7BworkspaceId%7D?id=${workspaceId}"))
                    .uri(workspaceservice_url))
                .route(r -> r.path("/workspace/delete/*").and().method("DELETE")
                        .filters(f -> f.rewritePath("/workspace/delete/(?<workspaceId>.*)","/deleteWorkspace/%7BworkspaceId%7D?id=${workspaceId}"))
                    .uri(workspaceservice_url))
                .route(r -> r.path("/workspaces").and().method("GET")
                        .filters(f -> f.rewritePath("/workspaces","/retrieve/Workspaces"))
                    .uri(workspaceservice_url))
                .build();
    }
}