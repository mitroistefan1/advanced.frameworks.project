package pca.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import pca.persistence.dto.PersistentUserDto;
import pca.service.authentication.AuthenticationService;

import java.util.Date;

public class PersistentTokenRepositoryImpl implements PersistentTokenRepository {

    @Autowired
    private AuthenticationService authenticationService;

    public void createNewToken(PersistentRememberMeToken persistentRememberMeToken) {
        PersistentUserDto user = new PersistentUserDto();
        user.setUserName(persistentRememberMeToken.getUsername());
        user.setSeries(persistentRememberMeToken.getSeries());
        user.setToken(persistentRememberMeToken.getTokenValue());
        user.setDate(persistentRememberMeToken.getDate());
        authenticationService.savePersistentUser(user);

    }

    public void updateToken(String serise, String tokenValue, Date lastUsed) {
        PersistentUserDto persistentUserDto = authenticationService.getPersistentUserBySerises(serise);
        authenticationService.updatePersistentUser(persistentUserDto);
    }

    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
        PersistentUserDto persistentUserDto = authenticationService.getPersistentUserBySerises(seriesId);
        PersistentRememberMeToken token = new PersistentRememberMeToken(persistentUserDto.getUserName(),
                persistentUserDto.getSeries(), persistentUserDto.getToken(), persistentUserDto.getDate());

        return token;
    }

    public void removeUserTokens(String userName) {
        PersistentUserDto persistentUserDto = authenticationService.getPersistentUserByUserName(userName);
        if(userName!=null) {
            authenticationService.deletPersistentUser(persistentUserDto);
        }else{
            System.out.println("!rememberme");
        }
    }

    public AuthenticationService getAuthenticationService() {
        return authenticationService;
    }

    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
}
