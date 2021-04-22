package com.Ankita.Parking_Lot_TC;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class NormalStatergy implements ParkingLotStatergies{
    @Override
    public ParkingLot getParkingLot(ArrayList<ParkingLot> parkingLotArrayList) {
     ArrayList<ParkingLot> normalSlot = new ArrayList<>();
     normalSlot.addAll(parkingLotArrayList);
     normalSlot.sort(Comparator.comparing(parkingLot -> {
                     long count =parkingLot.ParkingSLotList.stream()
                     .filter(parkingSlot -> parkingSlot.getVehicle()==null).count();
                     return -count;

     }));
        return normalSlot.get(0);
    }


    @Override
    public Integer getParkingSlotList(List<ParkingSlot> parkingSlotList) {
        return (IntStream.range(0,parkingSlotList.size()).
                filter(i -> parkingSlotList.get(i).getVehicle()==null).
                findFirst().orElse(1))+1;
    }
}
