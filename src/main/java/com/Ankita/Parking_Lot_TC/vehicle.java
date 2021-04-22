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

    public String getOwner_FullNmae() {
        return owner_FullNmae;
    }

    public void setOwner_FullNmae(String owner_FullNmae) {
        this.owner_FullNmae = owner_FullNmae;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public ParkedVehicleAttribute.VehicleColor getCarColor() {
        return carColor;
    }

    public void setCarColor(ParkedVehicleAttribute.VehicleColor carColor) {
        this.carColor = carColor;
    }

    public ParkedVehicleAttribute.VehicleModel getCarModel() {
        return carModel;
    }

    public void setCarModel(ParkedVehicleAttribute.VehicleModel carModel) {
        this.carModel = carModel;
    }


}
