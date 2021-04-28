package com.Ankita.Parking_Lot_TC;


import java.util.*;
import java.util.stream.Collectors;

public class ParkingLotSystem {
    
    public ArrayList<ParkingLot> parkingLotArrayList;
    public boolean isPakringFull;
    public Observers observers;

    public ParkingLotSystem(ParkingLot... parking) {
        this.parkingLotArrayList = new ArrayList<>();
        this.parkingLotArrayList.addAll(Arrays.asList(parking));
        this.observers = new Observers();

    }


    public ParkingLot getLot(ParkedVehicleDetails parkedVehicleDetails) throws ParkingLotException {
        ParkingLot parkingLot = parkedVehicleDetails.parkingType.parkingLotStatergies.getParkingLot(this.parkingLotArrayList);
        if (parkingLot.ParkingSLotList.stream().
                filter(parkingSlot -> parkingSlot.getVehicle() == null).count() == 0) {
            this.isPakringFull = true;
            throw new ParkingLotException("Parking Lot System Full", ParkingLotException.ExceptionType.PARKING_FULL);

        }

        this.isPakringFull = false;
        return parkingLot;
    }


    public boolean park_Vehicle(vehicle vehicle, ParkedVehicleDetails parkedVehicleDetails) throws ParkingLotException {
        observers.informAllStatus(this.isPakringFull);
        return this.getLot(parkedVehicleDetails).park_vehicle_slot(vehicle, parkedVehicleDetails);

    }


    public boolean unPark(vehicle vehicle, ParkedVehicleDetails parkedVehicleDetails) throws ParkingLotException {
        observers.informAllStatus(this.isPakringFull);
        return this.getLot(parkedVehicleDetails).unPark(vehicle);
    }



    public ParkingLot search_Vehicle(vehicle vehicle) throws ParkingLotException {
        return this.parkingLotArrayList.stream()
                .filter(parkingLot -> parkingLot.ParkingSLotList.stream()
                        .map(ParkingSlot::getVehicle)
                        .anyMatch(vehicle1 -> vehicle1 == vehicle)).findFirst()
                .orElseThrow(() -> new ParkingLotException("Vehicle not found", ParkingLotException.ExceptionType.VEHICLE_NOT_FOUND));
    }

    public ArrayList<ArrayList<ParkingSlot>> getAllVehicleListInLot() {
        return this.parkingLotArrayList.stream().map(ParkingLot::getAllVehicleInSlot)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<ArrayList<ParkingSlot>> vehicleParkedInSystemBefore30min() {
        return this.parkingLotArrayList.stream().map(ParkingLot::getAllVehicleInSlot)
                .collect(Collectors.toCollection(ArrayList::new));
    }


    public ArrayList<List<Integer>> searchForHandicapeDriver(ParkedVehicleDetails parkedVehicleDetails3) {
        return parkingLotArrayList.stream().map(parkingLot -> parkingLot.searchforHandicap(parkedVehicleDetails3)).
                collect(Collectors.toCollection(ArrayList::new));

    }


    public ArrayList<List<Integer>> getLotList(ParkingSlotSorting sorting, ParkedVehicleAttribute parkedVehicleAttribute) {
        return parkingLotArrayList.stream().map(parkingLot ->
                parkingLot.getParkedVehicleInSlot(sorting, parkedVehicleAttribute)).
                collect(Collectors.toCollection(ArrayList :: new));
    }
}
