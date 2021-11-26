package com.charan.parkingsystem.parking;

import com.charan.parkingsystem.Types;

public class ParkingSlot {
    private final int slotID;
    private Types.VehicleType spotType;
    private boolean isFree = true;

    public ParkingSlot(int id) {
        this.slotID = id;
    }

    public ParkingSlot(int id, Types.VehicleType type) {
        this.slotID = id;
        this.spotType = type;
    }

    public int getSlotID() {
        return slotID;
    }

    public boolean getIsFree() {
        return isFree;
    }

    public void setFree() {
        isFree = true;
    }

    public void setOccupied() {
        isFree = false;
    }

    public Types.VehicleType getSpotType() {
        return spotType;
    }

    public void setSpotType(Types.VehicleType spotType) {
        this.spotType = spotType;
    }

}
