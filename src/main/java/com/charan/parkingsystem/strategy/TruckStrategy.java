package com.charan.parkingsystem.strategy;

import com.charan.parkingsystem.parking.ParkingFloor;
import com.charan.parkingsystem.parking.ParkingSlot;
import com.charan.parkingsystem.parking.Ticket;
import com.charan.parkingsystem.vehicle.Vehicle;

import java.util.List;

public class TruckStrategy implements ParkStrategy {
    public Ticket park(Vehicle vehicle, List<ParkingFloor> floorList) {
        Ticket ticket = null;
        for (int i = 0; i < floorList.size(); i++) {
            ParkingFloor floor = floorList.get(i);
            List<ParkingSlot> slotsInFloor = floor.getFloorSlots();
            for (int j = 1; j <= 1; j++) {
                ParkingSlot slot = slotsInFloor.get(j);
                if (slot.getIsFree()) {
                    slot.setOccupied();
                    ticket = new Ticket(floor, slot);
                    return ticket;
                }
            }
        }
        return ticket;
    }
}

