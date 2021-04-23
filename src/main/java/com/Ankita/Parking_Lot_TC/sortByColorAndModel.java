package com.Ankita.Parking_Lot_TC;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class sortByColorAndModel implements ParkingLotSorting{
    @Override
    public ArrayList<Integer> getLocation(List<ParkingSlot> slots, ParkedVehicleAttribute parkedVehicleAttribute) {
        return slots.stream().filter(slot -> slot.getVehicle() != null
                && slot.getVehicle().getCarColor().equals(parkedVehicleAttribute.color)
                && slot.getVehicle().getCarModel().equals(parkedVehicleAttribute.model)).
                map(ParkingSlot::getSlotNumber).collect(Collectors.toCollection(ArrayList :: new));
    }
}
