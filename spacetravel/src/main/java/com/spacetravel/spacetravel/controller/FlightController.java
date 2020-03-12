package com.spacetravel.spacetravel.controller;

import com.spacetravel.spacetravel.enity.*;
import com.spacetravel.spacetravel.manager.FlightManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flight")
public class FlightController {

    private FlightManager flightManager;

    @Autowired
    public FlightController(FlightManager flightManager) {
        this.flightManager = flightManager;
    }


    @GetMapping("/all")
    public Iterable<Flight> getAll(){
        return flightManager.findAll();
    }

    @GetMapping
    public Iterable<FlightResponse> getActuall(){
        return flightManager.getActuall();
    }

    @PostMapping
    public Flight addFlight (@RequestBody FlightRequest flight){
        return flightManager.addFlight(flight);
    }

    @DeleteMapping
    public void deleteFlight (@RequestParam Long Id){
        flightManager.deleteFlight(Id);
    }

    @PutMapping("/add")
    public boolean addPassenger(@RequestParam Long TouristID, Long FlightID){
        return flightManager.addPassenger(FlightID,TouristID);
    }
    @PutMapping("/rem")
    public boolean removePassenger(@RequestParam Long TouristID, Long FlightID){
        return flightManager.removePassenger(FlightID,TouristID);
    }

}
