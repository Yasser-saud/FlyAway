package com.example.SpringMvc.Repo;

import com.example.SpringMvc.model.Flight;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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

    @Override
    public List<Flight> findFlight(String source, String destination) {
        System.out.println("source is: "+source);
        Query query = sessionFactory.getCurrentSession().createQuery("from Flight where place.source like :source and place.destination like :dest");
        query.setParameter("source", source);
        query.setParameter("dest", destination);
        List<Flight> list = query.list();

        return list;
    }

}
