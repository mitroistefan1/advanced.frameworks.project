package pca.service.data;


public class ProblemData {

  private String problemName;
  private String problemStatement;
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

  public String getOfficialSolution() {
    return officialSolution;
  }

  public void setOfficialSolution(String officialSolution) {
    this.officialSolution = officialSolution;
  }
}
