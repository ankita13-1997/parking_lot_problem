package com.Ankita.Parking_Lot_TC;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class ParkingSlot {
    int slotNumber;
     vehicle vehicle;
    LocalDateTime entryTime;

    public ParkingSlot(int slotNumber, com.Ankita.Parking_Lot_TC.vehicle vehicle, LocalDateTime entryTime) {
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

    public vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    @Override
    public String toString() {
        return "ParkingSlot{" +
                "slotNumber=" + slotNumber +
                ", vehicle1='" + vehicle + '\'' +
                ", entryTime=" + entryTime +
                '}';
    }


}
