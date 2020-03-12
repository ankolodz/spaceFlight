package com.spacetravel.spacetravel.enity;

import java.util.Date;

public class FlightResponse {
    private Long ID;
    private Date departue;
    private Date arrival;
    private int numberOfSeat;
    private int freeSeat;
    private double price;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public FlightResponse(Long ID, Date departue, Date arrival, int numberOfSeat, int numberOfTourist, double price) {
        this.departue = departue;
        this.arrival = arrival;
        this.numberOfSeat = numberOfSeat;
        this.freeSeat = numberOfTourist;
        this.price = price;
        this.ID = ID;
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

    public int getFreeSeat() {
        return freeSeat;
    }

    public void setFreeSeat(int freeSeat) {
        this.freeSeat = freeSeat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
