package org.mdeforge.mdeforgeui.Service;

import org.mdeforge.mdeforgeui.Model.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.List;


@Service
public class UserService {

    private WebClient client;

    public UserService(WebClient client) {
        this.client = client;
    }

    public User signUp(User user){

        WebClient.RequestHeadersSpec<?> request = client.post()
                .uri("/user")
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

        Mono<User> mono = client.get()
                .uri("/user/email/"+email)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMap(response -> response.bodyToMono(User.class));

        User user = mono.block();

        /*for testing
        User u = new User();
        u.setId("5b965e5d7b4ab54c6bd18c38");
        u.setEmail("martha@example.com");
        u.setPassword("{bcrypt}$2a$10$kZtoErH4gyoGhmflk8YCbedGH3v/ieSTTT2OJuI5.yFGF8wvrEaLW");
        u.setUsername("martha10");
        u.setFirstName("Martha");
        u.setLastName("Caro");*/

        return user;
    }

    public User findUserByUsername(String username){

        Mono<User> mono = client.get()
                .uri("/user/username/"+username)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMap(response -> response.bodyToMono(User.class));

        User user = mono.block();

        return user;

    }

    public List<User> findAllUsers(){

        Flux<User> flux = client.get()
                .uri("/users")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(User.class);

        List<User> userList = flux.collectList().block();

        return userList;
    }

}
