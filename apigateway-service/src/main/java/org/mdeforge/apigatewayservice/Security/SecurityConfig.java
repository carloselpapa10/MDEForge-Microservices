package org.mdeforge.apigatewayservice.Security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfig {

    @Value("${apigateway.user}")
    private String apigateway_user;

    @Value("${apigateway.pass}")
    private String apigateway_pass;

    @Value("${apigateway.roles}")
    private String apigateway_roles;

    @Bean
    SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http) throws Exception{
        return http.httpBasic().and()
                .csrf().disable()
                .authorizeExchange()
                .pathMatchers("/user/**").authenticated()
                .pathMatchers("/workspace/**").authenticated()
                .pathMatchers("/artifact/**").authenticated()
                .pathMatchers("/project/**").authenticated()
                .anyExchange().authenticated()
                .and()
                .build();
    }

    @Bean
    public MapReactiveUserDetailsService reactiveUserDetailsService(){

        UserDetails user = User.
                withUsername(apigateway_user)
                .password(passwordEncoder().encode(apigateway_pass))
                .roles(apigateway_user)
                .build();

        // UserDetails user = User.withDefaultPasswordEncoder().username("user").password("password").roles("ROLE_USER").build();
        return new MapReactiveUserDetailsService(user);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
