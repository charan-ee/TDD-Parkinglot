package com.charan.parkingsystem.vehicle;

import com.charan.parkingsystem.Types.VehicleType;

public interface Vehicle {
    String getRegistrationNumber();

    String getColour();

    VehicleType getVehicleType();
}
