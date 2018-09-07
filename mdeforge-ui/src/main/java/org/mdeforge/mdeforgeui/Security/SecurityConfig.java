package org.mdeforge.mdeforgeui.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig{

    @Configuration
    public static class LoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter{

        @Override
        protected void configure(HttpSecurity http) throws Exception{
            http
                    .httpBasic()
                    .and()
                    .authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                        .formLogin()
                    .and()
                        .oauth2Login();
        }
    }

}
