package pca.persistence.dao;


import pca.persistence.model.PersistentUser;
import pca.persistence.model.User;

public interface UserDao {
    public boolean isValid(User user);
    public User getUser(String userName);
    public void crateUser(User user);
    //remember-me
    public void savePersistentUser(PersistentUser persistentUser);
    public PersistentUser getBySerises(String series);
    public void updatePersistentUser(PersistentUser persistentUser);
    public PersistentUser getByUserName(String userName);
    public void deletPersistentUser(PersistentUser persistentUser);
}
