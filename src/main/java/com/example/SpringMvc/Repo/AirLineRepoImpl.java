package com.example.SpringMvc.Repo;

import com.example.SpringMvc.model.AirLine;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AirLineRepoImpl implements AirLineRepo{

    private final SessionFactory sessionFactory;

    @Autowired
    public AirLineRepoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addAirLine(AirLine airLine) {
        sessionFactory.getCurrentSession().save(airLine);
    }

    @Override
    public List<AirLine> getAllAirLines() {
        return sessionFactory.getCurrentSession().createQuery("from AirLine").list();
    }

    @Override
    public AirLine getById(Integer airLineId) {
        return sessionFactory.getCurrentSession().get(AirLine.class, airLineId);
    }
}
