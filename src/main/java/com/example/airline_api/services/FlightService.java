package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    @Transactional
    public Flight addPassengerToFlight(Long flightId, Long passengerId) {
        Optional<Flight> flightOptional = flightRepository.findById(flightId);
        Optional<Passenger> passengerOptional = passengerRepository.findById(passengerId);
        Flight flight = flightOptional.get();
        Passenger passenger = passengerOptional.get();
        flight.getPassengers().add(passenger);
        flightRepository.save(flight);
        return flight;
    }


    // Cancel a flight
    @Transactional
    public Flight cancelFlight(Long id) {
        Optional<Flight> flightOptional = flightRepository.findById(id);
        Flight flight = flightOptional.get();
        flight.getPassengers().clear();
        flightRepository.delete(flight);
        return flight;
    }

    // Add functionality to filter flights by destination
    public List<Flight> getFlightsByDestination(String destination){
        return flightRepository.findByDestination(destination);
    }
}