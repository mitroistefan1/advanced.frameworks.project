package pca.service.comment;


import pca.service.data.CommentData;

import java.util.List;

public interface CommentService {

  List<CommentData> findAllComments(String problemName);

  void addComment(CommentData commentData);

  void deleteComment(int commentId);
}
