package com.Ankita.Parking_Lot_TC;

public class vehicle {

    private String owner_FullNmae;
    private String carNumber;

    private ParkedVehicleAttribute.VehicleColor carColor;
    private ParkedVehicleAttribute.VehicleModel carModel;


    public vehicle(String owner_FullNmae, String carNumber,
                   ParkedVehicleAttribute.VehicleColor carColor,
                   ParkedVehicleAttribute.VehicleModel carModel) {
        this.owner_FullNmae = owner_FullNmae;
        this.carNumber = carNumber;
        this.carColor = carColor;
        this.carModel = carModel;
    }


    public ParkedVehicleAttribute.VehicleColor getCarColor() {
        return carColor;
    }

    public ParkedVehicleAttribute.VehicleModel getCarModel() {
        return carModel;
    }




}
