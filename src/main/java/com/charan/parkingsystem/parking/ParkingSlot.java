package com.charan.parkingsystem.parking;

import com.charan.parkingsystem.Types;

public class ParkingSlot {
    private int slotID;
    private Types.VehicleType spotType;
    private boolean isFree = true;


    public ParkingSlot(){
    }

    public ParkingSlot(int id, Types.VehicleType type){
        this.slotID = id;
        this.spotType = type;
    }

    public boolean getIsFree(){
        return isFree;
    }

    public void setOccupied(){
        isFree = false;
    }

    public Types.VehicleType getSpotType(){
        return spotType;
    }

    public void setSpotType(Types.VehicleType spotType){
        this.spotType = spotType;
    }

}
