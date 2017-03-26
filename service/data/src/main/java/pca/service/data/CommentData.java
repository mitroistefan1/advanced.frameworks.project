package pca.service.data;


public class CommentData {

  private int id;
  private String problemName;
  private String body;
  private String userName;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getProblemName() {
    return problemName;
  }

  public void setProblemName(String problemName) {
    this.problemName = problemName;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }
}
