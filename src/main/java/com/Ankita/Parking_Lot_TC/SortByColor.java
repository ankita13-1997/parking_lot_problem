package com.Ankita.Parking_Lot_TC;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SortByColor implements ParkingLotSorting{

    @Override
    public ArrayList<Integer> getLocation(List<ParkingSlot> slots, ParkedVehicleAttribute parkedVehicleAttribute) {
        return slots.stream().filter(parkingSlot -> parkingSlot.getVehicle() !=null &&
                parkingSlot.getVehicle().getCarColor().equals(parkedVehicleAttribute.color)).
                map(ParkingSlot::getSlotNumber).collect(Collectors.toCollection(ArrayList::new));
    }
}
