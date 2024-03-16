package com.gridnine.testing.stratagy;

import com.gridnine.testing.model.Flight;

import java.util.ArrayList;
import java.util.List;

public class FlightFilter {

    private List<FlightFilterStrategy> strategies;

    public FlightFilter(List<FlightFilterStrategy> strategies) {
        this.strategies = strategies;
    }

    public List<Flight> filter(List<Flight> flights) {
        List<Flight> filteredFlights = new ArrayList<>();
        for (FlightFilterStrategy strategy : strategies) {
            filteredFlights.addAll(strategy.filter(flights));
        }
        return filteredFlights;
    }
}
