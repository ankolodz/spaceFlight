package com.spacetravel.spacetravel.manager;

import com.spacetravel.spacetravel.enity.Flight;
import com.spacetravel.spacetravel.enity.FlightRequest;
import com.spacetravel.spacetravel.enity.FlightResponse;
import com.spacetravel.spacetravel.enity.Tourist;
import com.spacetravel.spacetravel.repository.FlightRepository;
import com.spacetravel.spacetravel.repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class FlightManager {
    private FlightRepository flightRepository;
    private TouristRepository touristRepository;

    @Autowired
    public FlightManager(FlightRepository flightRepository,TouristRepository touristRepository) {
        this.flightRepository = flightRepository;
        this.touristRepository = touristRepository;
    }

    public Iterable<Flight> findAll(){
        return flightRepository.findAll();
    }

    public Flight addFlight(FlightRequest f){
        Flight flight = new Flight(f.getDepartue(),f.getArrival(),f.getNumberOfSeat(),f.getPrice());
        return flightRepository.save(flight);
    }

    public void deleteFlight(Long Id){
        flightRepository.deleteById(Id);
    }

    public boolean addPassenger(Long flightID, Long touristID){
        Optional<Tourist> touristOptional = touristRepository.findById(touristID);
        Optional<Flight> flightOptional = flightRepository.findById(flightID);

        if (!touristOptional.isPresent() || !flightOptional.isPresent())
            return false;

        Tourist tourist = touristOptional.get();
        Flight flight = flightOptional.get();

        if (flight.addTourist(tourist))
            tourist.addFlight(flight);
        else
            return false;
        flightRepository.save(flight);
        touristRepository.save(tourist);
        return true;
    }
    public boolean removePassenger(Long flightID, Long touristID){
        Optional<Tourist> touristOptional = touristRepository.findById(touristID);
        Optional<Flight> flightOptional = flightRepository.findById(flightID);

        if (!touristOptional.isPresent() || !flightOptional.isPresent())
            return false;

        Tourist tourist = touristOptional.get();
        Flight flight = flightOptional.get();

        flight.removeTourist(tourist);
        tourist.removeFlight(flight);

        flightRepository.save(flight);
        touristRepository.save(tourist);
        return true;
    }

    public Iterable<FlightResponse> getActuall() {
        Iterable<Flight> allFlight = flightRepository.findAllByDepartueAfter(new Date());
        List<FlightResponse> filtredFlights = new ArrayList<>();
        for (Flight i:allFlight) {
            filtredFlights.add(i.getSimpleFlight());
        }

        return filtredFlights;

    }
}
