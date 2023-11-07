package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

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
        // Create and save flights
        Flight flight1 = new Flight("Baku", 200, "2023-12-01", "10:00 AM");
        Flight flight2 = new Flight("Tokyo", 150, "2023-12-02", "11:00 AM");
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
