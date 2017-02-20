package pca.service.solution.evaluation;


import java.util.Random;

public class SolutionEvaluatorImpl implements SolutionEvaluator {

  public int evaluate(String problemText) {
    return new Random().nextInt(100);
  }
}
