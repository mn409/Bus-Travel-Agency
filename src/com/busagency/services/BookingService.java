package com.busagency.services;

import com.busagency.db.DatabaseConnection;
import com.busagency.models.BusType;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class BookingService {
    private int bookingId;
    private int passengerId;
    private String busId;
    private Date bookingDate;
    private int seatNo;
    private double price;
    private Status status;

    public BookingService() {}

    public BookingService(int bookingId, int passengerId, String busId, Date bookingDate, int seatNo, double price, Status status) {
        this.bookingId = bookingId;
        this.passengerId = passengerId;
        this.busId = busId;
        this.bookingDate = bookingDate;
        this.seatNo = seatNo;
        this.price = price;
        this.status = status;
    }

    public void createPassenger(int passengerId, String name) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("INSERT INTO passengers(passenger_id, name) VALUES (?, ?)");) {
            pstmt.setInt(1, passengerId);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
            System.out.println("Passenger added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding passenger: " + e.getMessage());
        }
    }

    public static double calculateFare(int distance, BusType busType) {
        double pricePerKm = switch (busType) {
            case AC -> 2.5;
            case NON_AC -> 1.8;
            case SLEEPER -> 2.2;
            case SEATER -> 1.5;
            default -> throw new IllegalArgumentException("Invalid Bus Type");

        };

        return distance * pricePerKm;
    }


    public void createBooking(int passengerId, String busId, int seatNo, double price) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("INSERT INTO bookings(passenger_id, bus_id, booking_date, seat_number, price, status) VALUES (?, ?, NOW(), ?, ?, 'Pending')");) {
            pstmt.setInt(1, passengerId);
            pstmt.setString(2, busId);
            pstmt.setInt(3, seatNo);
            pstmt.setDouble(4, price);
            pstmt.setString(5, Status.PENDING.toString());

            int rowsEffected = pstmt.executeUpdate();
            if (rowsEffected > 0) {
                System.out.println("Booking successfully created");
            } else {
                System.out.println("Booking failed");
            }
        } catch (SQLException e) {
            System.out.println("Error creating booking: " + e.getMessage());
        }
    }

    public void getBusDetails(String busId) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Bus WHERE bus_id = ?")) {
            pstmt.setString(1, busId);
            var rs = pstmt.executeQuery();

            if (rs != null && rs.next()) {
                System.out.println("Bus ID: " + rs.getString("bus_id"));
                System.out.println("Start Location: " + rs.getString("start_location"));
                System.out.println("Destination: " + rs.getString("destination"));
                System.out.println("Bus Type: " + rs.getString("bus_type"));
                System.out.println("Availability: " + rs.getBoolean("is_available"));
            } else {
                System.out.println("No bus found with ID: " + busId);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching bus details: " + e.getMessage());
        }
    }
}
