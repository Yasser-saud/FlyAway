package com.example.SpringMvc.Repo;

import com.example.SpringMvc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserRepoImpl implements UserRepo {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserRepoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public User getByUsername(String username) {
        Query query = sessionFactory.getCurrentSession().createQuery("from User where username =:username").setParameter("username", username);
        return (User) query.uniqueResult();
    }

    public int updatePassword(int id, String password) {
        Query query = sessionFactory.getCurrentSession().createQuery("update User set password =:password where id = :id");
        query.setParameter("id", id);
        query.setParameter("password", password);

        return query.executeUpdate();
    }
}
