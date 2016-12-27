package pca.persistence.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pca.persistence.model.User;

@Repository
public interface UserDao extends CrudRepository<User,String> {

    public boolean exists(String userName);
    public User findByUserName(String userName);
    public User save(User user);
    //remember-me
  /*  public void savePersistentUser(TokenUser persistentUser);
    public TokenUser getBySerises(String series);
    public void updatePersistentUser(TokenUser persistentUser);
    public TokenUser getByUserName(String userName);
    public void deletPersistentUser(TokenUser persistentUser);*/
}
