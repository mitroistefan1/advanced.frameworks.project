package pca.persistence.dao;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pca.persistence.model.User;

public class UserDaoImpl implements UserDao {

    SessionFactory sessionFactory;


    public boolean isValid(User user) {
        return ("stefan.mitroi".equals(user.getUserName()) && "password".equals(user.getPassword()));
    }

    public User getUser(String userName) {
        User returnUser = new User();
        returnUser.setUserName("stefan.mitroi");
        returnUser.setPassword("password");
        return returnUser;
    }

    public void crateUser(User user) {

        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
