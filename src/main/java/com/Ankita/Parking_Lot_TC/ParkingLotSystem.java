package com.Ankita.Parking_Lot_TC;




import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class ParkingLotSystem {
    Scanner sc = new Scanner(System.in);

    private int currentCapacity;

    HashSet<Integer> carLot1 = new HashSet<Integer>();
    int length = carLot1.size();
    private List<ParkingLotObserver> observer;
    private int actualCapapacity;
    public ArrayList<ParkingLot> parkingLotArrayList;

    private List vehicles;
    private boolean isPakringFull;
    private List<ParkingLot> CarsLots;


    public ParkingLotSystem(ParkingLot... parking) {
        this.parkingLotArrayList = new ArrayList<>();
        this.parkingLotArrayList.addAll(Arrays.asList(parking));
        this.observer = new ArrayList<>();
        this.vehicles = new ArrayList<>();
        this.currentCapacity = 0;


    }


    public ParkingLot getLot(ParkedVehicleDetails parkedVehicleDetails) throws ParkingLotException {
        ParkingLot parkingLot = parkedVehicleDetails.parkingType.parkingLotStatergies.getParkingLot(this.parkingLotArrayList);
        if (parkingLot.ParkingSLotList.stream().
                filter(parkingSlot -> parkingSlot.getVehicle() == null).count() == 0) {
            this.isPakringFull = true;
            throw new ParkingLotException("Parking Full", ParkingLotException.ExceptionType.PARKING_FULL);

        }

        this.isPakringFull = true;
        return parkingLot;
    }


    public boolean park_Vehicle(vehicle vehicle, ParkedVehicleDetails parkedVehicleDetails) throws ParkingLotException {
        return this.getLot(parkedVehicleDetails).park_vehicle_slot(vehicle, parkedVehicleDetails);

    }

    public boolean Unpark_Vehicle(vehicle vehicle, ParkedVehicleDetails parkedVehicleDetails) throws ParkingLotException {
        return this.getLot(parkedVehicleDetails).unPark(vehicle);

    }


    void registerParkingLotObserver(ParkingLotObserver observers) {
        this.observer.add(observers);

    }

    public void setCapacity(int capacity) {
        this.actualCapapacity = capacity;

    }

    public void park(Object vehicle) throws ParkingLotException {
        if (isVehicleParked(vehicle)) {
            throw new ParkingLotException("vehicle is already parked", ParkingLotException.ExceptionType.PARKING_FULL);
        }

        if (this.currentCapacity == this.actualCapapacity) {
            for (ParkingLotObserver observers : observer) {
                observers.capacityIsFull();
            }
            throw new ParkingLotException("Parking Lot has that vehicle", ParkingLotException.ExceptionType.VEHICLE_NOT_FOUND);
        }

        this.currentCapacity++;
        this.vehicles.add(vehicle);

    }

    public boolean isVehicleParked(Object vehicle) {

        if (this.vehicles.contains(vehicle)) {
            return true;
        }
        return false;
    }


    public void isVehiclePresentInLot(Object vehicle) throws ParkingLotException {
        if (vehicle == null) {
            throw new ParkingLotException("Vehicle is not present in The lot", ParkingLotException.ExceptionType.PARKING_FULL);
        }


    }

    public boolean unPark(Object vehicle) {

        if (vehicle != null) return false;
        if (this.vehicles.contains(vehicle)) {
            this.vehicles.remove(vehicle);
            for (ParkingLotObserver observers : observer) {
                observers.capacityIsAvailable();
            }
            return true;
        }

        return false;
    }

    public void lotCapacityNotFull(int size) throws ParkingLotException {
        if (size < 0) {
            throw new ParkingLotException("Parking Lot is not full", ParkingLotException.ExceptionType.VEHICLE_NOT_FOUND);
        }
    }

    public boolean lotCapacity(int size) {
        boolean isfull = true;
        if (size >= 0) {
            isfull = true;

        } else {
            isfull = false;
        }

        return isfull;


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


    public ArrayList<Integer> searchForHandicapeDriver(ParkedVehicleDetails parkedVehicleDetails3) {
        ArrayList<Integer> slotNumber=parkingLotArrayList.stream().filter(parkingLot -> parkingLot.
                ParkingSLotList.stream().map(ParkingSlot ::getSlotNumber).
                anyMatch( ParkingType ->ParkingType.equals(parkedVehicleDetails3))).findFirst().;


    }

}