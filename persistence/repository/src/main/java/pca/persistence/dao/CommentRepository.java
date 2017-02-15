package pca.persistence.dao;


import org.springframework.data.repository.CrudRepository;
import pca.persistence.model.Comment;
import pca.persistence.model.Problem;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment,Integer> {
    List<Comment> findByProblem(Problem problem);
    Comment save(Comment comment);
    void delete(Comment comment);
    void delete(Integer id);
}
