package pca.persistence.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pca.persistence.model.UserToken;

@Repository
public interface UserTokenRepository extends CrudRepository<UserToken, String> {
    public UserToken save(UserToken userToken);

    public UserToken findBySeries(String series);

    public UserToken findByUserName(String userName);

    public void delete(UserToken userToken);
}
