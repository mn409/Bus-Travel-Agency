package com.busagency.services;

import com.busagency.db.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchBus {
    private String startLocation;
    private String destination;
    private boolean isAvailable;

    public SearchBus(String startLocation, String destination, boolean isAvailable) {
        this.startLocation = startLocation;
        this.destination = destination;
        this.isAvailable = isAvailable;
    }

    public boolean searchBusDetails(String startLocation, String destination) {
        boolean isAvailable = false;
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "SELECT * FROM Bus WHERE start_point = ? AND destination = ? AND is_available = 1";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, startLocation);
            pstmt.setString(2, destination);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                isAvailable = true;
                System.out.println("Bus Available from " + startLocation + " to " + destination);
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
