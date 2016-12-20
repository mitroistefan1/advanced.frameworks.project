package pca.persistence.dao;


import pca.persistence.model.User;

public interface UserDao {
    public boolean isValid(User user);
    public User getUser(String userName);
    public void crateUser(User user);
}
