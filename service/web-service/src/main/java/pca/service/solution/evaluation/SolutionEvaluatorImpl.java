package pca.service.solution.evaluation;


import pca.service.data.ProblemData;
import pca.service.data.SolutionData;
import pca.service.data.TestData;
import pca.service.exception.WebServiceException;
import pca.service.test.TestService;

import static pca.service.solution.evaluation.SolutionResult.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SolutionEvaluatorImpl implements SolutionEvaluator {

  private String path;
  private TestService testService;

  public int evaluate(String problemName, String userName, SolutionData solutionData) throws WebServiceException {

    File directory = new File(path + problemName);
    File inputFile = new File(directory.getAbsolutePath() + "\\" + problemName + ".in");
    File outputFile = new File(directory.getAbsolutePath() + "\\" + problemName + ".out");
    int score = 0;

    solutionData.setMessage(CORRECT.name());
    writeToFile(new File(directory + "\\" + problemName + userName + "main.cpp"), solutionData.getText());

    if (compile(problemName, userName,directory) != COMPILE_ERROR) {
      List<TestData> testList = testService.findAll(problemName);
      for (TestData test : testList) {
        writeToFile(inputFile, test.getInputData());
        if (execute(problemName, userName,directory,inputFile,outputFile) == RUN_SUCCESS) {
          if (match(outputFile, test.getOutputData()) == CORRECT) {
            score += 10;
          } else {
            solutionData.setMessage(WRONG.name());
          }
        } else {
          solutionData.setMessage(RUN_ERROR.name());
          return score;
        }
      }
    } else {
      solutionData.setMessage(COMPILE_ERROR.name());
      return score;
    }
    return score;
  }

  public List<String> validateOfficialSolution(ProblemData problem, List<String> testList) throws WebServiceException {

    String problemName = problem.getProblemName();
    List<String> testsResults = new ArrayList<>(10);
    File directory = new File(path + problemName);
    File inputFile = new File(directory.getAbsolutePath() + "\\" + problemName + ".in");
    File outputFile = new File(directory.getAbsolutePath() + "\\" + problemName + ".out");

    createInputAndOutputFileForProblem(problem.getProblemName(),directory,inputFile,outputFile);
    writeToFile(new File(directory + "\\" + "main.cpp"), problem.getOfficialSolution());

    if (compile("", "",directory) != COMPILE_ERROR) {
      for (String test : testList) {
        writeToFile(inputFile, test);
        if (execute("", "",directory,inputFile,outputFile) == RUN_SUCCESS) {
          testsResults.add(readFromFile(outputFile));
        } else {
          testsResults.add(RUN_ERROR.name());
        }
      }
    } else {
      testsResults.add(COMPILE_ERROR.name());
    }
    return testsResults;
  }

  public void setTestService(TestService testService) {
    this.testService = testService;
  }

  public void setPath(String path) {
    this.path = path;
  }

  private SolutionResult compile(String problemName, String userName, File directory) throws WebServiceException {

    ProcessBuilder p;
    boolean compiled = true;

    p = new ProcessBuilder("g++", "-std=c++0x", "-w", "-o", problemName + userName + "Main",
            problemName + userName + "main.cpp");
    p.directory(directory);
    p.redirectErrorStream(true);

    try {
      Process pp = p.start();
      InputStream is = pp.getInputStream();
      String temp;
      String compileErrorMessage = "";

      try (BufferedReader b = new BufferedReader(new InputStreamReader(is))) {
        while ((temp = b.readLine()) != null) {
          compiled = false;
          compileErrorMessage += temp;
        }
        pp.waitFor();
      }
      if (!compiled) {
        is.close();
        System.out.println(compileErrorMessage);
        return COMPILE_ERROR;
      }
      is.close();
      return COMPILE_SUCCESS;

    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
      throw new WebServiceException(e.getMessage());
    }
  }

  private SolutionResult execute(String problemName, String userName, File directory,
                                 File inputFile, File outputFile) throws WebServiceException {

    long timeInMillis = 100000;
    ProcessBuilder p;

    p = new ProcessBuilder(directory + "/" + "./" + problemName + userName + "Main");
    p.directory(directory);
    p.redirectInput(inputFile);
    p.redirectErrorStream(true);
    p.redirectOutput(outputFile);

    try {
      Process pp = p.start();
      if (!pp.waitFor(timeInMillis, TimeUnit.MILLISECONDS)) {
        return TLE;
      }
      int exitCode = pp.exitValue();
      if (exitCode != 0) {
        return RUN_ERROR;
      }
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
      throw new WebServiceException(e.getMessage());
    }
    return RUN_SUCCESS;
  }


  private SolutionResult match(File f1, String result) throws WebServiceException {

    try (BufferedReader b = new BufferedReader(new FileReader(f1))) {
      String s1 = "";
      String temp;

      while ((temp = b.readLine()) != null) {
        s1 += temp.trim();
      }
      if (s1.equals(result)) {
        return CORRECT;
      } else {
        return WRONG;
      }
    } catch (IOException e) {
      e.printStackTrace();
      throw new WebServiceException(e.getMessage());
    }
  }

  private String readFromFile(File file) throws WebServiceException {

    String content = "";

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      String temp;
      while ((temp = br.readLine()) != null) {
        content += temp.trim();
      }

    } catch (IOException e) {
      e.printStackTrace();
      throw new WebServiceException(e.getMessage());
    }

    return content;
  }

  private void writeToFile(File file, String content) throws WebServiceException {

    try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
      file.createNewFile();
      bw.write(content);
    } catch (IOException e) {
      e.printStackTrace();
      throw new WebServiceException(e.getMessage());
    }
  }

  private void createInputAndOutputFileForProblem(String problemName,File directory,File inputFile,File outputFile) throws WebServiceException {

    directory = new File(path + problemName);
    directory.mkdir();
    inputFile = new File(directory.getAbsolutePath() + "\\" + problemName + ".in");
    outputFile = new File(directory.getAbsolutePath() + "\\" + problemName + ".out");
    File main = new File(directory + "\\" + "main.cpp");

    try {
      inputFile.createNewFile();
      outputFile.createNewFile();
      main.createNewFile();
    } catch (IOException e) {
      e.printStackTrace();
      throw new WebServiceException(e.getMessage());
    }
  }

}