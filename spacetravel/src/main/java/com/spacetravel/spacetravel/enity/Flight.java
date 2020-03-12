package com.spacetravel.spacetravel.enity;


import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private Date departue;
    private Date arrival;
    private int numberOfSeat;
    private int numberOfTourist;
    private double price;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Tourist> tourist = new LinkedList<Tourist>();

    public Flight() {
    }
    public Flight(Date departue, Date arrival, int numberOfSeat,  double price) {
        this.departue = departue;
        this.arrival = arrival;
        this.numberOfSeat = numberOfSeat;
        this.price = price;
    }
    public FlightResponse getSimpleFlight (){
        return new FlightResponse (Id,departue,arrival,numberOfSeat,numberOfSeat-numberOfTourist,price);
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Date getDepartue() {
        return departue;
    }

    public void setDepartue(Date departue) {
        this.departue = departue;
    }

    public Date getArrival() {
        return arrival;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }

    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    public void setNumberOfSeat(int numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }

    public int getNumberOfTourist() {
        return numberOfTourist;
    }

    public void setNumberOfTourist(int numberOfTourist) {
        this.numberOfTourist = numberOfTourist;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Tourist> getTourist() {
        return tourist;
    }

    public void setTourist(List<Tourist> tourist) {
        this.tourist = tourist;
    }

    public boolean addTourist (Tourist t){
        if(!(numberOfTourist<numberOfSeat))
            return false;
        numberOfTourist++;
        tourist.add(t);
        return true;

    }
    public void removeTourist (Tourist t) {
        if (tourist.remove(t))
            numberOfTourist--;
    }
}
