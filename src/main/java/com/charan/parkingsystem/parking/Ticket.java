package com.charan.parkingsystem.parking;

public class Ticket {
    private String id;
    private final ParkingFloor floor;
    private final ParkingSlot slot;

    public Ticket(ParkingFloor floor, ParkingSlot slot) {
        this.floor = floor;
        this.slot = slot;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFloorNo(){
        return floor.getFloorNo();
    }

    public ParkingSlot getSlot() {
        return slot;
    }
}
