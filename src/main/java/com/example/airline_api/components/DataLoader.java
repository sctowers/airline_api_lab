package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public DataLoader() {

    }

    @Override
    public void run(ApplicationArguments args) throws Exception{

        // LocalDate and LocalTime formatter
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a", Locale.UK);

        // Create and save flights
        Flight flight1 = new Flight("Baku", 200, LocalDate.parse("2023-12-01", dateFormatter), LocalTime.parse("10:00 AM", timeFormatter));
        Flight flight2 = new Flight("Tokyo", 150, LocalDate.parse("2023-12-02", dateFormatter), LocalTime.parse("11:00 AM", timeFormatter));

        flightRepository.save(flight1);
        flightRepository.save(flight2);

        // Create and save passengers
        Passenger passenger1 = new Passenger("Suzi", "suzi@gamil.com");
        Passenger passenger2 = new Passenger("Mark", "mark@gamil.com");
        passengerRepository.save(passenger1);
        passengerRepository.save(passenger2);

        // Book passengers on flights
        flight1.getPassengers().add(passenger1);
        flight2.getPassengers().add(passenger2);
        flightRepository.save(flight1);
        flightRepository.save(flight2);
    }
}
