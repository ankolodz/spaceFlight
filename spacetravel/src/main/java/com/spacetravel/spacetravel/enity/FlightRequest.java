package com.spacetravel.spacetravel.enity;

import java.util.Date;

public class FlightRequest {

    private final Date departue;
    private final Date arrival;
    private final int numberOfSeat;
    private final double price;

    public FlightRequest(Date departue, Date arrival, int numberOfSeat, double price) {
        this.departue = departue;
        this.arrival = arrival;
        this.numberOfSeat = numberOfSeat;
        this.price = price;
    }

    public Date getDepartue() {
        return departue;
    }

    public Date getArrival() {
        return arrival;
    }

    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    public double getPrice() {
        return price;
    }
}
