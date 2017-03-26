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
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "problem")
  private List<Solution> solutionList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "problem")
  private List<Test> testList;
  private String officialSolution;

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

  public List<Solution> getSolutionList() {
    return solutionList;
  }

  public void setSolutionList(List<Solution> solutionList) {
    this.solutionList = solutionList;
  }

  public List<Test> getTestList() {
    return testList;
  }

  public void setTestList(List<Test> testList) {
    this.testList = testList;
  }

  public String getOfficialSolution() {
    return officialSolution;
  }

  public void setOfficialSolution(String officialSolution) {
    this.officialSolution = officialSolution;
  }
}
