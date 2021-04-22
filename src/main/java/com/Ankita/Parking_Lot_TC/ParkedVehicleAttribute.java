package com.Ankita.Parking_Lot_TC;

public class ParkedVehicleAttribute {
    public VehicleModel model;
    public VehicleColor color;

    public enum VehicleModel{
        BMW,TOYOTA,OTHER;
    }

    public enum VehicleColor{
        White,blue,red,other;
    }

    public ParkedVehicleAttribute(VehicleModel model, VehicleColor color) {
        this.model = model;
        this.color = color;
    }
}
