package com.busagency;

import com.busagency.db.DatabaseConnection;
import com.busagency.services.BookingService;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection connection = DatabaseConnection.getConnection();

        if(connection != null){
            System.out.println("Database connected Successfully");
        }else{
            System.out.println("Failed to connect to the database");
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter passenger details: " );
        System.out.println("-------------------------");

        System.out.print("Enter passenger ID: ");
        int passengerId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter passenger name: ");
        String name = sc.next();

        System.out.print("Enter Bus ID: ");
        int busId = sc.nextInt();

        System.out.print("Enter seat number: ");
        int seatNo = sc.nextInt();

        System.out.print("Enter price: ");
        double price = sc.nextDouble();

        System.out.println("-------------------------");

        BookingService bookingService = new BookingService();
        //first we create the passenger
        bookingService.createPassenger(passengerId, name);
        //then we create the booking
        bookingService.createBooking(passengerId, busId, seatNo, price);
    }
}