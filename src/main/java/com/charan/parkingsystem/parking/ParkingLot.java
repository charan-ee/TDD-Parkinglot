package com.charan.parkingsystem.parking;

public class ParkingLot {
    private String id = "PR1234";
    private int slotsPerFloor;
    private int noOfFloors;

    private static ParkingLot instance;

    private ParkingLot(String id, int floors, int slotsPerFloor){
        this.id = id;
        this.noOfFloors = floors;
        this.slotsPerFloor = slotsPerFloor;
    }

    public static ParkingLot getInstance(){
        if(instance == null){
            throw new AssertionError("Call the init first");
        }
        return instance;
    }
    public static synchronized ParkingLot init(String id, int floors, int slots){
        if(instance != null){
            throw new AssertionError("Initialisation done already");
        }
        instance = new ParkingLot(id, floors, slots);
        return instance;
    }

}



