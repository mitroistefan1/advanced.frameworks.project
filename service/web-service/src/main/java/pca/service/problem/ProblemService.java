package pca.service.problem;

import pca.service.data.ProblemData;

import java.util.List;

public interface ProblemService {


    public List<ProblemData> findAllProblems();
    public ProblemData findProblem(String problemName);
    public void addProblem(ProblemData problemData);
    public void removeProblem(String problemName);
    public void updateProblem(ProblemData problemData);

}
