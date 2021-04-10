package com.Ankita.Parking_Lot_TC;


import java.util.HashSet;

public class ParkingLotSystem {
    private Object vehicle ;
    HashSet<Integer> carLot1 =new HashSet<Integer>();
    int length = carLot1.size();


    public ParkingLotSystem() {
    }

    public void park(Object vehicle) throws ParkingLotException {
        if(this.vehicle!=null){
            throw  new ParkingLotException("Parking Lot has that vehicle");
        }
        this.vehicle=vehicle;

    }

    public boolean isVehicleParked(Object vehicle) {

        if(this.vehicle.equals(vehicle))
        {
            return true;
        }
        return false;
    }


    public void isVehiclePresentInLot(Object vehicle) throws ParkingLotException {
        if(vehicle==null)
        {
            throw new ParkingLotException("Vehicle is not present in The lot");
        }


    }

    public boolean unPark(Object vehicle) {

        if (vehicle!=null) {
            if (this.vehicle.equals(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public void lotCapacityNotFull(int size) throws ParkingLotException {
        if(size<0){
            throw new ParkingLotException("Parking Lot is not full");
        }
    }

    public boolean lotCapacity(int size) {
        boolean isfull=true;
        if(size>=0){
            isfull=true;

        }
        else {
            isfull=false;
        }

   return isfull;


    }
}
