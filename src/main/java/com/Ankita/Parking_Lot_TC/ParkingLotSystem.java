package com.Ankita.Parking_Lot_TC;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ParkingLotSystem {

    private  int currentCapacity;
    HashSet<Integer> carLot1 =new HashSet<Integer>();
    int length = carLot1.size();
    private ParkingLotOwner owner;
    private int actualCapapacity;

    private List vehicles;
    private AirPortSecurity security;

    public ParkingLotSystem(int capacity) {
        this.vehicles=new ArrayList<>();
        this.currentCapacity=0;
        this.actualCapapacity=capacity;
    }

    public  void registerOwner(ParkingLotOwner owner) {
        this.owner=owner;

    }

    public void registerSecurity(AirPortSecurity airPortSecurity) {
        this.security=airPortSecurity;

    }

    public void setCapacity(int capacity) {
        this.actualCapapacity=capacity;

    }

    public void park(Object vehicle) throws ParkingLotException {
        if(this.currentCapacity==this.actualCapapacity){
            owner.capacityIsFull();
            security.capacityIsFull();
            throw  new ParkingLotException("Parking Lot is that vehicle");
        }
        if(isVehicleParked(vehicle)){
            throw new ParkingLotException("vehicle is already parked");

        }
        this.currentCapacity++;
        this.vehicles.add(vehicle);

    }

    public boolean isVehicleParked(Object vehicle) {

        if(this.vehicles.contains(vehicle))
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
            if (this.vehicles.contains(vehicle)) {
                this.vehicles.remove(vehicle);
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
