package org.mdeforge.mdeforgeui.Service;

import org.mdeforge.mdeforgeui.Model.Workspace;
import org.mdeforge.mdeforgeui.WebApi.WorkspaceRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class WorkspaceService {

    private WebClient client;

    public WorkspaceService(WebClient client) {
        this.client = client;
    }

    public Workspace createWorkspace(WorkspaceRequest workspaceRequest){

        WebClient.RequestHeadersSpec<?> request = client.post()
                .uri("/workspace")
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(workspaceRequest));

        String workspaceId = request.retrieve()
                .bodyToMono(String.class)
                .block();

        return workspaceId != null ? new Workspace(workspaceId) : null;
    }

    public List<Workspace> findWorkspaceListByUserEmail(String email){

        return null;
    }



}
