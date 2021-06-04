package com.example.SpringMvc.Repo;

import com.example.SpringMvc.model.AirLine;
import java.util.List;

public interface AirLineRepo {
    void addAirLine(AirLine airLine);
    List<AirLine> getAllAirLines();
    AirLine getById(Integer airLineId);
}
