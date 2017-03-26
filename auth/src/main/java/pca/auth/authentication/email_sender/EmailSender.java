package pca.auth.authentication.email_sender;


import pca.auth.exception.AuthException;

public interface EmailSender {

  void sendEmail(String userEmail, String token) throws AuthException;
}
