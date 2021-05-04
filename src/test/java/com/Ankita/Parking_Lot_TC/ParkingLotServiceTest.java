package com.Ankita.Parking_Lot_TC;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotServiceTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    public ParkingLot parkingLot0;
    public ParkingLot parkingLot1;
    public ParkingLot parkingLot2;
    public ParkingLot parkingLotc;
    public ParkingLot parkingLotb;
    public ParkingLot parkingLotd;


    public ParkedVehicleDetails parkedVehicleDetails1;
    public ParkedVehicleDetails parkedVehicleDetails2;
    public ParkedVehicleDetails parkedVehicleDetails3;

    public vehicle v1;
    public vehicle v2;
    public vehicle v3;
    public vehicle v4;
    public vehicle v5;
    public vehicle v6;


    @Before
    public void setUp(){
        v1=new vehicle("Abhaya","OD231040",
                ParkedVehicleAttribute.VehicleColor.blue,
                ParkedVehicleAttribute.VehicleModel.TOYOTA);

        v2=new vehicle("Ankita","DL15623",
                ParkedVehicleAttribute.VehicleColor.red,
                ParkedVehicleAttribute.VehicleModel.BMW);

        v3=new vehicle("Krishna","DL1500",
                ParkedVehicleAttribute.VehicleColor.White,
                ParkedVehicleAttribute.VehicleModel.OTHER);

        v4=new vehicle("Mayank","DL1567",
                ParkedVehicleAttribute.VehicleColor.White,
                ParkedVehicleAttribute.VehicleModel.OTHER);

        v5=new vehicle("Doll","DL4500",
                ParkedVehicleAttribute.VehicleColor.red,
                ParkedVehicleAttribute.VehicleModel.BMW);

        v6=new vehicle("MRS.Chopra","DL489",
                ParkedVehicleAttribute.VehicleColor.red,
                ParkedVehicleAttribute.VehicleModel.BMW);

        parkingLot0=new ParkingLot(6);
        parkingLot1=new ParkingLot(20);
        parkingLotb=new ParkingLot(20);
        parkingLotc=new ParkingLot(20);
        parkingLotd=new ParkingLot(20);

        parkedVehicleDetails1 =new ParkedVehicleDetails(ParkingType.HANDICAPPED);
        parkedVehicleDetails2=new ParkedVehicleDetails(ParkingType.NORMAL);
        parkedVehicleDetails3=new ParkedVehicleDetails(ParkingType.LARGE);


    }

    @Test
    public void givenVehicle_WhenVehicleParkedInSlot_ShouldReturnSlotNumber(){
        try {
            parkingLot0.park_vehicle_slot(v1,parkedVehicleDetails2);
            int slotNumber=parkingLot0.searchVehicle(v1);
            Assert.assertEquals(1,slotNumber);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenVehicle_WhenVehicleParkedInSlot_ShouldReturnSlotNumberIsNotEqual(){
        try {
            parkingLot0.park_vehicle_slot(v1,parkedVehicleDetails2);
            int slotNumber=parkingLot0.searchVehicle(v1);
            Assert.assertNotEquals(2,slotNumber);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenVehicleWhichIsNotPresentInLot_WhenUnParked_ShouldAMessage(){
        try {
            parkingLot0.park_vehicle_slot(v3,parkedVehicleDetails3);
            parkingLot0.park_vehicle_slot(v1,parkedVehicleDetails3);
            parkingLot0.unPark(v3);
            int slotNumber=parkingLot0.searchVehicle(v3);
            Assert.assertNotEquals(1,slotNumber);
        } catch (ParkingLotException e) {
            e.printStackTrace();
            Assert.assertEquals(ParkingLotException.ExceptionType.VEHICLE_NOT_FOUND,e.type);
        }

    }

    @Test
    public void GivenAVehicles_WhenParkingLotFull_ShouldThrowMessage(){
        try {
            parkingLot0.park_vehicle_slot(v3,parkedVehicleDetails1);
            parkingLot0.park_vehicle_slot(v1,parkedVehicleDetails3);
            parkingLot0.park_vehicle_slot(v5,parkedVehicleDetails2);
            parkingLot0.park_vehicle_slot(v6,parkedVehicleDetails3);

        } catch (ParkingLotException e) {
            e.printStackTrace();
            Assert.assertEquals(ParkingLotException.ExceptionType.PARKING_FULL,e.type);

        }


    }

    @Test
    public void GivenVehicle_WhenParkedIn_TheGivenParkingLot_ShouldReturnTrue(){
        try {
            boolean isParked=parkingLot0.park_vehicle_slot(v3,parkedVehicleDetails1);
            Assert.assertTrue(isParked);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void GivenVehicle_WhenUnParkedInTheGivenParkingLot_ShouldReturnTrue(){
        try {
            boolean isParked=parkingLot0.park_vehicle_slot(v3,parkedVehicleDetails1);
            boolean isUnParked=parkingLot0.unPark(v3);
            Assert.assertTrue(isParked);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void GivenVehicle_WhenParked_ShouldReturnListOfLocationAndDetailsOfToyotaCar(){

        try {
            parkingLot0.park_vehicle_slot(v1,parkedVehicleDetails2);
            parkingLot0.park_vehicle_slot(v2,parkedVehicleDetails1);
            parkingLot0.park_vehicle_slot(v3,parkedVehicleDetails3);
            parkingLot0.park_vehicle_slot(v4,parkedVehicleDetails2);
            parkingLot0.park_vehicle_slot(v5,parkedVehicleDetails1);
            parkingLot0.park_vehicle_slot(v6, parkedVehicleDetails2);
            ParkedVehicleAttribute parkedVehicleAttribute=new ParkedVehicleAttribute(ParkedVehicleAttribute.VehicleModel.TOYOTA,ParkedVehicleAttribute.VehicleColor.blue);
           ArrayList<Integer> Lotlist = (ArrayList<Integer>) parkingLot0.getParkedVehicleInSlot(ParkingSlotSorting.BY_COLOR_MODEL, parkedVehicleAttribute);
            for (int i =0 ; i<Lotlist.size() ;i++){
                System.out.println(Lotlist.get(i));
            }

            Assert.assertEquals(1,Lotlist.size());


        } catch (ParkingLotException e) {
            e.printStackTrace();
        }


    }


    @Test
    public void GivenVehicle_WhenParkedInParkingLot_ShouldReturnListOfLocationOfAllVehicles() {
        try {
            parkingLot0.park_vehicle_slot(v1, parkedVehicleDetails1);
            parkingLot0.park_vehicle_slot(v2, parkedVehicleDetails2);
            parkingLot0.park_vehicle_slot(v3, parkedVehicleDetails3);

            ArrayList<ParkingSlot> ListLot = parkingLot0.getAllVehicleInSlot();
            for (int i = 0; i < ListLot.size(); i++) {
                System.out.println(ListLot.get(i));
            }

            Assert.assertEquals(3, ListLot.size());
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }

    }

}
