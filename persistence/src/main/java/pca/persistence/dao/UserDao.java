package pca.persistence.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pca.persistence.model.PersistentUser;
import pca.persistence.model.User;

@Repository
public interface UserDao extends CrudRepository<User,String> {

    public boolean exists(String userName);
    public User findByUserName(String userName);
    public User save(User user);
    //remember-me
  /*  public void savePersistentUser(PersistentUser persistentUser);
    public PersistentUser getBySerises(String series);
    public void updatePersistentUser(PersistentUser persistentUser);
    public PersistentUser getByUserName(String userName);
    public void deletPersistentUser(PersistentUser persistentUser);*/
}
