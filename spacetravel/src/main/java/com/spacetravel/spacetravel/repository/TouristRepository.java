package com.spacetravel.spacetravel.repository;

import com.spacetravel.spacetravel.enity.Tourist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TouristRepository extends CrudRepository <Tourist,Long> {
}
