package com.busagency.services;

import com.busagency.db.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

enum Status {
    CONFIRMED, CANCELLED, PENDING
}

public class BookingService {
    private int bookingId;
    private int passengerId;
    private int busId;
    private Date bookingDate;
    private int seatNo;
    private double price;
    private Status status;

    public BookingService() {}

    public BookingService(int bookingId, int passengerId, int busId, Date bookingDate, int seatNo, double price, Status status) {
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

    public void createBooking(int passengerId, int busId, int seatNo, double price) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("INSERT INTO bookings(passenger_id, bus_id, booking_date, seat_number, price, status) VALUES (?, ?, NOW(), ?, ?, 'Pending')");) {
            pstmt.setInt(1, passengerId);
            pstmt.setInt(2, busId);
            pstmt.setInt(3, seatNo);
            pstmt.setDouble(4, price);
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
}
