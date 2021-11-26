package com.charan.parkingsystem.vehicle;

import com.charan.parkingsystem.Types;

public class Truck implements Vehicle {
    private final String registrationNumber;
    private final String colour;
    private Types.VehicleType vehicleType;

    public Truck(String regNum, String colour) {
        this.registrationNumber = regNum;
        this.colour = colour;
        this.vehicleType = Types.VehicleType.CAR;
    }

    @Override
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    @Override
    public String getColour() {
        return colour;
    }

    @Override
    public Types.VehicleType getVehicleType() {
        return vehicleType;
    }
}