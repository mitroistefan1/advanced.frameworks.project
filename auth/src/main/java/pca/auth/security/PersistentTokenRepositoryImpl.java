package pca.auth.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import pca.service.data.UserTokenData;
import pca.auth.authentication.AuthenticationServiceImpl;

import java.util.Date;

public class PersistentTokenRepositoryImpl implements PersistentTokenRepository {

  @Autowired
  private AuthenticationServiceImpl authenticationService;

  public void createNewToken(PersistentRememberMeToken persistentRememberMeToken) {

    System.out.println("new token----------------------------------------------------------------");
    UserTokenData userTokenData = new UserTokenData();
    userTokenData.setUserName(persistentRememberMeToken.getUsername());
    userTokenData.setSeries(persistentRememberMeToken.getSeries());
    userTokenData.setToken(persistentRememberMeToken.getTokenValue());
    userTokenData.setDate(persistentRememberMeToken.getDate());
    authenticationService.saveUserToken(userTokenData);

  }

  public void updateToken(String serise, String tokenValue, Date lastUsed) {

    System.out.println("update token----------------------------------------------------------------");
    UserTokenData userTokenData = authenticationService.getUserTokenBySeries(serise);
    authenticationService.updateUserToken(userTokenData);
  }

  public PersistentRememberMeToken getTokenForSeries(String seriesId) {

    System.out.println("get token----------------------------------------------------------------");
    UserTokenData userTokenData = authenticationService.getUserTokenBySeries(seriesId);
    return new PersistentRememberMeToken(userTokenData.getUserName(),
            userTokenData.getSeries(), userTokenData.getToken(), userTokenData.getDate());

  }

  public void removeUserTokens(String userName) {

    System.out.println("remove token----------------------------------------------------------------");
    UserTokenData userTokenData = authenticationService.getUserTokenByUserName(userName);
    if (userName != null) {
      authenticationService.deleteUserToken(userTokenData);
    }
  }

  public void setAuthenticationService(AuthenticationServiceImpl authenticationService) {
    this.authenticationService = authenticationService;
  }
}
