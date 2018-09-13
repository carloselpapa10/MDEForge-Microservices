package org.mdeforge.mdeforgeui.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;

@EnableWebSecurity
public class SecurityConfig{

    @Configuration
    public static class LoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter{

        @Override
        protected void configure(HttpSecurity http) throws Exception{
            http
                    .authorizeRequests()
                        .antMatchers("/theme/**","/bootstrap/**","/resources/**", "/login", "/signup","/webjars/**").permitAll()
                        .antMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                    .and()
                        .httpBasic()
                    .and()
                        .formLogin()
                    .loginPage("/login")
                    .and()
                        .oauth2Login()
                            .defaultSuccessUrl("/loginSuccess")
                            .failureUrl("/loginFailure")
                            .loginPage("/login")
                            .userInfoEndpoint()
                                .customUserType(GitHubOAuth2User.class, "github");
                                //.userService(this.oauth2UserService())
                                                  ;
        }

        private OAuth2UserService<OAuth2UserRequest, OAuth2User> oauth2UserService() {
            return new CustomOAuth2UserService();
        }

        @Bean
        PasswordEncoder passwordEncoder(){
            return PasswordEncoderFactories.createDelegatingPasswordEncoder();
        }
    }

}
