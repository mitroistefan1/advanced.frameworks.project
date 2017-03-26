package pca.persistence.model;

import javax.persistence.*;

@Entity
public class Test {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  @ManyToOne
  @JoinColumn(name = "problemName")
  private Problem problem;
  private String inputData;
  private String outputData;

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

  public String getInputData() {
    return inputData;
  }

  public void setInputData(String inputData) {
    this.inputData = inputData;
  }

  public String getOutputData() {
    return outputData;
  }

  public void setOutputData(String outputData) {
    this.outputData = outputData;
  }
}
