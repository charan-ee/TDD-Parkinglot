package com.charan.parkingsystem.strategy;

import com.charan.parkingsystem.parking.ParkingFloor;
import com.charan.parkingsystem.parking.ParkingSlot;
import com.charan.parkingsystem.parking.Ticket;
import com.charan.parkingsystem.vehicle.Vehicle;

import java.util.List;

public class CarStrategy implements ParkStrategy {

    public Ticket park(Vehicle vehicle, List<ParkingFloor> floorList){
        Ticket ticket = null;
        for (ParkingFloor floor : floorList) {
            for (ParkingSlot slot: floor.getFloorSlots()) {
                if (slot.getIsFree() && slot.getSlotID() > 3) {
                    slot.setOccupied();
                    ticket = new Ticket(floor, slot);
                    return ticket;
                }
            }
        }
        return ticket;
    }
}
