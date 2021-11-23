package com.charan.parkingsystem.vehicle;

import com.charan.parkingsystem.Types.VehicleType;
interface Vehicle {
    String getRegistrationNumber();

    String getColour();

    VehicleType getVehicleType();
}
