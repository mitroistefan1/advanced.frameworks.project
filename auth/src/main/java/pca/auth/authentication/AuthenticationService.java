package pca.auth.authentication;

import pca.auth.exception.AuthException;
import pca.service.data.UserData;
import pca.service.data.UserTokenData;


public interface AuthenticationService {

  UserData getUser(String userName);

  void createUser(UserData userData) throws AuthException;

  void updateUser(UserData userData);

  UserData getUserByToken(String userToken);

  void saveUserToken(UserTokenData userTokenData);

  UserTokenData getUserTokenBySeries(String series);

  void updateUserToken(UserTokenData userTokenData);

  UserTokenData getUserTokenByUserName(String userName);

  void deleteUserToken(UserTokenData userTokenData);

}
