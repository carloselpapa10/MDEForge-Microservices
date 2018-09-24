package org.mdeforge.mdeforgeui.Service;

import org.mdeforge.mdeforgeui.Model.Project;
import org.mdeforge.mdeforgeui.WebApi.CreateProjectResponse;
import org.mdeforge.mdeforgeui.WebApi.ProjectRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    private WebClient client;

    public ProjectService(WebClient client) {
        this.client = client;
    }

    public String createProject(ProjectRequest projectRequest){

        WebClient.RequestHeadersSpec<?> request = client.post()
                .uri("/project")
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(projectRequest));

        CreateProjectResponse response = request.retrieve()
                .bodyToMono(CreateProjectResponse.class)
                .block();

        return response != null ? response.getIdProject() : null;
    }

    public Project findProjectById(String id){

        Mono<Project> mono = client.get()
                .uri("/view/project/id/"+id)
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

    public String deleteProject(String projectId){

        Mono<String> mono = client.delete()
                .uri("/project/delete/"+projectId)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMap(response -> response.bodyToMono(String.class));

        return mono.block();
    }

    public String addUserInProject(String projectId, String userId){

        Mono<String> mono = client.get()
                .uri("/project/addUserInProject?projectId="+projectId+"&userId="+userId)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMap(response -> response.bodyToMono(String.class));

        String id = mono.block();

        return id;
    }

    public String removeUserFromProject(String projectId, String userId){

        Mono<String> mono = client.get()
                .uri("/project/removeUserFromProject?projectId="+projectId+"&userId="+userId)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMap(response -> response.bodyToMono(String.class));

        String id = mono.block();

        return id;
    }



}
