package org.mdeforge.mdeforgeui.Service;

import org.mdeforge.mdeforgeui.Model.Workspace;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class WorkspaceService {

    @Value("${apigateway.service.url}")
    private String apigateway_service_url;

    private WebClient client;

    public WorkspaceService(WebClient client) {
        this.client = client;
    }

    public List<Workspace> findWorkspaceListByUserEmail(String email){

        return null;
    }



}
