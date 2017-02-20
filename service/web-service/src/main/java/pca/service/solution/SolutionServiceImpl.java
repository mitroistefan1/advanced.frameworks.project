package pca.service.solution;


import org.springframework.beans.factory.annotation.Autowired;
import pca.converter.ProblemConverter;
import pca.converter.SolutionConverter;
import pca.persistence.dao.ProblemRepository;
import pca.persistence.dao.SolutionRepository;
import pca.persistence.dao.UserRepository;
import pca.persistence.model.Solution;
import pca.service.data.ProblemData;
import pca.service.data.SolutionData;
import pca.service.solution.evaluation.SolutionEvaluator;

import java.util.ArrayList;
import java.util.List;


public class SolutionServiceImpl implements SolutionService {
  @Autowired
  private SolutionRepository solutionRepository;
  @Autowired
  private ProblemRepository problemRepository;
  @Autowired
  private  UserRepository userRepository;

  private SolutionConverter solutionConverter;

  private ProblemConverter problemConverter;

  private SolutionEvaluator solutionEvaluator;


  public SolutionData findSolution(int solutionId){
    SolutionData solutionData = solutionConverter.convertToData(solutionRepository.findOne(solutionId));

    return solutionData;
  }
  public List<SolutionData> findAllSolutions(ProblemData problemData){
    List<Solution> list = solutionRepository.findByProblem(problemConverter.convertToModel(problemData));
    List<SolutionData> listData = new ArrayList<SolutionData>();
    for (Solution s : list) {
      listData.add(solutionConverter.convertToData(s));
    }
    return listData;

  }
  public void addSolution(SolutionData solutionData, String problemName, String userName){

    solutionData.setProblem(problemRepository.findOne(problemName));
    solutionData.setUser(userRepository.findByUserName(userName));
    solutionData.setScore(solutionEvaluator.evaluate(solutionData.getText()));
    solutionRepository.save(solutionConverter.convertToModel(solutionData));
  }

  public void setSolutionConverter(SolutionConverter solutionConverter) {
    this.solutionConverter = solutionConverter;
  }

  public void setProblemConverter(ProblemConverter problemConverter) {
    this.problemConverter = problemConverter;
  }

  public void setSolutionEvaluator(SolutionEvaluator solutionEvaluator) {
    this.solutionEvaluator = solutionEvaluator;
  }
}