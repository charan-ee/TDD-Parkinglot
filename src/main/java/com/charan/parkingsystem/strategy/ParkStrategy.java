package com.charan.parkingsystem.strategy;

import com.charan.parkingsystem.parking.ParkingFloor;
import com.charan.parkingsystem.parking.Ticket;
import com.charan.parkingsystem.vehicle.Vehicle;

import java.util.List;

public interface ParkStrategy {
    Ticket park(Vehicle vehicle, List<ParkingFloor> floorList);
}
