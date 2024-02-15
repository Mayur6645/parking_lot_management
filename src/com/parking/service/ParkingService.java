package com.parking.service;

import com.parking.model.Car;
import com.parking.model.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingService {
    private ParkingLot parkingLot;

    public void createParkingLot(int capacity) {
        parkingLot = new ParkingLot(capacity);
        System.out.println("Created a parking lot with " + capacity + " slots");
    }

    public void parkCar(String registrationNumber, String color) {
        if (parkingLot == null) {
            System.out.println("Parking lot has not been created yet.");
            return;
        }
        int slotNumber = parkingLot.park(new Car(registrationNumber, color));
        if (slotNumber != -1) {
            System.out.println("Allocated slot number: " + slotNumber);
        } else {
            System.out.println("Sorry, parking lot is full");
        }
    }

    public void leaveSlot(int slotNumber) {
        if (parkingLot == null) {
            System.out.println("Parking lot has not been created yet.");
            return;
        }
        if (parkingLot.leave(slotNumber)) {
            System.out.println("Slot number " + slotNumber + " is free");
        } else {
            System.out.println("Slot number " + slotNumber + " is already empty");
        }
    }

    public void printParkingStatus() {
        if (parkingLot == null) {
            System.out.println("Parking lot has not been created yet.");
            return;
        }
        System.out.println("Slot No.    Registration No    Colour");
        parkingLot.getStatus().forEach(System.out::println);
    }

    public void printRegistrationNumbersForColor(String color) {
        if (parkingLot == null) {
            System.out.println("Parking lot has not been created yet.");
            return;
        }
        List<String> registrationNumbers = parkingLot.getRegistrationNumbersForCarsWithColor(color);
        if (!registrationNumbers.isEmpty()) {
            System.out.println(String.join(", ", registrationNumbers));
        } else {
            System.out.println("Not found");
        }
    }

    public void printSlotNumberForRegistrationNumber(String registrationNumber) {
        if (parkingLot == null) {
            System.out.println("Parking lot has not been created yet.");
            return;
        }
        int slotNumber = parkingLot.getSlotNumberForRegistrationNumber(registrationNumber);
        if (slotNumber != -1) {
            System.out.println(slotNumber);
        } else {
            System.out.println("Not found");
        }
    }

    public void printSlotNumbersForColor(String color) {
        if (parkingLot == null) {
            System.out.println("Parking lot has not been created yet.");
            return;
        }
        List<Integer> slotNumbers = parkingLot.getSlotNumbersForCarsWithColor(color);
        if (!slotNumbers.isEmpty()) {
            slotNumbers.forEach(System.out::println);
        } else {
            System.out.println("Not found");
        }
    }
}
