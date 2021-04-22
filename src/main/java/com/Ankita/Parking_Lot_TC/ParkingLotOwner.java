package com.Ankita.Parking_Lot_TC;

public class ParkingLotOwner implements ParkingLotObserver {
    public boolean isFullCapacity;
    @Override
    public void capacityIsFull() {
        isFullCapacity=true;
    }

    @Override
    public void capacityIsAvailable() {
        isFullCapacity=false;

    }

    public boolean isCapacityFull() {
        return  this.isFullCapacity;
    }
}
