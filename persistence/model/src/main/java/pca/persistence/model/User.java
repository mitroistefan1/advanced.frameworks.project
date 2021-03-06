package pca.persistence.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Entity
public class User {

  @Id
  private String userName;
  private String email;
  private String password;
  private boolean isValid = false;
  private String validToken;
  private int role;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
  private List<Solution> solutionList;

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

  public List<Solution> getSolutionList() {
    return solutionList;
  }

  public void setSolutionList(List<Solution> solutionList) {
    this.solutionList = solutionList;
  }
}
