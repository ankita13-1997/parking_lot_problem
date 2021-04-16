package com.Ankita.Parking_Lot_TC;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    public int parkingLotCapacity;
    public List<ParkingSlot> ParkingSLotList =new ArrayList<ParkingSlot>() ;
    Object parkedVehicles =new Object();



    public ParkingLot(int lotCapacity) {
        this.parkingLotCapacity=lotCapacity;
        for (int i = 1 ; i < parkingLotCapacity; i++) {
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
}
