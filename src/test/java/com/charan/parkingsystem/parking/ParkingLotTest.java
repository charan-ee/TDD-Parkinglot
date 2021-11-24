package com.charan.parkingsystem.parking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {


    @Test
    void initTest() {
        ParkingLot lot = ParkingLot.init("PR1234", 3, 4);
        ParkingLot expected = ParkingLot.getInstance();
        System.out.println(expected.toString());
        Assertions.assertEquals(expected, lot);
    }


}