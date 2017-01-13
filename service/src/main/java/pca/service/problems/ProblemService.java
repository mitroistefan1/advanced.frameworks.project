package pca.service.problems;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pca.persistence.dao.CommentDao;
import pca.persistence.dao.ProblemDao;
import pca.persistence.dto.ProblemDto;
import pca.persistence.model.Comment;
import pca.persistence.model.Problem;
import pca.service.Converter;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProblemService {

    @Autowired
    private ProblemDao problemDao;
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private Converter converter;

    public List<ProblemDto> findAllProblems() {
        List<Problem> problemList = problemDao.findAll();
        List<ProblemDto> problemDtoList = new ArrayList<ProblemDto>();
        for (Problem p : problemList) {
            problemDtoList.add(converter.getProblemDto(p));
        }
        return problemDtoList;
    }

    public ProblemDto findProblem(String problemName) {

        return converter.getProblemDto(problemDao.findOne(problemName));
    }

    public void addProblem(ProblemDto problemDto) {
        problemDao.save(converter.getProblem(problemDto));
    }

    public void removeProblem(String problemName) {
        List<Comment> commentList = commentDao.findByProblem(problemDao.findOne(problemName));
        for (Comment c: commentList) {
            commentDao.delete(c);
        }
        problemDao.delete(problemName);
    }

    public void updateProblem(ProblemDto problemDto) {

    }

    public void setConverter(Converter converter) {
        this.converter = converter;
    }

}
