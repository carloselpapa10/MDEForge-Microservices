package org.mdeforge.mdeforgeui.Service;

import org.mdeforge.mdeforgeui.Model.Workspace;
import org.mdeforge.mdeforgeui.WebApi.WorkspaceRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

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

        String workspaceId = request.retrieve()
                .bodyToMono(String.class)
                .block();

        return workspaceId;
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



}
