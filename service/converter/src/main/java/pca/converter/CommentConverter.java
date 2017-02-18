package pca.converter;


import pca.persistence.model.Comment;
import pca.service.data.CommentData;

public class CommentConverter implements Converter<Comment, CommentData> {

  public CommentData convertToData(Comment model) {

    CommentData commentData = new CommentData();

    commentData.setId(model.getId());
    commentData.setBody(model.getBody());
    commentData.setProblem(model.getProblem());
    commentData.setAuthor(model.getAuthor());
    return commentData;
  }

  public Comment convertToModel(CommentData data) {

    Comment comment = new Comment();

    comment.setId(data.getId());
    comment.setBody(data.getBody());
    comment.setProblem(data.getProblem());
    comment.setAuthor(data.getAuthor());
    return comment;
  }
}
