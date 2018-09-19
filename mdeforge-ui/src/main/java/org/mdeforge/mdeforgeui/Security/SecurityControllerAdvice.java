package org.mdeforge.mdeforgeui.Security;

import org.mdeforge.mdeforgeui.Model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;

@ControllerAdvice
public class SecurityControllerAdvice {

    @ModelAttribute("currentUser")
    public User customPrincipal(@CurrentUser Authentication auth) {

        if(auth == null) return null;

        if(auth.getPrincipal() instanceof UserDetails){
            return (User) auth.getPrincipal();
        }

        User user = new User();

        if(auth.getPrincipal() instanceof GoogleOAuth2User){

            GoogleOAuth2User googleOAuth2User = (GoogleOAuth2User) auth.getPrincipal();

            user.setEmail(googleOAuth2User.getEmail());
            user.setFirstname(googleOAuth2User.getGiven_name());
            user.setLastname(googleOAuth2User.getFamily_name());
            user.setImage(googleOAuth2User.getPicture());

        }

        if(auth.getPrincipal() instanceof GitHubOAuth2User){

            GitHubOAuth2User gitHubOAuth2User = (GitHubOAuth2User) auth.getPrincipal();

            user.setEmail(gitHubOAuth2User.getEmail());
            user.setFirstname(gitHubOAuth2User.getName());

        }

        if(auth.getPrincipal() instanceof FacebookOAuth2User){
            /*TODO*/

            return null;
        }

        return user;
    }

}

/*
    @ModelAttribute("currentUser")
    User currentUser(@CurrentUser User currentUser){

        return currentUser;
    }*/
