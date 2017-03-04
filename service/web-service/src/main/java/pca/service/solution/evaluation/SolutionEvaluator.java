package pca.service.solution.evaluation;


import pca.service.data.ProblemData;
import pca.service.data.SolutionData;

public interface SolutionEvaluator {

  public int evaluate(ProblemData problemData, SolutionData solutionData);
  public void creatInputAndOutputFileForProblem(String problemName);
}
