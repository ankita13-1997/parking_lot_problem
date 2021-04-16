package com.Ankita.Parking_Lot_TC;

import java.time.LocalTime;

public class ParkingSlot {
    int slotNumber;
    Object vehicle1=new Object();
    LocalTime entryTime;

    public ParkingSlot(int slotNumber, Object vehicle1, LocalTime entryTime) {
        this.slotNumber = slotNumber;
        this.vehicle1 = vehicle1;
        this.entryTime = entryTime;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public Object getVehicle1() {
        return vehicle1;
    }

    public void setVehicle1(Object vehicle1) {
        this.vehicle1 = vehicle1;
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
                ", vehicle1='" + vehicle1 + '\'' +
                ", entryTime=" + entryTime +
                '}';
    }
}
