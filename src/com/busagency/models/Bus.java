package com.busagency.models;
enum BusType{
    AC, NON_AC, SLEEPER, SEATER
}
public class Bus {
    int busId;
    String startLocation;
    String destination;
    BusType busType;
    boolean isAvailable = true;

    public Bus(int busId, String startLocation, String destination, BusType busType, boolean isAvailable){
        this.busId = busId;
        this.startLocation = startLocation;
        this.destination = destination;
        this.busType = busType;
        this.isAvailable = isAvailable;
    }

    public int getBusId(){
        return busId;
    }
    public String getStartLocation(){
        return startLocation;
    }
    public  String getDestination(){
        return destination;
    }
    public BusType getBusType() {
        return busType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setBusId(int busId) {
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
    public void setAvailable(boolean isAvailable){
        this.isAvailable = isAvailable;
    }
}
