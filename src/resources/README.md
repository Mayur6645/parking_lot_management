# Parking Lot Management System

## Introduction
This application provides a parking lot management system that allows users to perform various operations such as parking a car, leaving a slot, and retrieving information about parked cars.

## Installation and Setup
1. Clone the repository to your local machine.
2. Open the project in IntelliJ IDEA or any other Java IDE.
3. Run the `ParkingController` class.
4. Follow the instructions in the command-line interface to interact with the parking lot system.

## Usage
- Use the following commands to interact with the system:
    - `create_parking_lot <capacity>`: Creates a parking lot with the specified capacity.
    - `park <registration_number> <color>`: Parks a car with the given registration number and color.
    - `leave <slot_number>`: Frees up the specified parking slot.
    - `registration_numbers_for_cars_with_colour <color>`: Retrieves the registration numbers of cars with the specified color.
    - `slot_number_for_registration_number <registration_number>`: Retrieves the slot number where a car with the specified registration number is parked.
    - `slot_numbers_for_cars_with_colour <color>`: Retrieves the slot numbers where cars with the specified color are parked.
    - `status`: Displays the current status of the parking lot.
    - `exit`: Exits the application.

## Contributing
Contributions are welcome! Feel free to submit a pull request if you have any improvements or suggestions.
