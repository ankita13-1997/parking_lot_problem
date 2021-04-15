package com.Ankita.Parking_Lot_TC;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ParkingLotSystem {
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private  int currentCapacity;

    HashSet<Integer> carLot1 =new HashSet<Integer>();
    int length = carLot1.size();
    private List<ParkingLotObserver> observer;
    private int actualCapapacity;
    public ArrayList<ParkingLot> parkingLotArrayList;

    private List vehicles;


    public ParkingLotSystem(ParkingLot...parking) throws ParseException {
        this.parkingLotArrayList=new ArrayList<>();
        this.parkingLotArrayList.addAll(Arrays.asList(parking));
        this.observer=new ArrayList<>();
        this.vehicles=new ArrayList<>();
        this.currentCapacity=0;



    }




    public  void registerParkingLotObserver(ParkingLotObserver observers) {
        this.observer.add(observers);

    }

    public void setCapacity(int capacity) {
        this.actualCapapacity=capacity;

    }

    public void park(Object vehicle) throws ParkingLotException {
        if(isVehicleParked(vehicle)){
            throw new ParkingLotException("vehicle is already parked");
        }

        if(this.currentCapacity==this.actualCapapacity){
            for (ParkingLotObserver observers:observer) {
                observers.capacityIsFull();
            }
            throw  new ParkingLotException("Parking Lot has that vehicle");
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

        if (vehicle!=null) return false;
            if (this.vehicles.contains(vehicle)) {
                this.vehicles.remove(vehicle);
                for (ParkingLotObserver observers:observer) {
                    observers.capacityIsAvailable();
                }
                return true;
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
