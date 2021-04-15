package com.Ankita.Parking_Lot_TC;

import java.time.LocalTime;

public class ParkingSlot {
    int slotNumber;
    String vehicle;
    LocalTime entryTime;

    public ParkingSlot(int slotNumber, String vehicle, LocalTime entryTime) {
        this.slotNumber = slotNumber;
        this.vehicle = vehicle;
        this.entryTime = entryTime;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public LocalTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalTime entryTime) {
        this.entryTime = entryTime;
    }

    @Override
    public String toString() {
        return "ParkingSlot{" +
                "slotNumber=" + slotNumber +
                ", vehicle='" + vehicle + '\'' +
                ", entryTime=" + entryTime +
                '}';
    }
}
