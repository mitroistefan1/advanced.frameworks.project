package pca.service.solution;


import pca.service.data.ProblemData;
import pca.service.data.SolutionData;

import java.util.List;

public interface SolutionService {

  public SolutionData findSolution(int solutionId);
  public List<SolutionData> findAllSolutions(ProblemData problemData);
  public void addSolution(SolutionData solutionData, String problemName, String userName);

}
