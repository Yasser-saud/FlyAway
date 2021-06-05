package com.example.SpringMvc.Repo;

import com.example.SpringMvc.model.Admin;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AdminRepoImpl implements AdminRepo{

    private final SessionFactory sessionFactory;

    @Autowired
    public AdminRepoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addAdmin(Admin admin) {
        sessionFactory.getCurrentSession().save(admin);
    }

    @Override
    public Admin getByUsername(String username) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Admin where username =:username").setParameter("username", username);
        return (Admin) query.uniqueResult();
    }

    public int updatePassword(int id, String password) {
        Query query = sessionFactory.getCurrentSession().createQuery("update Admin set password =:password where id = :id");
        query.setParameter("id", id);
        query.setParameter("password", password);

        return query.executeUpdate();
    }

}
