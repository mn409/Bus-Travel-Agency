package com.busagency.models;

public class Bus {
    private String busId;
    private String start_Point;
    private String destination;
    private BusType busType;
    private boolean isAvailable;

    // Constructor
    public Bus(String busId, String start_Point, String destination, BusType busType, boolean isAvailable) {
        this.busId = busId;
        this.start_Point = start_Point;
        this.destination = destination;
        this.busType = busType;
        this.isAvailable = isAvailable;
    }

    // Getters
    public String getBusId() {
        return busId;
    }

    public String getStart_Point() {
        return start_Point;
    }

    public String getDestination() {
        return destination;
    }

    public BusType getBusType() {
        return busType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Setters
    public void setBusId(String busId) {
        this.busId = busId;
    }

    public void setStart_Point(String start_Point) {
        this.start_Point = start_Point;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setBusType(BusType busType) {
        this.busType = busType;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    @Override
    public String toString() {
        return "Bus ID: " + busId + ", Starting Point: " + start_Point + ", Destination: " + destination +
                ", Bus Type: " + busType + ", Available: " + isAvailable;
    }
}
