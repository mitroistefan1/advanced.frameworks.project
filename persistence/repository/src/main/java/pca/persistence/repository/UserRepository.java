package pca.persistence.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pca.persistence.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

  User findByUserName(String userName);

  User findByValidToken(String validToken);

}
