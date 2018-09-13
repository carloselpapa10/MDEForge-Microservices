package org.mdeforge.mdeforgeui.Security;

import org.mdeforge.mdeforgeui.Model.User;
import org.mdeforge.mdeforgeui.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@Component
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    @Autowired
    private UserService userService;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {


        User u = new User();
        u.setId("5b965e5d7b4ab54c6bd18c38");
        u.setEmail("martha@example.com");
        u.setPassword("{bcrypt}$2a$10$kZtoErH4gyoGhmflk8YCbedGH3v/ieSTTT2OJuI5.yFGF8wvrEaLW");
        u.setUsername("martha10");


        Map userAttributes = Collections.emptyMap();
        String userInfoEndpointUri = oAuth2UserRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUri();


        if(!StringUtils.isEmpty(userInfoEndpointUri)){
            userAttributes = WebClient.builder()
                    .filter(oauth2Credentials(oAuth2UserRequest.getAccessToken().getTokenType().getValue()))
                    .build()
                    .get()
                    .uri(userInfoEndpointUri)
                    .retrieve()
                    .bodyToMono(Map.class)
                    .block();
        }

        return new CustomOAuthUser(u);
    }

    private ExchangeFilterFunction oauth2Credentials(String tokenValue){

        return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
            ClientRequest authorizedRequest = ClientRequest.from(clientRequest)
                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + tokenValue)
                    .build();
            return Mono.just(authorizedRequest);
        });
    }

    static class CustomOAuthUser extends User implements OAuth2User{

        private String name="Nameee";

        public CustomOAuthUser(User user) {
            super(user);
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return AuthorityUtils.createAuthorityList("ROLE_USER");
        }

        @Override
        public Map<String, Object> getAttributes() {
            return null;
        }

        @Override
        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
