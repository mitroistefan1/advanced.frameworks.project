package pca.converter;


import org.springframework.beans.factory.annotation.Autowired;
import pca.persistence.model.Comment;
import pca.persistence.repository.ProblemRepository;
import pca.persistence.repository.UserRepository;
import pca.service.data.CommentData;

public class CommentConverter implements Converter<Comment, CommentData> {

  @Autowired
  private ProblemRepository problemRepository;
  @Autowired
  private UserRepository userRepository;

  public CommentData convertToData(Comment model) {

    CommentData commentData = new CommentData();

    commentData.setId(model.getId());
    commentData.setBody(model.getBody());
    commentData.setProblemName(model.getProblem().getProblemName());
    commentData.setUserName(model.getUser().getUserName());

    return commentData;
  }

  public Comment convertToModel(CommentData data) {

    Comment comment = new Comment();

    comment.setId(data.getId());
    comment.setBody(data.getBody());
    comment.setProblem(problemRepository.findOne(data.getProblemName()));
    comment.setUser(userRepository.findOne(data.getUserName()));

    return comment;
  }
}
