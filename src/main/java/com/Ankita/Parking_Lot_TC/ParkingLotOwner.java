package com.Ankita.Parking_Lot_TC;

public class ParkingLotOwner {
    private boolean isFullCapacity=true;

    public void capacityIsFull() {
        isFullCapacity=true;
    }

    public boolean isCapacityFull() {
        return  this.isFullCapacity;
    }
}
