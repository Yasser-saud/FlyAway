package com.example.SpringMvc.Repo;

import com.example.SpringMvc.model.Place;

import java.util.List;

public interface PlaceRepo {
    void addPlace(Place place);
    List<Place> getAllPlaces();
    Place getById(Integer placeId);
}
