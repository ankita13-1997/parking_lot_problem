package com.Ankita.Parking_Lot_TC;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LargeVehicleStrategy implements ParkingLotStatergies{
    @Override
    public ParkingLot getParkingLot(ArrayList<ParkingLot> parkingLotArrayList) {
        for (ParkingLot parkingLot : parkingLotArrayList)
            for (int i = 1; i < parkingLot.ParkingSLotList.size(); i++)
                if (parkingLot.ParkingSLotList.get(i).getVehicle() == null && parkingLot.ParkingSLotList.get(i + 1).getVehicle() == null)
                     return parkingLot;
        return null;

        }

    @Override
    public Integer getParkingSlotList(List<ParkingSlot> parkingSlotList) {
        return (IntStream.range(0,parkingSlotList.size()).
                filter(i -> parkingSlotList.get(i).getVehicle()==null && parkingSlotList.get(i+1).getVehicle()==null).
                findFirst().orElse(1))+1;
    }



}
