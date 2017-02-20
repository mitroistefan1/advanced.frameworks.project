package pca.auth.authentication.email_sender;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class EmailSenderImpl implements EmailSender {

  private MailSender mailSender;

  public void sendEmail(String userEmail, String token) {

    SimpleMailMessage message = new SimpleMailMessage();

    message.setTo(userEmail);
    message.setSubject("PCA account evaluation");
    message.setText("For evaluation go to :http://localhost:8080/signup/evaluation/" + token);
    mailSender.send(message);
  }


  public void setMailSender(MailSender mailSender) {

    this.mailSender = mailSender;
  }
}
