package pca.service.data;


import pca.persistence.model.Problem;

public class CommentData {

  private int id;
  private Problem problem;
  private String body;
  private String author;

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

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }
}
