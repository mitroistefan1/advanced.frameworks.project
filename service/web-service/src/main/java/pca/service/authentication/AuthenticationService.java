package pca.service.authentication;

import pca.service.data.UserData;
import pca.service.data.UserTokenData;


public interface AuthenticationService {
    public UserData getUser(String userName);

    public void creatUser(UserData userData);


    public void saveUserToken(UserTokenData userTokenData);

    public UserTokenData getUserTokenBySeries(String series);

    public void updateUserToken(UserTokenData userTokenData);

    public UserTokenData getUserTokenByUserName(String userName);

    public void deletUserToken(UserTokenData userTokenData);

}
