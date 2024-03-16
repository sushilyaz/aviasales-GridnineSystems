package com.gridnine.testing.stratagy;

import com.gridnine.testing.model.Flight;

import java.util.List;

public interface FlightFilterStrategy {
    List<Flight> filter(List<Flight> flights);
}
