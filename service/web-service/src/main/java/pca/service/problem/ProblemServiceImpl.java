package pca.service.problem;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pca.converter.ProblemConverter;

import pca.persistence.repository.ProblemRepository;
import pca.service.data.ProblemData;
import pca.persistence.model.Problem;
import pca.service.exception.WebServiceException;
import pca.service.solution.evaluation.SolutionEvaluator;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProblemServiceImpl implements ProblemService {

  @Autowired
  private ProblemRepository problemRepository;

  private ProblemConverter problemConverter;



  public List<ProblemData> findAllProblems() {
    Iterable<Problem> problemList = problemRepository.findAll();

    List<ProblemData> problemDataList = new ArrayList<>();
    for (Problem p : problemList) {
      problemDataList.add(problemConverter.convertToData(p));
    }
    return problemDataList;
  }

  public ProblemData findProblem(String problemName) throws WebServiceException {
    Problem problem = problemRepository.findOne(problemName);
    if(problem==null){
      throw new WebServiceException("problem "+problemName+" not found");
    }
    return problemConverter.convertToData(problem);
  }

  public void addProblem(ProblemData problemData) {
    problemRepository.save(problemConverter.convertToModel(problemData));
  }

  public void removeProblem(String problemName) {
    problemRepository.delete(problemName);
  }

  public void updateProblem(ProblemData problemData) {

  }

  public void setProblemConverter(ProblemConverter problemConverter) {
    this.problemConverter = problemConverter;
  }

}
