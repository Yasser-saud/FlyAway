package com.example.SpringMvc.Repo;

import com.example.SpringMvc.model.Airline;

import java.util.List;

public interface AirlineRepo {
    void addAirLine(Airline airLine);
    List<Airline> getAllAirLines();
    Airline getById(Integer airLineId);
}
