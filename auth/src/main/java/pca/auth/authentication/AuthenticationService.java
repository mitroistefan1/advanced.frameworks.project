package pca.auth.authentication;

import pca.auth.exception.AuthException;
import pca.service.data.UserData;

public interface AuthenticationService {

  UserData getUser(String userName);

  void createUser(UserData userData) throws AuthException;

  void updateUser(UserData userData);

  UserData getUserByToken(String userToken);


}
