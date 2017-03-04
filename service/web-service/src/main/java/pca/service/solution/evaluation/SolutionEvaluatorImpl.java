package pca.service.solution.evaluation;


import pca.service.data.ProblemData;
import pca.service.data.SolutionData;
import pca.service.data.TestData;
import pca.service.test.TestService;

import static pca.service.solution.evaluation.TestResult.*;

import java.io.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SolutionEvaluatorImpl implements SolutionEvaluator {

  private TestService testService;
  private static String path = "C:\\Users\\Stefan\\Desktop\\pcatestfiles\\";
  private File inputFile;
  private File outputFile;
  private File directory;

  public int evaluate(ProblemData problemData, SolutionData solutionData) {
    int score = 0;
    String problemName=problemData.getProblemName();
    solutionData.setMessage(CORRECT.name());
    creatInputAndOutputFileForProblem(problemName);

    writeToFile(new File(directory + "\\" + "main.cpp"), solutionData.getText());
    if (compile() != COMPILE_ERROR) {
      List<TestData> list = testService.findAll(problemData);
      for (TestData t : list) {
        writeToFile(inputFile, t.getInputData());
        if (execute() == RUN_SUCCESS) {
          if (match(outputFile, t.getOutputData()) == CORRECT) {
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

  public void creatInputAndOutputFileForProblem(String problemName) {
    directory = new File(path + problemName);

    directory.mkdir();
    inputFile = new File(directory.getAbsolutePath() + "\\" + problemName + ".in");
    outputFile = new File(directory.getAbsolutePath() + "\\" + problemName + ".out");
    File main = new File(directory+ "\\" + "main.cpp");
    try {
      inputFile.createNewFile();
      outputFile.createNewFile();
      main.createNewFile();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void setTestService(TestService testService) {
    this.testService = testService;
  }


  private TestResult compile() {

    ProcessBuilder p;
    boolean compiled = true;
    p = new ProcessBuilder("g++", "-std=c++0x", "-w", "-o", "Main", "main.cpp");
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
        return COMPILE_ERROR;
      }
      is.close();
      return COMPILE_SUCCESS;

    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
    return COMPILE_ERROR;
  }

  private TestResult execute() {
    long timeInMillis = 100000;
    ProcessBuilder p;
    p = new ProcessBuilder(directory + "/" + "./Main");
    p.directory(directory);
    //File in = new File(path + problemName + "/" + problemName + ".in");
    p.redirectInput(inputFile);
    p.redirectErrorStream(true);
    // File out = new File(path + problemName + "/" + problemName + ".out");
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
    } catch (IOException | InterruptedException ioe) {
      ioe.printStackTrace();
    }
    return RUN_SUCCESS;
  }


  private TestResult match(File f1, String result) {

    BufferedReader b1 = null;

    try {
      b1 = new BufferedReader(new FileReader(f1));
      String s1 = "";
      String temp;

      while ((temp = b1.readLine()) != null) {
        s1 += temp.trim();
      }
      if (s1.equals(result)) {
        return CORRECT;
      } else {
        return WRONG;
      }
    } catch (IOException ex) {
      System.err.println("in match() " + ex);
    } finally {
      try {
        if (b1 != null) {
          b1.close();
        }
      } catch (IOException ex) {
        System.err.println("in match() " + ex);
      }
    }
    return WRONG;
  }

  private void writeToFile(File file, String content) {
    FileWriter fw = null;
    BufferedWriter bw = null;
    try {
      file.createNewFile();
      fw = new FileWriter(file);
      bw = new BufferedWriter(fw);
      bw.write(content);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {

      try {
        if (bw != null)
          bw.close();
        if (fw != null)
          fw.close();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
  }
}
