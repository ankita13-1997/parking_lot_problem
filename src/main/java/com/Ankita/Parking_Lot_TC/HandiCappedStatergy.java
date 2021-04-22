package com.Ankita.Parking_Lot_TC;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class HandiCappedStatergy implements ParkingLotStatergies{
    @Override
    public ParkingLot getParkingLot(ArrayList<ParkingLot> parkingLotArrayList) {
        for (ParkingLot parkingLot : parkingLotArrayList){
            for (ParkingSlot parkingSlot : parkingLot.ParkingSLotList){
                if(parkingSlot.getVehicle()==null){
                    return parkingLot;
                }
            }
        }
        return null;
    }

    @Override
    public Integer getParkingSlotList(List<ParkingSlot> parkingSlotList) {
        return (IntStream.range(0,parkingSlotList.size()).
                filter(i -> parkingSlotList.get(i).getVehicle()==null).
                findFirst().orElse(1))+1;
    }
}
