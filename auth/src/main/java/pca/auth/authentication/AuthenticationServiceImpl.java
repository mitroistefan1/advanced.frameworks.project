package pca.auth.authentication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pca.auth.exception.AuthException;
import pca.converter.UserConverter;
import pca.persistence.repository.UserRepository;
import pca.auth.authentication.token_generator.TokenGenerator;
import pca.service.data.UserData;
import pca.auth.authentication.email_sender.EmailSender;


@Service
public class AuthenticationServiceImpl implements AuthenticationService {

  @Autowired
  private UserRepository userRepository;

  private EmailSender emailSender;
  private TokenGenerator tokenGenerator;
  private UserConverter userConverter;


  public UserData getUser(String userName) {

    return userConverter.convertToData(userRepository.findByUserName(userName));
  }

  public UserData getUserByToken(String userToken) {

    return userConverter.convertToData(userRepository.findByValidToken(userToken));
  }


  public void createUser(UserData userData) throws AuthException {

    String token;

    if (userRepository.findOne(userData.getUserName()) != null) {
      throw new AuthException("username: " + userData.getUserName() + " already exist");
    }

    token = tokenGenerator.generateToken(userData.getUserName());
    emailSender.sendEmail(userData.getEmail(), token);
    userData.setValidToken(token);
    userRepository.save(userConverter.convertToModel(userData));
  }

  public void updateUser(UserData userData) {

    userRepository.save(userConverter.convertToModel(userData));
  }

  public void setUserConverter(UserConverter userConverter) {

    this.userConverter = userConverter;
  }


  public void setEmailSender(EmailSender emailSender) {

    this.emailSender = emailSender;
  }

  public void setTokenGenerator(TokenGenerator tokenGenerator) {

    this.tokenGenerator = tokenGenerator;
  }
}
