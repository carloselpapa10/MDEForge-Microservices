package org.mdeforge.mdeforgeui.Service;

import org.mdeforge.mdeforgeui.Model.Workspace;
import org.mdeforge.mdeforgeui.WebApi.CreateProjectResponse;
import org.mdeforge.mdeforgeui.WebApi.CreateWorkspaceResponse;
import org.mdeforge.mdeforgeui.WebApi.WorkspaceRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class WorkspaceService {

    private WebClient client;

    public WorkspaceService(WebClient client) {
        this.client = client;
    }

    public String createWorkspace(WorkspaceRequest workspaceRequest){

        WebClient.RequestHeadersSpec<?> request = client.post()
                .uri("/workspace")
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(workspaceRequest));

        CreateWorkspaceResponse response = request.retrieve()
                .bodyToMono(CreateWorkspaceResponse.class)
                .block();

        return response != null ? response.getWorkspaceId() : null;
    }

    public String addProjectToWorkspace(String workspaceId, String projectId){

        Mono<String> mono = client.get()
                .uri("/workspace/addProjectToWorkspace?workspaceId="+workspaceId+"&projectId="+projectId)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMap(response -> response.bodyToMono(String.class));

        String id = mono.block();

        return id;
    }

    public String removeProjectToWorkspace(String workspaceId, String projectId){

        Mono<String> mono = client.get()
                .uri("/workspace/removeProjectInWorkspace?workspaceId="+workspaceId+"&projectId="+projectId)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMap(response -> response.bodyToMono(String.class));

        String id = mono.block();

        return id;
    }

    public String removeProjectInAllWorkspaces(String projectId){

        Mono<String> mono = client.get()
                .uri("/workspace/removeProjectInAllWorkspaces/"+projectId)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMap(response -> response.bodyToMono(String.class));

        return mono.block();
    }



    public Workspace findWorkspaceById(String id){

        Mono<Workspace> mono = client.get()
                .uri("/view/workspace/id/"+id)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMap(response -> response.bodyToMono(Workspace.class));

        Workspace workspace = mono.block();

        return workspace;
    }

    public List<Workspace> findWorkspaceListByUserEmail(String email){

        Flux<Workspace> flux = client.get()
                .uri("/view/workspaces/owner_email/"+email)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Workspace.class);

        List<Workspace> workspaceList = flux.collectList().block();
        return workspaceList;
    }

    public String deleteWorkspace(String workspaceId){

        Mono<String> mono = client.delete()
                .uri("/workspace/delete/"+workspaceId)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMap(response -> response.bodyToMono(String.class));

        return mono.block();
    }



}
