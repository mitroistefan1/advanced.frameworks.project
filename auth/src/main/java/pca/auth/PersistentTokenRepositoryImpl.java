package pca.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import pca.service.data.UserTokenData;
import pca.service.authentication.AuthenticationServiceImpl;

import java.util.Date;

public class PersistentTokenRepositoryImpl implements PersistentTokenRepository {

    @Autowired
    private AuthenticationServiceImpl authenticationService;

    public void createNewToken(PersistentRememberMeToken persistentRememberMeToken) {
        UserTokenData userTokenData = new UserTokenData();
        userTokenData.setUserName(persistentRememberMeToken.getUsername());
        userTokenData.setSeries(persistentRememberMeToken.getSeries());
        userTokenData.setToken(persistentRememberMeToken.getTokenValue());
        userTokenData.setDate(persistentRememberMeToken.getDate());
        authenticationService.saveUserToken(userTokenData);

    }

    public void updateToken(String serise, String tokenValue, Date lastUsed) {
        UserTokenData userTokenData = authenticationService.getUserTokenBySeries(serise);
        authenticationService.updateUserToken(userTokenData);
    }

    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
        UserTokenData userTokenData = authenticationService.getUserTokenBySeries(seriesId);
        return new PersistentRememberMeToken(userTokenData.getUserName(),
                userTokenData.getSeries(), userTokenData.getToken(), userTokenData.getDate());

    }

    public void removeUserTokens(String userName) {
        UserTokenData userTokenData = authenticationService.getUserTokenByUserName(userName);
        if (userName != null) {
            authenticationService.deletUserToken(userTokenData);
        }
    }

    public void setAuthenticationService(AuthenticationServiceImpl authenticationService) {
        this.authenticationService = authenticationService;
    }
}
