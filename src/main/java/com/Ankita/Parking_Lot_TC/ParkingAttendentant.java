package com.Ankita.Parking_Lot_TC;

public class ParkingAttendentant implements ParkingLotObserver{
    @Override
    public boolean capacityIsFull(boolean isParkingFull) {
        return isParkingFull;
    }
}
