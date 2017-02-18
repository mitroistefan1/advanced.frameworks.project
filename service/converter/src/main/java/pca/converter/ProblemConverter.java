package pca.converter;


import pca.persistence.model.Problem;
import pca.service.data.ProblemData;

public class ProblemConverter implements Converter<Problem, ProblemData> {

  public ProblemData convertToData(Problem model) {

    ProblemData problemData = new ProblemData();

    problemData.setProblemName(model.getProblemName());
    problemData.setProblemStatement(model.getProblemStatement());

    return problemData;
  }

  public Problem convertToModel(ProblemData data) {

    Problem problem = new Problem();

    problem.setProblemName(data.getProblemName());
    problem.setProblemStatement(data.getProblemStatement());
    return problem;
  }
}
