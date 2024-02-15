package com.parking.controller;

import com.parking.service.ParkingService;

import java.util.Scanner;

public class ParkingController {
    private final ParkingService parkingService;
    private final Scanner scanner;

    public ParkingController() {
        parkingService = new ParkingService();
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Parking Lot Management System");
        while (true) {
            System.out.print("Enter command: ");
            String command = scanner.nextLine();
            if (command.equals("exit")) {
                System.out.println("Exiting...");
                break;
            }
            String[] parts = command.split(" ");
            switch (parts[0]) {
                case "create_parking_lot":
                    if (parts.length == 2) {
                        int capacity = Integer.parseInt(parts[1]);
                        parkingService.createParkingLot(capacity);
                    } else {
                        System.out.println("Invalid command format. Usage: create_parking_lot <capacity>");
                    }
                    break;
                case "park":
                    if (parts.length == 3) {
                        String registrationNumber = parts[1];
                        String color = parts[2];
                        parkingService.parkCar(registrationNumber, color);
                    } else {
                        System.out.println("Invalid command format. Usage: park <registration_number> <color>");
                    }
                    break;
                case "leave":
                    if (parts.length == 2) {
                        int slotNumber = Integer.parseInt(parts[1]);
                        parkingService.leaveSlot(slotNumber);
                    } else {
                        System.out.println("Invalid command format. Usage: leave <slot_number>");
                    }
                    break;
                case "status":
                    parkingService.printParkingStatus();
                    break;
                case "registration_numbers_for_cars_with_colour":
                    if (parts.length == 2) {
                        String color = parts[1];
                        parkingService.printRegistrationNumbersForColor(color);
                    } else {
                        System.out.println("Invalid command format. Usage: registration_numbers_for_cars_with_colour <color>");
                    }
                    break;
                case "slot_number_for_registration_number":
                    if (parts.length == 2) {
                        String registrationNumber = parts[1];
                        parkingService.printSlotNumberForRegistrationNumber(registrationNumber);
                    } else {
                        System.out.println("Invalid command format. Usage: slot_number_for_registration_number <registration_number>");
                    }
                    break;
                case "slot_numbers_for_cars_with_colour":
                    if (parts.length == 2) {
                        String color = parts[1];
                        parkingService.printSlotNumbersForColor(color);
                    } else {
                        System.out.println("Invalid command format. Usage: slot_numbers_for_cars_with_colour <color>");
                    }
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        ParkingController controller = new ParkingController();
        controller.start();
    }
}
