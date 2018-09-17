package org.mdeforge.mdeforgeui.Service;

import org.mdeforge.mdeforgeui.Model.Project;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    @Value("${apigateway.service.url}")
    private String apigateway_service_url;

    private WebClient client;

    public ProjectService(WebClient client) {
        this.client = client;
    }

    public Project findProjectById(String id){

        Mono<Project> mono = client.get()
                .uri(apigateway_service_url+"/project/id/"+id)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMap(response -> response.bodyToMono(Project.class));

        Project project = mono.block();

        return project;
    }

    public List<Project> findAllProjects(){

        Flux<Project> flux = client.get()
                .uri("/view/projects")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Project.class);

        List<Project> projectList = flux.collectList().block();

        return projectList;
    }

    public List<Project> findProjectListByUserEmail(String email){

        Flux<Project> flux = client.get()
                .uri("/view/projects/owner_email/"+email)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Project.class);

        List<Project> projectList = flux.collectList().block();

        return projectList;
    }
}
