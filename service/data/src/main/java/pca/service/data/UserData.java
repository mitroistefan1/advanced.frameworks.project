package pca.service.data;


import java.time.LocalDateTime;
import java.util.Date;

public class UserData {

  private String userName;
  private String email;
  private String password;
  private boolean isValid;
  private String validToken;
  private int role;

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getRole() {
    return role;
  }

  public void setRole(int role) {
    this.role = role;
  }

  public boolean isValid() {
    return isValid;
  }

  public void setValid(boolean valid) {
    isValid = valid;
  }

  public String getValidToken() {
    return validToken;
  }

  public void setValidToken(String validToken) {
    this.validToken = validToken;
  }


}
