package com.example.SpringMvc.Repo;

import com.example.SpringMvc.model.Airline;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AirlineRepoImpl implements AirlineRepo {

    private final SessionFactory sessionFactory;

    @Autowired
    public AirlineRepoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addAirLine(Airline airLine) {
        sessionFactory.getCurrentSession().save(airLine);
    }

    @Override
    public List<Airline> getAllAirLines() {
        return sessionFactory.getCurrentSession().createQuery("from Airline").list();
    }

    @Override
    public Airline getById(Integer airLineId) {
        return sessionFactory.getCurrentSession().get(Airline.class, airLineId);
    }
}
