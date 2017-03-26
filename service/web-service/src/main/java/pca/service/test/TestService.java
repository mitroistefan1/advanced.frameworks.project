package pca.service.test;


import pca.service.data.TestData;

import java.util.List;

public interface TestService {

  void addTest(TestData testData);

  List<TestData> findAll(String problemName);
}
