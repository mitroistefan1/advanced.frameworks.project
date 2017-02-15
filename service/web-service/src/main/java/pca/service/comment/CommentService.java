package pca.service.comment;


import pca.service.data.CommentData;
import pca.service.data.ProblemData;

import java.util.List;

public interface CommentService {

    public List<CommentData> findAllComments(ProblemData problemData);
    public void addComment(CommentData commentData, String problemName, String author);
    public void deleteComment(int commentId);
}
