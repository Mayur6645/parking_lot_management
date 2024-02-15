package com.parking.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private final int capacity;
    private final Map<Integer, Car> parkingSlots;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        parkingSlots = new HashMap<>();
    }

    public int park(Car car) {
        for (int i = 1; i <= capacity; i++) {
            if (!parkingSlots.containsKey(i)) {
                parkingSlots.put(i, car);
                return i;
            }
        }
        return -1; // Parking lot is full
    }

    public boolean leave(int slotNumber) {
        if (!parkingSlots.containsKey(slotNumber)) {
            return false; // Slot is already empty
        }
        parkingSlots.remove(slotNumber);
        return true;
    }

    public List<String> getStatus() {
        List<String> status = new ArrayList<>();
        for (Map.Entry<Integer, Car> entry : parkingSlots.entrySet()) {
            status.add(String.format("%-12d%-19s%s", entry.getKey(), entry.getValue().getRegistrationNumber(), entry.getValue().getColor()));
        }
        return status;
    }

    public List<String> getRegistrationNumbersForCarsWithColor(String color) {
        List<String> registrationNumbers = new ArrayList<>();
        for (Car car : parkingSlots.values()) {
            if (car.getColor().equalsIgnoreCase(color)) {
                registrationNumbers.add(car.getRegistrationNumber());
            }
        }
        return registrationNumbers;
    }

    public int getSlotNumberForRegistrationNumber(String registrationNumber) {
        for (Map.Entry<Integer, Car> entry : parkingSlots.entrySet()) {
            if (entry.getValue().getRegistrationNumber().equalsIgnoreCase(registrationNumber)) {
                return entry.getKey();
            }
        }
        return -1; // Not found
    }

    public List<Integer> getSlotNumbersForCarsWithColor(String color) {
        List<Integer> slotNumbers = new ArrayList<>();
        for (Map.Entry<Integer, Car> entry : parkingSlots.entrySet()) {
            if (entry.getValue().getColor().equalsIgnoreCase(color)) {
                slotNumbers.add(entry.getKey());
            }
        }
        return slotNumbers;
    }
}
