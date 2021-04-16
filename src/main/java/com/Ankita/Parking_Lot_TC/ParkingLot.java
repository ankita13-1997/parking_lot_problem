package com.Ankita.Parking_Lot_TC;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    public int parkingLotCapacity;
    public List<ParkingSlot> ParkingSLotList =new ArrayList<ParkingSlot>() ;
    Object parkedVehicles =new Object();
    Object parkedVehiclesHandicape =new Object();
    String user;
    public List<ParkingSlot> ParkingSLotListHandicape =new ArrayList<ParkingSlot>() ;



    public ParkingLot(int lotCapacity) {
        this.parkingLotCapacity=lotCapacity;
        for (int i = 0 ; i < parkingLotCapacity; i++) {
            ParkingSLotList.add(new ParkingSlot(i,null,null));
            parkedVehicles = ParkingSLotList.get(i).getVehicle1();
        }
        //System.out.println("Parking Lot");
        //ParkingSLotList.forEach(System.out::println);

    }


    public void park(Object vehicle) throws ParkingLotException{
        this.parkedVehicles=vehicle;
        if (isVehicleparkedInSlot(vehicle)){
            throw new ParkingLotException("vehicle is already parked");

        }

    }

    public boolean isVehicleparkedInSlot(Object vehicle) {
        this.parkedVehicles=vehicle;
        if (this.ParkingSLotList.contains(vehicle)){
            return true;
        }
        return true;

    }

    public boolean unPark(Object vehicle) {

       if(this.parkedVehicles !=null)
           return false;
       if(this.ParkingSLotList.contains(vehicle)){
           ParkingSLotList.remove(vehicle);
           return true;
       }
       return false;

    }

    public boolean isSpaceAvailable() {

        if(this.ParkingSLotList.size() <=parkingLotCapacity){
            return true;
        }
        return false;
    }

    public void HandicapeSlot(String handicape) {
        this.user=handicape;

        for (int i=0; i<parkingLotCapacity; i++){
            ParkingSLotListHandicape.add(new ParkingSlot(i,null,null));
            parkedVehiclesHandicape=ParkingSLotListHandicape.get(i).getVehicle1();
        }
    }

    public boolean isLotHaveHandicape_vehicle(Object vehicle) {
        this.parkedVehiclesHandicape=vehicle;
        if(this.ParkingSLotListHandicape.contains(vehicle)){
            return false;
        }
        return true;
    }
}
