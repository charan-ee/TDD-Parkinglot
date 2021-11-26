package com.charan.parkingsystem.strategy;

import com.charan.parkingsystem.parking.ParkingFloor;
import com.charan.parkingsystem.parking.ParkingSlot;
import com.charan.parkingsystem.parking.Ticket;
import com.charan.parkingsystem.vehicle.Vehicle;

import java.util.List;

public class BikeStrategy implements ParkStrategy {
    int start = 2;
    int end = 3;
    public Ticket park(Vehicle vehicle, List<ParkingFloor> floorList) {

        Ticket ticket = null;
        for (ParkingFloor floor : floorList) {
            for (ParkingSlot slot: floor.getFloorSlots()) {
                if (slot.getIsFree() && slot.getSlotID() >= start && slot.getSlotID() <= end) {
                    slot.setOccupied();
                    ticket = new Ticket(floor, slot);
                    return ticket;
                }
            }
        }
        return ticket;
    }
}
