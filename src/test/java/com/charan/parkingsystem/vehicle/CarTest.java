package com.charan.parkingsystem.vehicle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @BeforeEach
    void setUp() {
//        Car car = new Car("TS-00-EF", "black");
    }

    @Test
    public void testGetRegistrationNumber(){
        Car car = new Car("TS-00-EF", "black");
        String regNum = car.getRegistrationNumber();

        Assertions.assertEquals("TS-00-EF", regNum);
    }

    @Test
    public void testGetColour(){
        String expected = "black";
        Car car = new Car("TS-00-EF", expected);
        String colour = car.getColour();

        Assertions.assertEquals(expected, colour);
    }
}