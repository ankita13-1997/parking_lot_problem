package com.Ankita.Parking_Lot_TC;

public class AirPortSecurity implements ParkingLotObserver {


    @Override
    public boolean capacityIsFull(boolean isParkingFull) {
        return isParkingFull;
    }
}
