package com.Ankita.Parking_Lot_TC;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ParkingLotTest2 {
/**
    ParkingLotSystem parkinglotsystem ;


    ParkingLot parkingLot;
    private String Handicape;
    ParkingLot parkingLot1;
    vehicle vehicle1;
    vehicle vehicle2;
    vehicle vehicle3;
    vehicle vehicle4;


   ParkedVehicleDetails parkedVehicleDetails;



    @Before
    public void setUp() throws ParseException {
        parkingLot = new ParkingLot(6);
        parkingLot1= new ParkingLot(6);

        parkinglotsystem =new ParkingLotSystem(parkingLot,parkingLot1);


    }

    @Test
    public void givenVehicle_WhenParked_ShouldReturnTrue() {


        try {
             vehicle1=new vehicle("Anki","Alto","ODWE23","red");
             parkinglotsystem.park(vehicle1);
             parkingLot.park(vehicle1);
            boolean isParked = parkinglotsystem.isVehicleParked(vehicle1);
            boolean isParkedinSlot = parkingLot.isVehicleparkedInSlot(vehicle1);
            Assert.assertFalse(isParkedinSlot);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void givenVehicle_shouldBe_EvenlyDirected_ToAllSpaces_shouldReturnTrue() throws ParkingLotException {
       // parkinglotsystem.park(vehicle);
        parkingLot.park(vehicle1);
        parkingLot.unPark(vehicle1);
        boolean isSpaceavailable=parkingLot.isSpaceAvailable();
        Assert.assertTrue(isSpaceavailable);


    }

    @Test
    public void givenVehicle_shouldBe_EvenlyDirected_ToAllSpaces_shouldReturnfalse()  {
        // parkinglotsystem.park(vehicle);
        try {
            parkingLot.park(vehicle1);
            parkingLot.unPark(vehicle1);
            boolean isSpaceavailable=parkingLot.isSpaceAvailable();
            Assert.assertFalse(isSpaceavailable);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }



    }

    @Test
    public void givenHandicapeDriver_shouldBe_given_nearest_space(){
         parkingLot.HandicapeSlot(Handicape);
         boolean isParked=parkingLot.isLotHaveHandicape_vehicle(vehicle1);
         Assert.assertTrue(isParked);

    }

    @Test
    public void givenDriverShould_parkThevehicle_inSlot(){
        try {
            vehicle1=new vehicle("Ankita","Maruti","OD12Qw","Blue");
             parkedVehicleDetails=new ParkedVehicleDetails(ParkingType.HANDICAPPED);
            //parkinglotsystem.park_Vehicle((com.Ankita.Parking_Lot_TC.vehicle) vehicle,parkingType);
            boolean isPark=parkingLot.park_vehicle_slot(vehicle1,parkedVehicleDetails);
            Assert.assertTrue(isPark);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }




    }



    @Before
    public void givenDriverShould_parkThevehicle_inParkingSystem(){
        vehicle1=new vehicle("Ankita","Maruti","OD12Qw","Blue");
        vehicle2=new vehicle("krishna","BMW","AM8080","red");
        vehicle3=new vehicle("Abhaya","Swift","S0123","White");
        vehicle4=new vehicle("Sasmita","Toyota","S0893","Green");

        try {
            parkingLot.park_Vehicle1(vehicle1);
            parkingLot.park_Vehicle1(vehicle2);
            parkingLot.park_Vehicle1(vehicle3);
            parkingLot1.park_Vehicle1(vehicle4);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ShouldReturnLots_HavingWhiteCar() {
        List<ParkingLot> LotList = parkinglotsystem.searchForWhiteCars();
        Assert.assertEquals(parkingLot, LotList);

    }

    @Test
    public void ShouldReturnLots_HavingToyota(){
        List<ParkingLot> LotList= parkinglotsystem.searchToyota();
        Assert.assertEquals(parkingLot1,LotList);
        StringBuilder plateNumber = parkingLot.SearchForVehicleNumber();
        //Assert.assertEquals("S0893",plateNumber.toString());



    }

    @Test
    public void ShouldReturnLots_HavingBMW(){
        List<ParkingLot> LotList = parkinglotsystem.searchForBMW();
        Assert.assertEquals(parkingLot, LotList);

    }

    @Test
    public void ShouldReturnCars_ParkedBeforeTime(){


    }
/**
    @Test
    public void ShouldReturnAll_Cars(){
        List<ParkingLot> LotList = parkingLot.searchForAll();
        Assert.assertEquals(parkingLot, LotList);


    }
    **/


}
