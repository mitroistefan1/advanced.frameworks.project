package pca.service.problem;

import pca.service.data.ProblemData;

import java.util.List;

public interface ProblemService {


  List<ProblemData> findAllProblems();

  ProblemData findProblem(String problemName);

  void addProblem(ProblemData problemData);

  void removeProblem(String problemName);

  void updateProblem(ProblemData problemData);

  //void creatInputAndOutputFileForProblem(String problemName);
}
