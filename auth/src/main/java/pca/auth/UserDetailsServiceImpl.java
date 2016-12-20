package pca.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pca.persistence.dto.UserDto;
import pca.service.authentication.AuthenticationService;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AuthenticationService authenticationService;


    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserDetails user = null;
        UserDto userDto = null;
        try {
            userDto = authenticationService.getUser(userName);
            user = new User(
                    userDto.getUserName(),
                    userDto.getPassword(),
                    true,
                    true,
                    true,
                    true,
                    getAuthorities()
            );


        } catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException("Error in retrieving user");
        }
        return user;
    }

    public Collection<GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);

        authList.add(new SimpleGrantedAuthority("ROLE_USER"));

        return authList;
    }
}