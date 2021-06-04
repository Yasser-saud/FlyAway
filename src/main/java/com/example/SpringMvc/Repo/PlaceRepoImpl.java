package com.example.SpringMvc.Repo;

import com.example.SpringMvc.model.Place;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PlaceRepoImpl implements PlaceRepo {


    private final SessionFactory sessionFactory;

    @Autowired
    public PlaceRepoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addPlace(Place place) {
        sessionFactory.getCurrentSession().save(place);
    }

    @Override
    public List<Place> getAllPlaces() {
        return sessionFactory.getCurrentSession().createQuery("from Place").list();
    }

    @Override
    public Place getById(Integer placeId) {
        return sessionFactory.getCurrentSession().get(Place.class, placeId);
    }
}
