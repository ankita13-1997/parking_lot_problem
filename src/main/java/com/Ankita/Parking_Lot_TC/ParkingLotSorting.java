package com.Ankita.Parking_Lot_TC;

import java.util.ArrayList;
import java.util.List;

public interface ParkingLotSorting {
    ArrayList<Integer> getLocation(List<ParkingSlot> slots, ParkedVehicleAttribute parkedVehicleAttribute);
}
