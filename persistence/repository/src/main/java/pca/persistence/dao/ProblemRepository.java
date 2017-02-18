package pca.persistence.dao;


import org.springframework.data.repository.CrudRepository;
import pca.persistence.model.Problem;

import java.util.List;

public interface ProblemRepository extends CrudRepository<Problem, String> {

}
