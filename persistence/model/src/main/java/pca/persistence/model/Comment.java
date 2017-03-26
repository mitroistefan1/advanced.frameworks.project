package pca.persistence.model;

import javax.persistence.*;

@Entity
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  @ManyToOne
  @JoinColumn(name = "problemName")
  private Problem problem;
  private String body;
  @ManyToOne
  @JoinColumn(name = "userName")
  private User user;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Problem getProblem() {
    return problem;
  }

  public void setProblem(Problem problem) {
    this.problem = problem;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
