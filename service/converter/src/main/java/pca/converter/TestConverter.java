package pca.converter;


import org.springframework.beans.factory.annotation.Autowired;
import pca.persistence.model.Test;
import pca.persistence.repository.ProblemRepository;
import pca.service.data.TestData;

public class TestConverter implements Converter<Test,TestData> {

  @Autowired
  private ProblemRepository problemRepository;

  public TestData convertToData(Test model) {

    TestData testData = new TestData();

    testData.setId(model.getId());
    testData.setProblemName(model.getProblem().getProblemName());
    testData.setInputData(model.getInputData());
    testData.setOutputData(model.getOutputData());

    return testData;
  }

  public Test convertToModel(TestData data) {

    Test test = new Test();

    test.setId(data.getId());
    test.setProblem(problemRepository.findOne(data.getProblemName()));
    test.setInputData(data.getInputData());
    test.setOutputData(data.getOutputData());

    return test;
  }
}
