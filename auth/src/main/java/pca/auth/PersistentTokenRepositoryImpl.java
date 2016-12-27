package pca.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import pca.persistence.dto.TokenUserDto;
import pca.service.authentication.AuthenticationService;

import java.util.Date;

public class PersistentTokenRepositoryImpl implements PersistentTokenRepository {

    @Autowired
    private AuthenticationService authenticationService;

    public void createNewToken(PersistentRememberMeToken persistentRememberMeToken) {
        TokenUserDto tokenUserDto = new TokenUserDto();
        tokenUserDto.setUserName(persistentRememberMeToken.getUsername());
        tokenUserDto.setSeries(persistentRememberMeToken.getSeries());
        tokenUserDto.setToken(persistentRememberMeToken.getTokenValue());
        tokenUserDto.setDate(persistentRememberMeToken.getDate());
        authenticationService.savePersistentUser(tokenUserDto);

    }

    public void updateToken(String serise, String tokenValue, Date lastUsed) {
        TokenUserDto tokenUserDto = authenticationService.getPersistentUserBySeries(serise);
        authenticationService.updatePersistentUser(tokenUserDto);
    }

    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
        TokenUserDto tokenUserDto = authenticationService.getPersistentUserBySeries(seriesId);
        return new PersistentRememberMeToken(tokenUserDto.getUserName(),
                tokenUserDto.getSeries(), tokenUserDto.getToken(), tokenUserDto.getDate());

    }

    public void removeUserTokens(String userName) {
        TokenUserDto tokenUserDto = authenticationService.getPersistentUserByUserName(userName);
        if(userName!=null) {
            authenticationService.deletPersistentUser(tokenUserDto);
        }
    }

    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
}
