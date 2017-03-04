package pca.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pca.persistence.model.Problem;
import pca.persistence.model.Test;

import java.util.List;

@Repository
public interface TestRepository extends CrudRepository<Test, Integer> {
  List<Test> findByProblem(Problem problem);
}
