package pca.service.problem;

import pca.service.data.ProblemData;
import pca.service.exception.WebServiceException;

import java.util.List;

public interface ProblemService {


  List<ProblemData> findAllProblems();

  ProblemData findProblem(String problemName) throws WebServiceException;

  void addProblem(ProblemData problemData);

  void removeProblem(String problemName);

  void updateProblem(ProblemData problemData);

  //void creatInputAndOutputFileForProblem(String problemName);
}
