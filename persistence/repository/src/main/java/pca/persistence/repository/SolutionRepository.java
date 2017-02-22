package pca.persistence.repository;


import org.springframework.data.repository.CrudRepository;
import pca.persistence.model.Problem;
import pca.persistence.model.Solution;
import pca.persistence.model.User;

import java.util.List;

public interface SolutionRepository extends CrudRepository<Solution, Integer> {

  List<Solution> findByProblem(Problem problem);
  List<User> findByUser(User user);

}
