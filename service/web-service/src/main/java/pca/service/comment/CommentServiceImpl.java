package pca.service.comment;

import org.springframework.beans.factory.annotation.Autowired;
import pca.converter.CommentConverter;
import pca.persistence.repository.CommentRepository;
import pca.persistence.repository.ProblemRepository;
import pca.service.data.CommentData;
import pca.persistence.model.Comment;


import java.util.ArrayList;
import java.util.List;

public class CommentServiceImpl implements CommentService {

  @Autowired
  private CommentRepository commentRepository;
  @Autowired
  private ProblemRepository problemRepository;
  private CommentConverter commentConverter;

  public List<CommentData> findAllComments(String problemName) {

    List<Comment> list = commentRepository.findByProblem(problemRepository.findOne(problemName));
    List<CommentData> listData = new ArrayList<>();

    for (Comment c : list) {
      listData.add(commentConverter.convertToData(c));
    }

    return listData;
  }

  public void addComment(CommentData commentData) {

    commentRepository.save(commentConverter.convertToModel(commentData));
  }

  public void deleteComment(int commentId) {
    commentRepository.delete(commentId);
  }


  public void setCommentConverter(CommentConverter commentConverter) {
    this.commentConverter = commentConverter;
  }

}
