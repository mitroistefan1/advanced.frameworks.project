package pca.auth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pca.service.data.UserData;
import pca.auth.authentication.AuthenticationServiceImpl;
import org.springframework.security.core.userdetails.User;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetailsServiceImpl implements UserDetailsService {

  private AuthenticationServiceImpl authenticationService;


  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

    UserDetails user;
    UserData userData;

    try {
      userData = authenticationService.getUser(userName);
      if (!userData.isValid()) {
        user = new User(
                userData.getUserName(),
                userData.getPassword(),
                false,
                true,
                true,
                true,
                getAuthorities(userData)
        );
      } else {
        user = new User(
                userData.getUserName(),
                userData.getPassword(),
                true,
                true,
                true,
                true,
                getAuthorities(userData)
        );
      }
    } catch (Exception e) {
      e.printStackTrace();
      throw new UsernameNotFoundException("Error in retrieving user");
    }
    return user;
  }

  public void setAuthenticationService(AuthenticationServiceImpl authenticationService) {
    this.authenticationService = authenticationService;
  }

  private Collection<GrantedAuthority> getAuthorities(UserData userData) {

    List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);

    if (userData.getRole() == 0) {
      authList.add(new SimpleGrantedAuthority("ROLE_USER"));
    } else {
      authList.add(new SimpleGrantedAuthority("ROLE_USER"));
      authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
    return authList;
  }
}