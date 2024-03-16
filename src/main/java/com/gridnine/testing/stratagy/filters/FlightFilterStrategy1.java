package com.gridnine.testing.stratagy.filters;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.stratagy.FlightFilterStrategy;
import com.gridnine.testing.model.Segment;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightFilterStrategy1 implements FlightFilterStrategy {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        List<Flight> filteredFlights = new ArrayList<>();
        for (Flight flight : flights) {
            boolean isValid = true;
            for (Segment segment : flight.getSegments()) {
                if (segment.getDepartureDate().isBefore(LocalDateTime.now())) {
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
