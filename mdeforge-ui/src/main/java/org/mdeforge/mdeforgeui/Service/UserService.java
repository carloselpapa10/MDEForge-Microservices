package org.mdeforge.mdeforgeui.Service;

import org.mdeforge.mdeforgeui.Model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
public class UserService {

    @Value("${apigateway.service.url}")
    private String apigateway_service_url;

    private WebClient client;

    public UserService(WebClient client) {
        this.client = client;
    }

    public User signUp(User user){

        WebClient.RequestHeadersSpec<?> request = client.post()
                .uri(apigateway_service_url + "/user")
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(user));

        String userId = request.retrieve()
                .bodyToMono(String.class)
                .block();

        if(userId!=null){
            return new User(userId);
        }
        return null;
    }

    public User findUserByEmail(String email){

        /*Mono<User> mono = client.get()
                .uri(apigateway_service_url+"/user/email/"+email)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMap(response -> response.bodyToMono(User.class));

        User user = mono.block();*/

        /*for testing */
        User u = new User();
        u.setId("5b965e5d7b4ab54c6bd18c38");
        u.setEmail("martha@example.com");
        u.setPassword("{bcrypt}$2a$10$kZtoErH4gyoGhmflk8YCbedGH3v/ieSTTT2OJuI5.yFGF8wvrEaLW");
        u.setUsername("martha10");

        return u;
    }

    public User findUserByUsername(String username){

        Mono<User> mono = client.get()
                .uri(apigateway_service_url+"/user/username/"+username)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMap(response -> response.bodyToMono(User.class));

        User user = mono.block();

        return user;

    }

}
