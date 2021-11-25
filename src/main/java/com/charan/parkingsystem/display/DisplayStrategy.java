package com.charan.parkingsystem.display;

import com.charan.parkingsystem.Types;
import com.charan.parkingsystem.parking.ParkingFloor;

import java.util.List;

public interface DisplayStrategy {
    List<ParkingFloor> floorList = null;
    void displayHelper(Types.DisplayType displayType, List<ParkingFloor> floorList);

    void getFreeSlots(List<ParkingFloor> floorList);

    void getFreeCount(List<ParkingFloor> floorList);

    void getOccupiedSlots(List<ParkingFloor> floorList);
}
