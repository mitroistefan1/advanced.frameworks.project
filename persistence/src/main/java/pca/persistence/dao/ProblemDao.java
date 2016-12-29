package pca.persistence.dao;


import org.springframework.data.repository.CrudRepository;
import pca.persistence.model.Problem;

import java.util.List;

public interface ProblemDao extends CrudRepository<Problem, String> {
    List<Problem> findAll();

    Problem findOne(String problemName);

    Problem save(Problem problem);

    void delete(String problemName);


}
