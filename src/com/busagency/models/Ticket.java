package com.busagency.models;

public class Ticket {
    private int ticketId;
    private int passengerId;
    private String busId;
    private int seatNo;
    private double fare;

    // Constructor
    public Ticket(int ticketId, int passengerId, String busId, int seatNo, double fare) {
        this.ticketId = ticketId;
        this.passengerId = passengerId;
        this.busId = busId;
        this.seatNo = seatNo;
        this.fare = fare;
    }

    // Getters
    public int getTicketId() {
        return ticketId;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public String getBusId() {
        return busId;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public double getFare() {
        return fare;
    }

    // Setters
    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    @Override
    public String toString() {
        return "Ticket ID: " + ticketId +
                ", Passenger ID: " + passengerId +
                ", Bus ID: " + busId +
                ", Seat No: " + seatNo +
                ", Fare: ₹" + fare;
    }
}
