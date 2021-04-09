package com.Ankita.Parking_Lot_TC;



public class ParkingLotSystem {
    private Object vehicle ;

    public ParkingLotSystem() {
    }

    public void park(Object vehicle) throws ParkingLotException {
        if(this.vehicle!=null){
            throw  new ParkingLotException("Parking Lot is full");
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


    public void mist(Object vehicle) throws ParkingLotException {
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


}
