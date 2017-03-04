package pca.service.test;


import org.springframework.beans.factory.annotation.Autowired;
import pca.converter.ProblemConverter;
import pca.converter.TestConverter;
import pca.persistence.model.Test;
import pca.persistence.repository.ProblemRepository;
import pca.persistence.repository.TestRepository;
import pca.service.data.ProblemData;
import pca.service.data.TestData;

import java.util.ArrayList;
import java.util.List;

public class TestServiceImpl implements TestService {

  @Autowired
  private TestRepository testRepository;
  @Autowired
  private ProblemRepository problemRepository;

  private TestConverter testConverter;

  private ProblemConverter problemConverter;


  public void addTest(String problemName, TestData testData) {
    testData.setProblem(problemRepository.findOne(problemName));
    testRepository.save(testConverter.convertToModel(testData));
  }

  public List<TestData> findAll(ProblemData problemData) {

    List<Test> list = testRepository.findByProblem(problemConverter.convertToModel(problemData));
    List<TestData> listData = new ArrayList<>();
    for (Test t : list) {
      listData.add(testConverter.convertToData(t));
    }

    return listData;
  }

  public void setTestConverter(TestConverter testConverter) {
    this.testConverter = testConverter;
  }

  public void setProblemConverter(ProblemConverter problemConverter) {
    this.problemConverter = problemConverter;
  }
}
