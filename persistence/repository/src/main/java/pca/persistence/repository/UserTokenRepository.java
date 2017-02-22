package pca.persistence.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pca.persistence.model.UserToken;

@Repository
public interface UserTokenRepository extends CrudRepository<UserToken, String> {

  UserToken findBySeries(String series);

  UserToken findByUserName(String userName);

}
