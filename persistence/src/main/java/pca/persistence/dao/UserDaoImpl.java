package pca.persistence.dao;


import pca.persistence.model.User;

public class UserDaoImpl implements UserDao {
    public boolean isValid(User user) {
        return ("stefan.mitroi".equals(user.getUserName()) && "password".equals(user.getPassword()));
    }

    public User getUser(String userName) {
        User returnUser = new User();
        returnUser.setUserName("stefan.mitroi");
        returnUser.setPassword("password");
        return  returnUser;
    }
}
