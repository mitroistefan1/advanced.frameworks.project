package pca.persistence.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pca.persistence.model.User;

@Repository
public interface UserDao extends CrudRepository<User, String> {
    public boolean exists(String userName);

    public User findByUserName(String userName);

    public User save(User user);
}
