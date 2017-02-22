package pca.persistence.repository;


import org.springframework.data.repository.CrudRepository;
import pca.persistence.model.Problem;

public interface ProblemRepository extends CrudRepository<Problem, String> {

}
