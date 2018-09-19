package org.mdeforge.apigatewayservice.Workspaces;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import org.springframework.web.reactive.function.server.RouterFunctions;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class WorkspaceConfiguration {

    @Value("${workspaceservice.url}")
    private String workspaceservice_url;

    @Value("${mdeforgeviewservice.url}")
    private String mdeforgeviewservice_url;

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
                        .filters(f -> f.rewritePath("/workspace/id/(?<workspaceId>.*)","/findWorkspace/${workspaceId}"))
                    .uri(workspaceservice_url))
                .route(r -> r.path("/workspace/delete/*").and().method("DELETE")
                        .filters(f -> f.rewritePath("/workspace/delete/(?<workspaceId>.*)","/deleteWorkspace/${workspaceId}"))
                    .uri(workspaceservice_url))
                .route(r -> r.path("/workspaces").and().method("GET")
                        .filters(f -> f.rewritePath("/workspaces","/retrieve/Workspaces"))
                    .uri(workspaceservice_url))

                .route(r -> r.path("/view/workspace/id/*").and().method("GET")
                        .filters(f -> f.rewritePath("/view/workspace/id/(?<workspaceId>.*)","/findWorkspace/${workspaceId}"))
                        .uri(mdeforgeviewservice_url))
                .route(r -> r.path("/view/workspaces").and().method("GET")
                        .filters(f -> f.rewritePath("/view/workspaces", "/retrieve/Workspaces"))
                    .uri(mdeforgeviewservice_url))
                .route(r -> r.path("/view/workspaces/owner_email/**").and().method("GET")
                        .filters(f->f.rewritePath("/view/workspaces/owner_email/(?<email>.*)", "/findWorkspaceListByUserEmail/${email}"))
                        .uri(mdeforgeviewservice_url))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> workspaceHandlerRouting(WorkspaceHandler workspaceHandler){

        return RouterFunctions
                    .route(PUT("/workspace/addProjectToWorkspace").and(accept(APPLICATION_JSON)), workspaceHandler::addProjectToWorkspace);

    }

    @Bean
    public WorkspaceHandler workspaceHandler(){
        return new WorkspaceHandler(webClient());
    }

    @Bean
    public WebClient webClient(){
        return WebClient.create();
    }
}

/*
*  .route(r -> r.path("/workspace/addProjectToWorkspace/").and().method("PUT")
        .filters(f -> f.rewritePath("/workspace/addProjectToWorkspace/(?<workspaceId>.*)/(?<projectId>.*)","/addProjectToWorkspace/workspace?workspaceId=${workspaceId}&projectId=${projectId}"))
        .uri(workspaceservice_url))

        * */
