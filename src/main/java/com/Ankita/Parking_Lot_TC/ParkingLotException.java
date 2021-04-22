package com.Ankita.Parking_Lot_TC;

public class ParkingLotException extends Exception{
    public enum ExceptionType {
        PARKING_FULL, VEHICLE_NOT_FOUND
    }

    public ExceptionType type;

    public ParkingLotException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
