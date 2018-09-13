package org.mdeforge.mdeforgeui.Controller;

import org.mdeforge.mdeforgeui.Model.User;
import org.mdeforge.mdeforgeui.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @Autowired
    private OAuth2AuthorizedClientService authorizedClientService;

    @GetMapping("/")
    public String index(){

        return "redirect:/app";
    }

    @GetMapping("/completeUserInfomation")
    public String oauth2Login(Model model, OAuth2AuthenticationToken authentication){

        /*1. get email by spring context. 2. search in database 3. redirect if it appears 3.1. save user data if not. 4. send it to complete authentication form otherwise*/

        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        OAuth2AuthorizedClient authorizedClient = this.authorizedClientService.loadAuthorizedClient(authentication.getAuthorizedClientRegistrationId(),
                                                                                                        authentication.getName());
        Map userAttributes = Collections.emptyMap();
        String userInfoEndpointUri = authorizedClient.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUri();

        if(!StringUtils.isEmpty(userInfoEndpointUri)){

            userAttributes = WebClient.builder()
                    .filter(oauth2Credentials(authorizedClient))
                    .build()
                    .get()
                    .uri(userInfoEndpointUri)
                    .retrieve()
                    .bodyToMono(Map.class)
                    .block();
        }

        model.addAttribute("userAttributes", userAttributes);

        Object email = userAttributes.get("email");

        /*
        if(email!=null){
            User user = userService.findUserByEmail(email.toString());

            if(user!=null){
                return "redirect:/app";
            }
        }
        */

        User user = userService.findUserByEmail(email != null ? email.toString() : null);

        //userService.signUp(user); /*save user information*/

        user.setImage(userAttributes.get("picture") != null ? userAttributes.get("picture").toString() : null);
        model.addAttribute("user", user);

        return "private/userInformationForm";
    }

    private ExchangeFilterFunction oauth2Credentials(OAuth2AuthorizedClient authorizedClient){

        return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
            ClientRequest authorizedRequest = ClientRequest.from(clientRequest)
                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + authorizedClient.getAccessToken().getTokenValue())
                    .build();
            return Mono.just(authorizedRequest);
        });
    }

    @GetMapping("/loginFailure")
    public String oauth2LoginFailure(){
        return "loginFailure";
    }
}
