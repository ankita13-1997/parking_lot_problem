package com.Ankita.Parking_Lot_TC;



public class ParkingLotSystem {
    private Object vehicle ;

    public ParkingLotSystem() {
    }

    public boolean park(Object vehicle) {
        this.vehicle=vehicle;
        return true;
    }

    public boolean unPark(Object vehicle) {

        if(this.vehicle.equals(vehicle)){
            return true;
        }
        return false;
    }
}
