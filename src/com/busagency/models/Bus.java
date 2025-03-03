package com.busagency.models;

public class Bus {
    private String busId;
    private String startLocation;
    private String destination;
    private BusType busType;
    private boolean isAvailable;

    // Constructor
    public Bus(String busId, String startLocation, String destination, BusType busType, boolean isAvailable) {
        this.busId = busId;
        this.startLocation = startLocation;
        this.destination = destination;
        this.busType = busType;
        this.isAvailable = isAvailable;
    }

    // Getters
    public String getBusId() {
        return busId;
    }

    public String getStartLocation() {
        return startLocation;
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

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
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
        return "Bus ID: " + busId + ", Start Location: " + startLocation + ", Destination: " + destination +
                ", Bus Type: " + busType + ", Available: " + isAvailable;
    }
}
