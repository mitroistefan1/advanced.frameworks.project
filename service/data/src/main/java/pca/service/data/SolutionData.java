package pca.service.data;


public class SolutionData {

  private int id;
  private String userName;
  private String problemName;
  private String text;
  private int score;
  private String message;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getProblemName() {
    return problemName;
  }

  public void setProblemName(String problemName) {
    this.problemName = problemName;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
