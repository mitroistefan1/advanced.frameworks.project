package pca.persistence.repository;


import org.springframework.data.repository.CrudRepository;
import pca.persistence.model.Comment;
import pca.persistence.model.Problem;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Integer> {

  List<Comment> findByProblem(Problem problem);

}
