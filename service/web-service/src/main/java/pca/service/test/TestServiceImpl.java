package pca.service.test;


import org.springframework.beans.factory.annotation.Autowired;
import pca.converter.TestConverter;
import pca.persistence.model.Test;
import pca.persistence.repository.ProblemRepository;
import pca.persistence.repository.TestRepository;
import pca.service.data.TestData;

import java.util.ArrayList;
import java.util.List;

public class TestServiceImpl implements TestService {

  @Autowired
  private TestRepository testRepository;
  @Autowired
  private ProblemRepository problemRepository;
  private TestConverter testConverter;


  public void addTest(TestData testData) {

    testRepository.save(testConverter.convertToModel(testData));
  }

  public List<TestData> findAll(String problemName) {

    List<Test> list = testRepository.findByProblem(problemRepository.findOne(problemName));
    List<TestData> listData = new ArrayList<>();

    for (Test t : list) {
      listData.add(testConverter.convertToData(t));
    }

    return listData;
  }

  public void setTestConverter(TestConverter testConverter) {
    this.testConverter = testConverter;
  }
}
