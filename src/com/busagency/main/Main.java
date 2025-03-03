package com.busagency.main;

import com.busagency.services.SearchBus;
import com.busagency.services.BookingService;
import com.busagency.models.Bus;
import com.busagency.models.BusType;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookingService bookingService = new BookingService();
        System.out.println("Welcome to the Bus Ticket Booking System!");

        while (true) {
            System.out.println("\n1. Search Buses");
            System.out.println("2. Book Ticket");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter Start Location: ");
                    String start = scanner.nextLine();
                    System.out.print("Enter Destination: ");
                    String destination = scanner.nextLine();
                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    String dateInput = scanner.nextLine();

                    try {
                        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateInput);
                        SearchBus searchBus = new SearchBus(start, destination, true);
                        searchBus.searchBusDetails(start, destination);
                    } catch (Exception e) {
                        System.out.println("Invalid Date Format. Please enter the date in YYYY-MM-DD format.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Passenger Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Gender (MALE/FEMALE): ");
                    String gender = scanner.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String phone = scanner.nextLine();

                    System.out.print("Enter Bus ID: ");
                    String busId = scanner.nextLine();
                    bookingService.getBusDetails(busId);

                    System.out.print("Enter Distance (in Km): ");
                    int distance = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Bus Type (AC/NON-AC/SLEEPER/SEATER): ");
                    String busType = scanner.nextLine();

                    try {
                        BusType busTypeEnum = BusType.valueOf(busType.toUpperCase());
                        double fare = bookingService.calculateFare(distance, busTypeEnum);
                        System.out.printf("Total Fare: ₹%.2f%n", fare);

                        System.out.print("Confirm Booking (YES/NO): ");
                        String confirm = scanner.nextLine();

                        if (confirm.equalsIgnoreCase("YES") || confirm.equalsIgnoreCase("Y")) {
                            Random random = new Random();
                            int passengerId = random.nextInt(10000);

                            bookingService.createPassenger(passengerId, name);
                            System.out.print("Enter Seat Number: ");
                            int seatNo = scanner.nextInt();
                            scanner.nextLine();
                            bookingService.createBooking(passengerId, busId, seatNo, fare);

                            System.out.println("Booking Confirmed!");
                            System.out.println("Your Ticket Number: TKT" + System.currentTimeMillis());
                        } else {
                            System.out.println("Booking Cancelled!");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid Bus Type. Please enter AC, NON-AC, SLEEPER, or SEATER.");
                    }
                    break;

                case 3:
                    System.out.println("Thank you for using the Bus Ticket Booking System!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
