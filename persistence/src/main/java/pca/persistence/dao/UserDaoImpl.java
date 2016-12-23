package pca.persistence.dao;


import org.hibernate.*;
import pca.persistence.model.PersistentUser;
import pca.persistence.model.User;

public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;


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

    public void savePersistentUser(PersistentUser persistentUser) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(persistentUser);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public PersistentUser getBySerises(String series) {
        Session session = sessionFactory.getCurrentSession();
        PersistentUser persistentUser = new PersistentUser();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            persistentUser = (PersistentUser) session.get(PersistentUser.class,series);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return persistentUser;
    }

    public void updatePersistentUser(PersistentUser persistentUser) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(persistentUser);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public PersistentUser getByUserName(String userName) {
        Session session = sessionFactory.getCurrentSession();
        PersistentUser persistentUser = new PersistentUser();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            persistentUser = (PersistentUser) session.get(PersistentUser.class,userName);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return persistentUser;
    }

    public void deletPersistentUser(PersistentUser persistentUser) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(persistentUser);
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
