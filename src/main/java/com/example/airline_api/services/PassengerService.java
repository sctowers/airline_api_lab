package com.example.airline_api.services;

import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;


    // Get all details of passengers
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    // Get details of a specific passenger
    public Passenger getPassengerById(Long id){
        return passengerRepository.findById(id).get();
    }

    // Add a new passenger
    public Passenger addPassenger(Passenger passenger){
        return passengerRepository.save(passenger);
    }

}
