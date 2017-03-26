package pca.auth.authentication.email_sender;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import pca.auth.exception.AuthException;


public class EmailSenderImpl implements EmailSender {

  private String mailSubject;
  private String mailText;
  private MailSender mailSender;

  public void sendEmail(String userEmail, String token) throws AuthException {

    SimpleMailMessage message = new SimpleMailMessage();

    message.setTo(userEmail);
    message.setSubject(mailSubject);
    message.setText(mailText + token);
    try {
      mailSender.send(message);
    } catch (Exception e) {
      throw new AuthException(e.getMessage());
    }
  }

  public void setMailSender(MailSender mailSender) {
    this.mailSender = mailSender;
  }

  public void setMailSubject(String mailSubject) {
    this.mailSubject = mailSubject;
  }

  public void setMailText(String mailText) {
    this.mailText = mailText;
  }
}
