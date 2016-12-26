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

        UserDetails user;
        UserDto userDto;
        try {
            userDto = authenticationService.getUser(userName);
            user = new User(
                    userDto.getUserName(),
                    userDto.getPassword(),
                    true,
                    true,
                    true,
                    true,
                    getAuthorities(userDto)
            );


        } catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException("Error in retrieving user");
        }
        return user;
    }

    private Collection<GrantedAuthority> getAuthorities(UserDto userDto) {

        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);
        if(userDto.getRole()==0) {
            authList.add(new SimpleGrantedAuthority("ROLE_USER"));
        }else{
            authList.add(new SimpleGrantedAuthority("ROLE_USER"));
            authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }

        return authList;
    }
}