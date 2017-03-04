package pca.converter;


import pca.persistence.model.Test;
import pca.service.data.TestData;

public class TestConverter implements Converter<Test,TestData> {

  public TestData convertToData(Test model) {

    TestData testData = new TestData();

    testData.setId(model.getId());
    testData.setProblem(model.getProblem());
    testData.setInputData(model.getInputData());
    testData.setOutputData(model.getOutputData());

    return testData;
  }

  public Test convertToModel(TestData data) {

    Test test = new Test();

    test.setId(data.getId());
    test.setProblem(data.getProblem());
    test.setInputData(data.getInputData());
    test.setOutputData(data.getOutputData());

    return test;
  }
}
