package pca.converter;


import org.springframework.beans.factory.annotation.Autowired;
import pca.persistence.model.Solution;
import pca.persistence.repository.ProblemRepository;
import pca.persistence.repository.UserRepository;
import pca.service.data.SolutionData;

public class SolutionConverter implements Converter<Solution,SolutionData> {

  @Autowired
  private ProblemRepository problemRepository;
  @Autowired
  private UserRepository userRepository;

  public SolutionData convertToData(Solution model) {

    SolutionData solutionData = new SolutionData();

    solutionData.setId(model.getId());
    solutionData.setProblemName(model.getProblem().getProblemName());
    solutionData.setUserName(model.getUser().getUserName());
    solutionData.setText(model.getText());
    solutionData.setScore(model.getScore());
    solutionData.setMessage(model.getMessage());

    return solutionData;
  }

  public Solution convertToModel(SolutionData data) {
    Solution solution = new Solution();

    solution.setId(data.getId());
    solution.setProblem(problemRepository.findOne(data.getProblemName()));
    solution.setUser(userRepository.findOne(data.getUserName()));
    solution.setText(data.getText());
    solution.setScore(data.getScore());
    solution.setMessage(data.getMessage());

    return solution;
  }
}
