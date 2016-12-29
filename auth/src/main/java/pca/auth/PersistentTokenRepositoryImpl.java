package pca.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import pca.persistence.dto.UserTokenDto;
import pca.service.authentication.AuthenticationService;

import java.util.Date;

public class PersistentTokenRepositoryImpl implements PersistentTokenRepository {

    @Autowired
    private AuthenticationService authenticationService;

    public void createNewToken(PersistentRememberMeToken persistentRememberMeToken) {
        UserTokenDto userTokenDto = new UserTokenDto();
        userTokenDto.setUserName(persistentRememberMeToken.getUsername());
        userTokenDto.setSeries(persistentRememberMeToken.getSeries());
        userTokenDto.setToken(persistentRememberMeToken.getTokenValue());
        userTokenDto.setDate(persistentRememberMeToken.getDate());
        authenticationService.saveUserToken(userTokenDto);

    }

    public void updateToken(String serise, String tokenValue, Date lastUsed) {
        UserTokenDto userTokenDto = authenticationService.getUserTokenBySeries(serise);
        authenticationService.updateUserToken(userTokenDto);
    }

    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
        UserTokenDto userTokenDto = authenticationService.getUserTokenBySeries(seriesId);
        return new PersistentRememberMeToken(userTokenDto.getUserName(),
                userTokenDto.getSeries(), userTokenDto.getToken(), userTokenDto.getDate());

    }

    public void removeUserTokens(String userName) {
        UserTokenDto userTokenDto = authenticationService.getUserTokenByUserName(userName);
        if (userName != null) {
            authenticationService.deletUserToken(userTokenDto);
        }
    }

    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
}
