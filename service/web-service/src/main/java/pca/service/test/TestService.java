package pca.service.test;


import pca.persistence.model.Test;
import pca.service.data.ProblemData;
import pca.service.data.TestData;

import java.util.List;

public interface TestService {

  void addTest(String problemName, TestData testData);
  List<TestData> findAll(ProblemData problemData);
}
