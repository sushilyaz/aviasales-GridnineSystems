package com.gridnine.testing.stratagy.filters;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import com.gridnine.testing.stratagy.FlightFilterStrategy;

import java.util.ArrayList;
import java.util.List;

public class FlightFilterStrategy2 implements FlightFilterStrategy {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        List<Flight> filteredFlights = new ArrayList<>();
        for (Flight flight : flights) {
            boolean isValid = true;
            for (int i = 0; i < flight.getSegments().size() - 1; i++) {
                Segment currentSegment = flight.getSegments().get(i);
                Segment nextSegment = flight.getSegments().get(i + 1);
                if (currentSegment.getArrivalDate().isAfter(nextSegment.getDepartureDate())) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                filteredFlights.add(flight);
            }
        }
        return filteredFlights;
    }
}
