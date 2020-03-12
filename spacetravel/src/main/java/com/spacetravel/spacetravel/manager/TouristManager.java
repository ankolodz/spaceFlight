package com.spacetravel.spacetravel.manager;

import com.spacetravel.spacetravel.enity.Tourist;
import com.spacetravel.spacetravel.repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TouristManager {

    private TouristRepository touristRepository;

    @Autowired
    public TouristManager(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    public Iterable<Tourist> findAll(){
        return touristRepository.findAll();
    }

    public Tourist addTourist (Tourist tourist){
        return touristRepository.save(tourist);
    }
    public void deleteByID (Long Id){
        touristRepository.deleteById(Id);
    }

}
