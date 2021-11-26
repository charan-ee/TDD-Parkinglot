package com.charan.parkingsystem.strategy;

import com.charan.parkingsystem.parking.ParkingFloor;
import com.charan.parkingsystem.parking.ParkingSlot;
import com.charan.parkingsystem.parking.Ticket;
import com.charan.parkingsystem.vehicle.Vehicle;

import java.util.List;

public class TruckStrategy implements ParkStrategy {
    public Ticket park(Vehicle vehicle, List<ParkingFloor> floorList) {
        int start = 1;
        int end = 1;
        Ticket ticket = null;
        for (ParkingFloor floor : floorList) {
            for (ParkingSlot slot: floor.getFloorSlots()) {
                if (slot.getIsFree() && slot.getSlotID() == start) {
                    slot.setOccupied();
                    ticket = new Ticket(floor, slot);
                    return ticket;
                }
            }
        }
        return ticket;
    }
}

