package com.Ankita.Parking_Lot_TC;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class ParkingLot {
    public int parkingLotCapacity;
    List<ParkingSlot> ParkingSLotList = new ArrayList<ParkingSlot>();
    Object parkedVehicles = new Object();


    public ParkingLot(int lotCapacity) {
        this.parkingLotCapacity = lotCapacity;
        for (int i = 1; i < parkingLotCapacity; i++) {
            ParkingSLotList.add(new ParkingSlot(i, null, null));

        }

    }



    public boolean unPark(vehicle v1) throws ParkingLotException {

        int searchedVehicle = searchVehicle(v1);
        ParkingSLotList.get(searchedVehicle - 1).setVehicle(null);
        ParkingSLotList.get(searchedVehicle - 1).setEntryTime(null);
        return true;


    }


    public boolean park_vehicle_slot(vehicle vehicle, ParkedVehicleDetails parkedVehicleDetails) throws ParkingLotException {
        int slot = parkedVehicleDetails.parkingType.parkingLotStatergies.getParkingSlotList(ParkingSLotList);
        if (slot == 0)
            throw new ParkingLotException("Parking Lot Full", ParkingLotException.ExceptionType.PARKING_FULL);
        ParkingSLotList.get(slot - 1).setVehicle(vehicle);
        ParkingSLotList.get(slot - 1).setEntryTime(LocalDateTime.now());
        return true;
    }


    public int searchVehicle(vehicle v1) throws ParkingLotException {
        ParkingSlot slot = this.ParkingSLotList.stream().
                filter(ps -> v1.equals(ps.getVehicle())).findFirst()
                .orElseThrow(() -> new ParkingLotException("Vehicle is not in the lot",
                        ParkingLotException.ExceptionType.VEHICLE_NOT_FOUND));

        return slot.getSlotNumber();
    }

    public ArrayList<ParkingSlot> getAllVehicleInSlot() {
        return ParkingSLotList.stream()
                .filter(parkingSlot -> parkingSlot.getVehicle() != null)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<vehicle> vehicleParkedBefore30min() {
        return this.ParkingSLotList.stream()
                .filter(parkingSlot -> parkingSlot.getVehicle() != null &&
                        (parkingSlot.getEntryTime().getMinute() - LocalTime.now().getMinute() <= 30)).
                        map(ParkingSlot::getVehicle).
                        collect(Collectors.toCollection(ArrayList::new));
    }


    public List<Integer> searchforHandicap(ParkedVehicleDetails parkedVehicleDetails3) {

           return this.ParkingSLotList.stream().filter(ParkingSlot -> ParkingSlot.getVehicle() !=null).
                    filter(ParkedVehicleDetails -> ParkedVehicleDetails.equals(parkedVehicleDetails3)).
                    map(ParkingSlot ::getSlotNumber).
                    collect(Collectors.toCollection(ArrayList::new));



    }

    public List<Integer> getParkedVehicleInSlot(ParkingSlotSorting sorting, ParkedVehicleAttribute parkedVehicleAttribute){
      return sorting.sorting.getLocation(this.ParkingSLotList,parkedVehicleAttribute);
    }
}





