package pca.auth.authentication.email_sender;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import pca.auth.exception.AuthException;

import javax.naming.AuthenticationException;

public class EmailSenderImpl implements EmailSender {

  private MailSender mailSender;

  public void sendEmail(String userEmail, String token) throws AuthException {

    SimpleMailMessage message = new SimpleMailMessage();

    message.setTo(userEmail);
    message.setSubject("PCA account validation");
    message.setText("For validation go to :http://localhost:8080/signup/validation/" + token);

    try {
      mailSender.send(message);
    } catch (Exception e) {
      throw new AuthException(e.getMessage());
    }
  }


  public void setMailSender(MailSender mailSender) {

    this.mailSender = mailSender;
  }
}
