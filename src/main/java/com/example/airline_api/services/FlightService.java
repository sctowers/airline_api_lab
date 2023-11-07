package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    // Get all available flights
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    // Get details of a specific flights by ID
    public Flight getFlightById(Long id) {
        return flightRepository.findById(id).get();
    }

    // Add details of a new flights
    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    // Book a passenger on a flight

    // Cancel a flight


}
