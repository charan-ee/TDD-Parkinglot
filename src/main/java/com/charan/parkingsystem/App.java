package com.charan.parkingsystem;

import com.charan.parkingsystem.parking.ParkingLot;
import com.charan.parkingsystem.strategy.BikeStrategy;
import com.charan.parkingsystem.strategy.CarStrategy;
import com.charan.parkingsystem.strategy.TruckStrategy;
import com.charan.parkingsystem.vehicle.Bike;
import com.charan.parkingsystem.vehicle.Car;
import com.charan.parkingsystem.vehicle.Truck;

import java.util.Scanner;

public class App {
    private static ParkingLot parkingLot;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String input_command;
        String[] commands;

        while (true) {
            input_command = input.nextLine();
            commands = input_command.split(" ");
            if (input_command.equals("q")) {
                break;
            }

            switch (commands[0]) {
                case "create_parking_lot" -> {
                    parkingLot = ParkingLot.init("PR1234", Integer.parseInt(commands[1]), Integer.parseInt(commands[2]));
                    System.out.println(parkingLot.toString());

                }
                case "display" -> {
                    parkingLot.DisplaySlots(Types.DisplayType.valueOf(commands[1].toUpperCase()), Types.VehicleType.valueOf(commands[2].toUpperCase()));
                }
                case "park_vehicle" -> {
                    if (commands[1].toUpperCase().equals("CAR")) {
                        Car car = new Car(commands[2], commands[3]);
                        parkingLot.parkVehicle(new CarStrategy(), car);
                    } else if (commands[1].toUpperCase().equals("BIKE")) {
                        Bike bike = new Bike(commands[2], commands[3]);
                        parkingLot.parkVehicle(new BikeStrategy(), bike);
                    } else if (commands[1].toUpperCase().equals("TRUCK")) {
                        Truck truck = new Truck(commands[2], commands[3]);
                        parkingLot.parkVehicle(new TruckStrategy(), truck);
                    }
                }
                case "unpark_vehicle" -> {
                    parkingLot.unParkVehicle(commands[1].toUpperCase());
                }
                default -> System.out.println("Please enter the right command (Enter 'q' to exit the terminal)" );
            }
        }
    }
}
