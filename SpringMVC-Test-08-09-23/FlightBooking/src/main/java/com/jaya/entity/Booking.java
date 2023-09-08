package com.jaya.entity;

public class Booking {
    private String flightId;
    private int passengerId;

    public Booking() {}

    public Booking(String flightId, int passengerId) {
        this.flightId = flightId;
        this.passengerId = passengerId;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }
}
