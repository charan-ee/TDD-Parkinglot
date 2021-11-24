package com.charan.parkingsystem.parking;

import com.charan.parkingsystem.Types.VehicleType;

import java.util.List;

public class ParkingFloor {
    private int floorNo;
    private List<ParkingSlot> floorSlots;
    private boolean isFull;
    private List<ParkingSlot> availableSlotsByType;

    public ParkingFloor(int floorNo, List<ParkingSlot> floorSlots ){
        this.floorNo = floorNo;
        this.floorSlots = floorSlots;
    }

    public boolean checkIsFull(){
        return isFull;
    }

    public List<ParkingSlot> findSlotsByType(VehicleType vehicleType){
        for(ParkingSlot slot: floorSlots){
            if(slot.getIsFree() && slot.getSpotType() == vehicleType){
                availableSlotsByType.add(slot);
            }
        }
        return availableSlotsByType;
    }

    public List<ParkingSlot> getFloorSlots() {
        return floorSlots;
    }
}
