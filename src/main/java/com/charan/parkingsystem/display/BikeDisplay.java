package com.charan.parkingsystem.display;

import com.charan.parkingsystem.Types;
import com.charan.parkingsystem.parking.ParkingFloor;
import com.charan.parkingsystem.parking.ParkingSlot;

import java.util.ArrayList;
import java.util.List;

public class BikeDisplay implements DisplayStrategy {
    int start = 1;
    int end = 2;
    @Override
    public void getFreeCount(List<ParkingFloor> floors) {
        for (ParkingFloor floor : floors) {
            int count = 0;
            List<ParkingSlot> slots = floor.getFloorSlots();
            for (int i = start; i <= end; i++) {
                ParkingSlot slotToCheck = slots.get(i);
                if (slotToCheck.getIsFree()) {
                    count++;
                }
            }
            System.out.println("No. of free slots for BIKE on Floor " + floor.getFloorNo() + ": " + count);
        }

    }

    @Override
    public void getFreeSlots(List<ParkingFloor> floors) {
        for (ParkingFloor floor : floors) {
            List<ParkingSlot> slots = floor.getFloorSlots();
            ArrayList<Integer> tempFreeSlots = new ArrayList<>();
            for (int i = start; i <= end; i++) {
                ParkingSlot slot = slots.get(i);
                if (slot.getIsFree()) {
                    tempFreeSlots.add(slot.getSlotID());
                }
            }
            System.out.println("Free slots for BIKE on Floor " + floor.getFloorNo() + ": " + tempFreeSlots);
        }

    }

    @Override
    public void getOccupiedSlots(List<ParkingFloor> floors) {
        for (ParkingFloor floor : floors) {
            List<ParkingSlot> slots = floor.getFloorSlots();
            ArrayList<Integer> tempOccupiedSlots = new ArrayList<>();
            for (int i = start; i <= end; i++) {
                ParkingSlot slot = slots.get(i);
                if (!slot.getIsFree()) {
                    tempOccupiedSlots.add(slot.getSlotID());
                }
            }
            System.out.println("Occupied slots for BIKE on Floor " + floor.getFloorNo() + ": " + tempOccupiedSlots);
        }

    }
}
