package com.charan.parkingsystem.display;

import com.charan.parkingsystem.Types;
import com.charan.parkingsystem.parking.ParkingFloor;

import java.util.List;

public interface DisplayStrategy {
    List<ParkingFloor> floorList = null;
    default void displayHelper(Types.DisplayType displayType, List<ParkingFloor> floorList) {
        switch (displayType) {
            case FREE_COUNT -> getFreeCount(floorList);
            case FREE_SLOTS -> getFreeSlots(floorList);
            case OCCUPIED_SLOTS -> getOccupiedSlots(floorList);
            default -> throw new IllegalStateException("Unexpected value: " + displayType);
        }

    }

    void getFreeSlots(List<ParkingFloor> floorList);

    void getFreeCount(List<ParkingFloor> floorList);

    void getOccupiedSlots(List<ParkingFloor> floorList);
}
