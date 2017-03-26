package pca.service.solution;


import pca.service.data.SolutionData;
import pca.service.exception.WebServiceException;

import java.util.List;

public interface SolutionService {

  SolutionData findSolution(int solutionId) throws WebServiceException;

  List<SolutionData> findAllSolutions(String problemName);

  void addSolution(SolutionData solutionData, String problemName, String userName) throws WebServiceException;

}
