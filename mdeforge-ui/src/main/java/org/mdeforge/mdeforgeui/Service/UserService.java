package org.mdeforge.mdeforgeui.Service;

import org.mdeforge.mdeforgeui.Model.User;
import org.mdeforge.mdeforgeui.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;

@Service
public class UserService {

    @Value("${apigateway.service.url}")
    private String apigateway_service_url;

    private final UserRepository userRepository;

    public User signUp(User user){

        /*TODO review this process*/
        WebClient.RequestHeadersSpec<?> request = WebClient
                .create(apigateway_service_url)
                .post()
                .uri("/user")
                .body(BodyInserters.fromObject(user));

        String userId = request.retrieve().bodyToMono(String.class).block();

        return null;
    }

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }
}
