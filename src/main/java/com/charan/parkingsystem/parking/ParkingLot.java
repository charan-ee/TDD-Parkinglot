package com.charan.parkingsystem.parking;

import com.charan.parkingsystem.Types;
import com.charan.parkingsystem.display.BikeDisplay;
import com.charan.parkingsystem.display.CarDisplay;
import com.charan.parkingsystem.display.TruckDisplay;
import com.charan.parkingsystem.strategy.ParkStrategy;
import com.charan.parkingsystem.vehicle.Car;
import com.charan.parkingsystem.vehicle.Vehicle;

import java.util.*;

public class ParkingLot {
    private String id = "PR1234";
    private final int slotsPerFloor;
    private final int noOfFloors;
    private Map<Ticket, Vehicle> ticketVehicleMap = new HashMap<>();
    private List<ParkingFloor> floorList;

    private static ParkingLot instance;

    private ParkingLot(String id, int floors, int slotsPerFloor) {
        this.id = id;
        this.noOfFloors = floors;
        this.slotsPerFloor = slotsPerFloor;
        this.floorList = setFloorList();
    }

    private List<ParkingFloor> setFloorList() {
        List<ParkingSlot> slotsListOnFloor = createSlotList();
        for (int i = 1; i <= this.noOfFloors; i++) {
            ParkingFloor floor = new ParkingFloor(i, slotsListOnFloor);
            floorList.add(floor);
        }
        return floorList;
    }

    private List<ParkingSlot> createSlotList() {
        List<ParkingSlot> emptySlots = new ArrayList<>();
        for (int i = 1; i < this.slotsPerFloor; i++) {
            ParkingSlot slot = new ParkingSlot(i);
            emptySlots.add(slot);
        }
        return emptySlots;
    }

    public static ParkingLot getInstance() {
        if (instance == null) {
            throw new AssertionError("Call the init first");
        }
        return instance;
    }

    public static synchronized ParkingLot init(String id, int floors, int slots) {
        if (instance != null) {
            throw new AssertionError("Initialisation done already");
        }
        instance = new ParkingLot(id, floors, slots);
        return instance;
    }

    public boolean parkVehicle(ParkStrategy parkStrategy, Vehicle vehicle) {
        Types.VehicleType vehicleType = vehicle.getVehicleType();
        Ticket ticket = parkStrategy.park(vehicle, floorList);
        if (ticket != null) {
            ticket.setId(this.id + "_" + ticket.getFloorNo() + "_" + ticket.getSlot().getSlotID());
            ticketVehicleMap.put(ticket, vehicle);
            return true;
        }
        return false;
    }

    public boolean unParkVehicle(String ticketId) {
        List<Ticket> ticketList = new ArrayList<>(ticketVehicleMap.keySet());
        Ticket ticketToRemove = getTicketToRemove(ticketList, ticketId);
        if (ticketToRemove != null) {
            ticketToRemove.getSlot().setFree();
            Vehicle vehicle = ticketVehicleMap.get(ticketToRemove);
            System.out.println("Unparked vehicle with Registration Number: " + vehicle.getRegistrationNumber() + " and Color: " + vehicle.getColour());
            ticketVehicleMap.remove(ticketToRemove);
            return true;
        }
        System.out.println("Couldn't find the ticket/Vehicle with ID:" + ticketId);
        return false;
    }

    private Ticket getTicketToRemove(List<Ticket> ticketList, String ticketId) {
        for (Ticket ticket : ticketList) {
            if (Objects.equals(ticket.getId(), ticketId)) {
                return ticket;
            }
        }
        return null;
    }

    public void DisplaySlots(Types.DisplayType displayType, Types.VehicleType vehicleType){
        switch (vehicleType){
            case CAR -> {
                CarDisplay carDisplay = new CarDisplay();
                carDisplay.displayHelper(displayType, floorList);
            }
            case BIKE -> {
                BikeDisplay bikeDisplay = new BikeDisplay();
                bikeDisplay.displayHelper(displayType, floorList);
            }
            case TRUCK -> {
                TruckDisplay truckDisplay = new TruckDisplay();
                truckDisplay.displayHelper(displayType, floorList);
            }
        }
    }
}



