package pca.service.comment;

import org.springframework.beans.factory.annotation.Autowired;
import pca.converter.CommentConverter;
import pca.converter.ProblemConverter;
import pca.persistence.dao.CommentRepository;
import pca.persistence.dao.ProblemRepository;
import pca.service.data.CommentData;
import pca.service.data.ProblemData;
import pca.persistence.model.Comment;


import java.util.ArrayList;
import java.util.List;

public class CommentServiceImpl implements CommentService {

  @Autowired
  private CommentRepository commentRepository;
  @Autowired
  private ProblemRepository problemRepository;

  private CommentConverter commentConverter;
  private ProblemConverter problemConverter;

  public List<CommentData> findAllComments(ProblemData problemData) {

    List<Comment> list = commentRepository.findByProblem(problemConverter.convertToModel(problemData));
    List<CommentData> listData = new ArrayList<CommentData>();
    for (Comment c : list) {
      listData.add(commentConverter.convertToData(c));
    }
    return listData;
  }

  public void addComment(CommentData commentData, String problemName, String author) {

    commentData.setProblem(problemRepository.findOne(problemName));
    commentData.setAuthor(author);
    commentRepository.save(commentConverter.convertToModel(commentData));
  }

  public void deleteComment(int commentId) {
    commentRepository.delete(commentId);
  }


  public void setCommentConverter(CommentConverter commentConverter) {
    this.commentConverter = commentConverter;
  }


  public void setProblemConverter(ProblemConverter problemConverter) {
    this.problemConverter = problemConverter;
  }
}
