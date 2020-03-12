package com.spacetravel.spacetravel.repository;

import com.spacetravel.spacetravel.enity.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface FlightRepository extends CrudRepository <Flight,Long> {

    Iterable<Flight> findAllByDepartueAfter(Date date);
}
