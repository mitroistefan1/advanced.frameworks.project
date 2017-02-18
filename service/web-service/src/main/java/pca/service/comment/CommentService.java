package pca.service.comment;


import pca.service.data.CommentData;
import pca.service.data.ProblemData;

import java.util.List;

public interface CommentService {

  List<CommentData> findAllComments(ProblemData problemData);

  void addComment(CommentData commentData, String problemName, String author);

  void deleteComment(int commentId);
}
