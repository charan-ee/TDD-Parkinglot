package com.charan.parkingsystem.parking;

import com.charan.parkingsystem.Types;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingSlotTest {
    static ParkingSlot slot;
    @BeforeAll
    static void beforeAll() {
        slot = new ParkingSlot(1, Types.VehicleType.CAR);
    }

    @Test
    void getIsFreeTest() {
        slot.setOccupied();
        boolean status = slot.getIsFree();

        Assertions.assertFalse(status);
    }

    @Test
    void getSpotTypeTest() {
        Types.VehicleType type = slot.getSpotType();

        Assertions.assertEquals(Types.VehicleType.CAR, type);
    }
}