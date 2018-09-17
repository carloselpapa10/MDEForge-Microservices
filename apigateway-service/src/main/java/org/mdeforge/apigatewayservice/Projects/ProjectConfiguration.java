package org.mdeforge.apigatewayservice.Projects;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfiguration {

    @Value("${projectservice.url}")
    private String projectservice_url;

    @Value("${mdeforgeviewservice.url}")
    private String mdeforgeviewservice_url;

    @Bean
    RouteLocator gatewayProjectServiceRouters(RouteLocatorBuilder builder){
        return builder.routes()
                .route(r -> r.path("/project").and().method("POST")
                        .filters(f-> f.rewritePath("/project","/createProject/project"))
                    .uri(projectservice_url))
                .route(r -> r.path("/project/update").and().method("PUT")
                        .filters(f -> f.rewritePath("/project/update","/updateProject/project"))
                    .uri(projectservice_url))
                .route(r -> r.path("/project/id/*").and().method("GET")
                        .filters(f->f.rewritePath("/project/id/(?<projectId>.*)","/findProject/%7BprojectId%7D?id=${projectId}"))
                    .uri(projectservice_url))
                .route(r -> r.path("/project/delete/*").and().method("DELETE")
                        .filters(f -> f.rewritePath("/project/id/(?<projectId>.*)","/deleteProject/%7BprojectId%7D?id=${projectId}"))
                    .uri(projectservice_url))
                .route(r->r.path("/projects").and().method("GET")
                        .filters(f->f.rewritePath("/projects","/retrieve/Projects"))
                    .uri(projectservice_url))
                .route(r->r.path("/view/projects").and().method("GET")
                        .filters(f->f.rewritePath("/view/projects","/retrieve/Projects"))
                        .uri(mdeforgeviewservice_url))
                .route(r -> r.path("/view/projects/owner_email/**").and().method("GET")
                        .filters(f->f.rewritePath("/view/projects/owner_email/(?<email>.*)", "/findProjectListByUserEmail/%7Bemail%7D?email=${email}"))
                        .uri(mdeforgeviewservice_url))
                .build();
    }


}
