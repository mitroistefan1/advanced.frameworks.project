package pca.auth.authentication.email_sender;


import pca.auth.exception.AuthException;
import pca.service.data.UserData;

public interface EmailSender {

  void sendEmail(String userEmail, String token) throws AuthException;
}
