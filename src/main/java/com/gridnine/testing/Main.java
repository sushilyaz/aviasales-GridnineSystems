package com.gridnine.testing;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.stratagy.FlightFilter;
import com.gridnine.testing.stratagy.FlightFilterStrategy;
import com.gridnine.testing.stratagy.filters.FlightFilterStrategy1;
import com.gridnine.testing.stratagy.filters.FlightFilterStrategy2;
import com.gridnine.testing.stratagy.filters.FlightFilterStrategy3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        List<FlightFilterStrategy> strategies = new ArrayList<>();

        FlightFilter filter = new FlightFilter(strategies);

        // Добавляем 1 фильтр
        strategies.add(new FlightFilterStrategy1());

        // Фильтрация перелётов по первому правилу
        List<Flight> filteredFlights1 = filter.filter(flights);
        System.out.println("Перелёты, которые вылетают до текущего момента времени:");
        for (Flight flight : filteredFlights1) {
            System.out.println(flight);
        }
        // Добавляем второй фильтр
        strategies.add(new FlightFilterStrategy2());
        // Фильтрация перелётов по второму правилу
        List<Flight> filteredFlights2 = filter.filter(flights);
        System.out.println("Перелёты, в которых есть сегменты с датой прилёта раньше даты вылета:");
        for (Flight flight : filteredFlights2) {
            System.out.println(flight);
        }


        // Добавляем третий фильтр

        strategies.add(new FlightFilterStrategy3());
        // Фильтрация перелётов по третьему правилу
        List<Flight> filteredFlights3 = filter.filter(flights);
        System.out.println("Перелёты, в которых общее время, проведённое на земле, превышает два часа:");
        for (Flight flight : filteredFlights3) {
            System.out.println(flight);
        }
    }
}