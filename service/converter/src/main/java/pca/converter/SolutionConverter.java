package pca.converter;


import pca.persistence.model.Solution;
import pca.service.data.SolutionData;

public class SolutionConverter implements Converter<Solution,SolutionData> {

  public SolutionData convertToData(Solution model) {

    SolutionData solutionData = new SolutionData();

    solutionData.setId(model.getId());
    solutionData.setProblem(model.getProblem());
    solutionData.setUser(model.getUser());
    solutionData.setText(model.getText());
    solutionData.setScore(model.getScore());
    solutionData.setMessage(model.getMessage());

    return solutionData;
  }

  public Solution convertToModel(SolutionData data) {
    Solution solution = new Solution();

    solution.setId(data.getId());
    solution.setProblem(data.getProblem());
    solution.setUser(data.getUser());
    solution.setText(data.getText());
    solution.setScore(data.getScore());
    solution.setMessage(data.getMessage());

    return solution;
  }
}
