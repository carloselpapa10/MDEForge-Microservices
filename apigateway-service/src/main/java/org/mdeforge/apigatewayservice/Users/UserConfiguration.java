package org.mdeforge.apigatewayservice.Users;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Configuration
public class UserConfiguration {

    @Value("${userservice.url}")
    private String userservice_url;

    @Value("${mdeforgeviewservice.url}")
    private String mdeforgeviewservice_url;

    @Bean
    RouteLocator gatewayUserServiceRouters(RouteLocatorBuilder builder){

        return builder.routes()
                .route(r -> r.path("/user").and().method("POST")
                        .filters(f -> f.rewritePath("/user","/createUser/user"))
                        .uri(userservice_url))
                .route(r -> r.path("/user/update").and().method("PUT")
                        .filters(f -> f.rewritePath("/user/update", "/updateUser/user"))
                        .uri(userservice_url))
                .route(r -> r.path("/user/id/**").and().method("GET")
                        .filters(f -> f.rewritePath("/user/id/(?<userId>.*)", "/findUser/${userId}"))
                        .uri(userservice_url))
                .route(r -> r.path("/user/email/**").and().method("GET")
                        .filters(f -> f.rewritePath("/user/email/(?<email>.*)", "/findUserByEmail/${email}"))
                        .uri(userservice_url))
                .route(r -> r.path("/user/username/**").and().method("GET")
                        .filters(f -> f.rewritePath("/user/username/(?<username>.*)", "/findUserByUsername/${username}"))
                        .uri(userservice_url))
                .route(r -> r.path("/user/delete/**").and().method("DELETE")
                        .filters(f -> f.rewritePath("/user/delete/(?<userId>.*)","/deleteUser/${userId}"))
                        .uri(userservice_url))
                .route(r -> r.path("/users").and().method("GET")
                        .filters(f -> f.rewritePath("/users","/retrieve/Users"))
                        .uri(userservice_url))
                .route(r -> r.path("/view/users").and().method("GET")
                        .filters(f -> f.rewritePath("/view/users", "/retrieve/Users"))
                        .uri(mdeforgeviewservice_url))
                .route(r -> r.path("/view/user/id/**").and().method("GET")
                        .filters(f -> f.rewritePath("/view/user/id/(?<userId>.*)", "/findUser/${userId}"))
                        .uri(mdeforgeviewservice_url))
                .route(r -> r.path("/view/user/email/**").and().method("GET")
                        .filters(f -> f.rewritePath("/view/user/email/(?<email>.*)", "/findUserByEmail/${email}"))
                        .uri(mdeforgeviewservice_url))
                .route(r -> r.path("/view/user/username/**").and().method("GET")
                        .filters(f -> f.rewritePath("/view/user/username/(?<username>.*)", "/findUserByUsername/${username}"))
                        .uri(mdeforgeviewservice_url))
                .build();
    }

    /*
    @Bean
    public RouterFunction<ServerResponse> userHandlerRouting(UserHandler userHandler){
        return RouterFunctions
                .route(GET("/user/{userId}").and(accept(APPLICATION_JSON)), userHandler::findUserById)
                .andRoute(POST("").and(accept(APPLICATION_JSON)), userHandler::createUser);
    }*/

    @Bean
    public UserHandler userHandler(){
        return new UserHandler(webClient());
    }

    @Bean
    public WebClient webClient(){
        return WebClient.create();
    }
}
