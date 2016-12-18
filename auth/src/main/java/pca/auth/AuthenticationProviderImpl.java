package pca.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import pca.persistence.dto.UserDto;
import pca.service.authentication.AuthenticationService;

import java.util.ArrayList;
import java.util.List;

public class AuthenticationProviderImpl implements AuthenticationProvider{

    @Autowired
    private AuthenticationService authenticationService;


    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UserDto userDto = new UserDto();
        userDto.setUserName(authentication.getName());
        userDto.setPassword(authentication.getCredentials().toString());
        if (authenticationService.isUserValid(userDto)) {
            List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
            grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
            Authentication auth = new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials().toString(), grantedAuths);
            return auth;
        } else {
            return null;
        }
    }

    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}