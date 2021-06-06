package com.example.SpringMvc.Repo;

import com.example.SpringMvc.model.Flight;
import java.util.List;

public interface FlightRepo {
    void addFlight(Flight flight);
    List<Flight> getAllFlights();
    Flight getById(Integer flightId);
    List<Flight> findFlight(String source, String destination);
}
