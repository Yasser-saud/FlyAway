package com.example.SpringMvc.Repo;

import com.example.SpringMvc.model.Flight;
import com.example.SpringMvc.model.Place;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class FlightRepoImpl implements FlightRepo{

    private final SessionFactory sessionFactory;

    @Autowired
    public FlightRepoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addFlight(Flight flight) {
        sessionFactory.getCurrentSession().save(flight);
    }

    @Override
    public List<Flight> getAllFlights() {
        return sessionFactory.getCurrentSession().createQuery("from Flight ").list();
    }

    @Override
    public Flight getById(Integer flightId) {
        return sessionFactory.getCurrentSession().get(Flight.class, flightId);
    }
}
