package com.spacetravel.spacetravel.controller;

import com.spacetravel.spacetravel.enity.Tourist;
import com.spacetravel.spacetravel.manager.TouristManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tourist")
public class TouristController {
    private TouristManager touristManager;

    @Autowired
    public TouristController(TouristManager touristManager) {
        this.touristManager = touristManager;
    }

    @GetMapping("/all")
    public Iterable<Tourist> getAll(){
        return touristManager.findAll();
    }

    @PostMapping
    public Long addTourist (@RequestBody Tourist tourist){
        return touristManager.addTourist(tourist).getID();
    }

    @DeleteMapping
    public void deleteTourist (@RequestParam Long id){
        touristManager.deleteByID(id);
    }
}
