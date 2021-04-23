package pl.softserve.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import pl.softserve.Models.User;

import java.util.List;

@Repository
public class UserDAO {

    private final SessionFactory sessionFactory;


    public UserDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<User> getAllUsers(){
        Session session = this.sessionFactory.getCurrentSession();
        return (List<User>) session.createQuery("from User").list();
    }

    public User getUser(int id){
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(User.class,id);
    }

    public User addUser(User user){
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
        return user;
    }

    public void updateUser(User user){
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
    }

    public void deleteUser(int id){
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, id);
        if (null != user)
            session.delete(user);
    }
}
