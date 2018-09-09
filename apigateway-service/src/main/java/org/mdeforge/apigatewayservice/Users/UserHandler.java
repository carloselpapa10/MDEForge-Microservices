package org.mdeforge.apigatewayservice.Users;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;

public class UserHandler {

    @Value("${userservice.url}")
    private String orderservice_url;

    private final WebClient client;

    public UserHandler(WebClient client) {
        this.client = client;
    }

    public Mono<ServerResponse> findUserById(ServerRequest request){

        String userId = request.pathVariable("userId");
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();

        Mono<ClientResponse> response = client
                .get()
                .uri(orderservice_url+"/findUser/{userId}", userId)
                .exchange();

        return response.flatMap(
                users -> ok()
                        .body(fromObject(users)))
                .onErrorResume(UserNotFoundException.class, e->notFound);
    }

}
