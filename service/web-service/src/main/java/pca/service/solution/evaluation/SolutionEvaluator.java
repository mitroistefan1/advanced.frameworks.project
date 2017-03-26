package pca.service.solution.evaluation;


import pca.service.data.ProblemData;
import pca.service.data.SolutionData;
import pca.service.exception.WebServiceException;

import java.util.List;

public interface SolutionEvaluator {

  int evaluate(String problemName, String userName, SolutionData solutionData) throws WebServiceException;

  List<String> validateOfficialSolution(ProblemData problem, List<String> testList) throws WebServiceException;

}
