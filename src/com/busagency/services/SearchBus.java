package com.busagency.services;

import com.busagency.db.DatabaseConnection;


import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchBus {
    private String startLocation;
    private String destination;
    private Date date;
    private boolean isAvailable;

    public SearchBus(String startLocation, String destination, Date date, boolean isAvailable) {
        this.startLocation = startLocation;
        this.destination = destination;
        this.date = date;
        this.isAvailable = isAvailable;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public boolean searchBusDetails(String startLocation, String destination, Date date) {
        boolean isAvailable = false;
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "SELECT * FROM Bus WHERE startLocation = ? AND destination = ? AND date = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, startLocation);
            pstmt.setString(2, destination);
            pstmt.setDate(3, new java.sql.Date(date.getTime()));

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                isAvailable = true;
                System.out.println("Bus Available from " + startLocation + " to " + destination + " on " + date);
            } else {
                System.out.println("No Bus Found!");
            }

            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return isAvailable;
    }

}

