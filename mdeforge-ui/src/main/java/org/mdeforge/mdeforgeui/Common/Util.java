package org.mdeforge.mdeforgeui.Common;

import org.mdeforge.mdeforgeui.Security.FacebookOAuth2User;
import org.mdeforge.mdeforgeui.Security.GitHubOAuth2User;
import org.mdeforge.mdeforgeui.Security.GoogleOAuth2User;
import org.springframework.security.core.context.SecurityContextHolder;

public class Util {

    public static String getEmailFromOAuth(){

        if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof GoogleOAuth2User){
            GoogleOAuth2User googleOAuth2User = (GoogleOAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return googleOAuth2User.getEmail();
        }

        if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof GitHubOAuth2User){
            GitHubOAuth2User gitHubOAuth2User = (GitHubOAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            gitHubOAuth2User.getEmail();
        }

        if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof FacebookOAuth2User){
            FacebookOAuth2User facebookOAuth2User = (FacebookOAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            //return facebookOAuth2User.getEmail();
            return "";
        }

        return null;
    }
}
