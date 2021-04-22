package com.Ankita.Parking_Lot_TC;




    public enum ParkingType {
    NORMAL(new NormalStatergy()),
    HANDICAPPED(new HandiCappedStatergy()),
    LARGE(new LargeVehicleStrategy());



    public ParkingLotStatergies parkingLotStatergies;

    ParkingType(ParkingLotStatergies parkingLotStatergies) {
        this.parkingLotStatergies = parkingLotStatergies;
    }



}
