package org.mdeforge.mdeforgeui.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig{

    @Configuration
    public static class LoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter{

        @Override
        protected void configure(HttpSecurity http) throws Exception{
            http
                    .authorizeRequests()
                        .antMatchers("/resources/**", "/login", "/signup","/webjars/**").permitAll()
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
                            .loginPage("/login");
        }

        @Bean
        PasswordEncoder passwordEncoder(){
            return PasswordEncoderFactories.createDelegatingPasswordEncoder();
        }
    }

}
