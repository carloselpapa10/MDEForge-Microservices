package org.mdeforge.mdeforgeui.Security;

import org.mdeforge.mdeforgeui.Model.User;
import org.mdeforge.mdeforgeui.Service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class RepositoryUserDetailsService implements UserDetailsService {

    private final UserService userService;

    public RepositoryUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = this.userService.findUserByEmail(email);

        if(user==null){
            throw new UsernameNotFoundException("Invalid username and password.");
        }

        if(user.getId() == null){
            throw new UsernameNotFoundException("Error trying to connect to the server.");
        }
        return new CustomUserDetails(user);
    }

    static class CustomUserDetails extends User implements UserDetails {

        private String usernam;

        public CustomUserDetails(User user) {
            super(user);
            this.usernam = user.getUsername();
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            String[] roles = new String[getRoles().size()];

            for(int index=0; index<getRoles().size(); index++){
                roles[index]=getRoles().get(index).getName();
            }

            getRoles().forEach(role -> {
                roles[0]= role.getName();
            });
            return AuthorityUtils.createAuthorityList(roles);
        }

        @Override
        public String getUsername() {
            return this.usernam;
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }
}
