package pca.persistence.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Problem {

  @Id
  private String problemName;
  private String problemStatement;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "problem")
  private List<Comment> commentList;

  public String getProblemName() {
    return problemName;
  }

  public void setProblemName(String problemName) {
    this.problemName = problemName;
  }

  public String getProblemStatement() {
    return problemStatement;
  }

  public void setProblemStatement(String problemStatement) {
    this.problemStatement = problemStatement;
  }

  public List<Comment> getCommentList() {
    return commentList;
  }

  public void setCommentList(List<Comment> commentList) {
    this.commentList = commentList;
  }
}
