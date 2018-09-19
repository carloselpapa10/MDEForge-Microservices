package org.mdeforge.apigatewayservice.Workspaces;

import org.mdeforge.apigatewayservice.Users.UserNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;

public class WorkspaceHandler {

    @Value("${workspaceservice.url}")
    private String workspaceservice_url;

    private final WebClient client;

    public WorkspaceHandler(WebClient client) {
        this.client = client;
    }

    public Mono<ServerResponse> addProjectToWorkspace(ServerRequest request){
        String workspaceId = request.queryParam("workspaceId").get();
        String projectId = request.queryParam("projectId").get();

        Mono<ClientResponse> response = client
                .put()
                .uri(workspaceservice_url+"/addProjectToWorkspace/workspace?workspaceId="+workspaceId+"&projectId="+projectId)
                .exchange();

        return response.flatMap(od -> ServerResponse.ok()
            //.contentType(MediaType.APPLICATION_JSON)
            .body(fromObject(od)))
                .onErrorResume(UserNotFoundException.class, e -> ServerResponse.notFound().build());
    }
}
