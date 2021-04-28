package com.Ankita.Parking_Lot_TC;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class ParkingLotObserVerNotifiaction {

    @Rule
    public MockitoRule mockitoRule= MockitoJUnit.rule();

    public ParkingLotSystem parkingLotSystem;


    public ParkingLot parkingLot0;

    public ParkedVehicleDetails parkedVehicleDetails1;
    public ParkedVehicleDetails parkedVehicleDetails2;
    public ParkedVehicleDetails parkedVehicleDetails3;

    public vehicle v1;
    public vehicle v2;

    @Before
    public void setUp(){
        parkingLotSystem = new ParkingLotSystem();
        v1=new vehicle("Abhaya","OD231040",
                ParkedVehicleAttribute.VehicleColor.blue,
                ParkedVehicleAttribute.VehicleModel.TOYOTA);

        v2=new vehicle("Ankita","DL15623",
                ParkedVehicleAttribute.VehicleColor.red,
                ParkedVehicleAttribute.VehicleModel.BMW);

        parkingLot0=new ParkingLot(3);
        parkingLotSystem = new ParkingLotSystem(parkingLot0);

        parkedVehicleDetails1 =new ParkedVehicleDetails(ParkingType.HANDICAPPED);
        parkedVehicleDetails2=new ParkedVehicleDetails(ParkingType.NORMAL);
        parkedVehicleDetails3=new ParkedVehicleDetails(ParkingType.LARGE);

    }

    @Test
    public void givenVehicleToPark_And_WhenParkingIsFull_Should_Inform_Observers() {
        try {
            parkingLotSystem.park_Vehicle(v1,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v2,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v1,parkedVehicleDetails2);
            boolean parkingStatus=parkingLotSystem.isPakringFull;
            Assert.assertTrue(parkingStatus);

        } catch (ParkingLotException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void givenVehicleToUnPark_And_WhenParkingIsFull_Should_Inform_Observers(){
        try {
            parkingLotSystem.park_Vehicle(v1,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v2,parkedVehicleDetails2);
            parkingLotSystem.unPark(v1,parkedVehicleDetails2);

            boolean parkingStatus=parkingLotSystem.isPakringFull;
            Assert.assertFalse(parkingStatus);

        } catch (ParkingLotException e) {
            e.printStackTrace();
        }

    }
}
