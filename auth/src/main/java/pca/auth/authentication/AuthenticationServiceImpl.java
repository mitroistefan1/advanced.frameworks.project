package pca.auth.authentication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pca.converter.UserConverter;
import pca.converter.UserTokenConverter;
import pca.persistence.dao.UserTokenRepository;
import pca.persistence.dao.UserRepository;
import pca.auth.authentication.token_generator.TokenGenerator;
import pca.service.data.UserTokenData;
import pca.service.data.UserData;
import pca.auth.authentication.email_sender.EmailSender;


@Service
public class AuthenticationServiceImpl implements AuthenticationService {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private UserTokenRepository userTokenRepository;
  @Autowired
  private EmailSender emailSender;
  @Autowired
  private TokenGenerator tokenGenerator;
  private UserConverter userConverter;
  private UserTokenConverter userTokenConverter;


  public UserData getUser(String userName) {

    return userConverter.convertToData(userRepository.findByUserName(userName));
  }

  public UserData getUserByToken(String userToken) {

    return userConverter.convertToData(userRepository.findByValidToken(userToken));
  }


  public void createUser(UserData userData) {

    String token;

    token = tokenGenerator.generateToken(userData.getUserName());
    emailSender.sendEmail(userData.getEmail(), token);
    userData.setValidToken(token);
    userRepository.save(userConverter.convertToModel(userData));
  }

  public void updateUser(UserData userData) {

    userRepository.save(userConverter.convertToModel(userData));
  }

  public void saveUserToken(UserTokenData userTokenData) {

    System.out.println("save user token----------------------------------------------------------------");
    userTokenRepository.save(userTokenConverter.convertToModel(userTokenData));
  }

  public UserTokenData getUserTokenBySeries(String series) {

    System.out.println("get user token----------------------------------------------------------------");
    return userTokenConverter.convertToData(userTokenRepository.findBySeries(series));
  }

  public void updateUserToken(UserTokenData userTokenData) {

    System.out.println("update user token----------------------------------------------------------------");
    userTokenRepository.save(userTokenConverter.convertToModel(userTokenData));
  }

  public UserTokenData getUserTokenByUserName(String userName) {

    return userTokenConverter.convertToData(userTokenRepository.findByUserName(userName));
  }

  public void deleteUserToken(UserTokenData userTokenData) {

    System.out.println("remove user token----------------------------------------------------------------");
    userTokenRepository.delete(userTokenConverter.convertToModel(userTokenData));
  }

  public void setUserConverter(UserConverter userConverter) {

    this.userConverter = userConverter;
  }

  public void setUserTokenConverter(UserTokenConverter userTokenConverter) {

    this.userTokenConverter = userTokenConverter;
  }

  public void setEmailSender(EmailSender emailSender) {

    this.emailSender = emailSender;
  }

  public void setTokenGenerator(TokenGenerator tokenGenerator) {

    this.tokenGenerator = tokenGenerator;
  }
}
