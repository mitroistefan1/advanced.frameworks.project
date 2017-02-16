package pca.service.problem;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pca.converter.ProblemConverter;
import pca.persistence.dao.CommentRepository;
import pca.persistence.dao.ProblemRepository;
import pca.service.data.ProblemData;
import pca.persistence.model.Comment;
import pca.persistence.model.Problem;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProblemServiceImpl implements ProblemService {

    @Autowired
    private ProblemRepository problemRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ProblemConverter problemConverter;

    public List<ProblemData> findAllProblems() {
        List<Problem> problemList = problemRepository.findAll();
        List<ProblemData> problemDataList = new ArrayList<ProblemData>();
        for (Problem p : problemList) {
            problemDataList.add(problemConverter.convertToData(p));
        }
        return problemDataList;
    }

    public ProblemData findProblem(String problemName) {

        return problemConverter.convertToData(problemRepository.findOne(problemName));
    }

    public void addProblem(ProblemData problemData) {
        problemRepository.save(problemConverter.convertToModel(problemData));
    }

    public void removeProblem(String problemName) {
        List<Comment> commentList = commentRepository.findByProblem(problemRepository.findOne(problemName));
        for (Comment c: commentList) {
            commentRepository.delete(c);
        }
        problemRepository.delete(problemName);
    }

    public void updateProblem(ProblemData problemData) {

    }

    public void setProblemConverter(ProblemConverter problemConverter) {
        this.problemConverter = problemConverter;
    }

}