package pca.service.solution;


import org.springframework.beans.factory.annotation.Autowired;
import pca.converter.SolutionConverter;
import pca.persistence.repository.ProblemRepository;
import pca.persistence.repository.SolutionRepository;
import pca.persistence.model.Solution;
import pca.service.data.SolutionData;
import pca.service.exception.WebServiceException;
import pca.service.solution.evaluation.SolutionEvaluator;

import java.util.ArrayList;
import java.util.List;


public class SolutionServiceImpl implements SolutionService {

  @Autowired
  private SolutionRepository solutionRepository;
  @Autowired
  private ProblemRepository problemRepository;
  private SolutionConverter solutionConverter;
  private SolutionEvaluator solutionEvaluator;


  public SolutionData findSolution(int solutionId) throws WebServiceException {

    Solution solution = solutionRepository.findOne(solutionId);

    if (solution == null) {
      throw new WebServiceException("solution with id: " + solutionId + "not found");
    }

    return solutionConverter.convertToData(solution);
  }

  public List<SolutionData> findAllSolutions(String problemName) {

    List<Solution> list = solutionRepository.findByProblem(problemRepository.findOne(problemName));
    List<SolutionData> listData = new ArrayList<>();

    for (Solution s : list) {
      listData.add(solutionConverter.convertToData(s));
    }

    return listData;
  }

  public void addSolution(SolutionData solutionData, String problemName, String userName) throws WebServiceException {

    solutionData.setScore(solutionEvaluator.evaluate(problemName, userName,
            solutionData));
    solutionRepository.save(solutionConverter.convertToModel(solutionData));
  }

  public void setSolutionConverter(SolutionConverter solutionConverter) {
    this.solutionConverter = solutionConverter;
  }

  public void setSolutionEvaluator(SolutionEvaluator solutionEvaluator) {
    this.solutionEvaluator = solutionEvaluator;
  }
}