package com.charan.parkingsystem.parking;

import com.charan.parkingsystem.strategy.CarStrategy;
import com.charan.parkingsystem.vehicle.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    static ParkingLot lot;

    @BeforeAll
    static void beforeAll() {
        lot = ParkingLot.init("PR1234", 1, 4);
    }

    @Test
    void initTest() {
        ParkingLot expected = ParkingLot.getInstance();
        System.out.println(expected.toString());
        Assertions.assertEquals(expected, lot);
    }

    @Test
    void parkVehicleTest() {
        boolean isPark;
        boolean noPark;
        Car car = new Car("KA-EF", "blue");
        Car carTwo = new Car("KA-EE", "black");
        isPark = lot.parkVehicle(new CarStrategy(), car);
        noPark = lot.parkVehicle(new CarStrategy(), carTwo);

        assertTrue(isPark);
        assertFalse(noPark);
    }

    @Test
    void unParkVehicleTest() {
        boolean isUnPark;
        Car car = new Car("KA-EF", "blue");
        lot.parkVehicle(new CarStrategy(), car);
        isUnPark = lot.unParkVehicle("PR1234_1_4");

        assertTrue(isUnPark);
    }
}