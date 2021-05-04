package com.Ankita.Parking_Lot_TC;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotSystemFinalTest {
    public ParkingLotSystem parkingLotSystem;
    public ParkingLotSystem parkingLotSystem2;


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

        parkingLot0=new ParkingLot(20);
        parkingLot1=new ParkingLot(20);
        parkingLot2=new ParkingLot(3);

        parkingLotb=new ParkingLot(20);
        parkingLotc=new ParkingLot(20);
        parkingLotd=new ParkingLot(20);

        parkedVehicleDetails1 =new ParkedVehicleDetails(ParkingType.HANDICAPPED);
        parkedVehicleDetails2=new ParkedVehicleDetails(ParkingType.NORMAL);
        parkedVehicleDetails3=new ParkedVehicleDetails(ParkingType.LARGE);

        parkingLotSystem = new ParkingLotSystem(parkingLot0,parkingLot1);
        parkingLotSystem2 = new ParkingLotSystem(parkingLot2);




    }
    @Test
    public void givenAVehicle_WhenParkedInParkingLot_ShouldReturnEqual(){
        try {
           parkingLot0.park_vehicle_slot(v1,parkedVehicleDetails1);

            int vehiclePresent = parkingLot0.searchVehicle(v1);
            Assert.assertEquals(1,vehiclePresent);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void givenAVehicle_WhenParkedInParkingLot_ShouldReturnNotEqual(){
        try {
            parkingLot0.park_vehicle_slot(v1,parkedVehicleDetails1);

            int vehiclePresent = parkingLot0.searchVehicle(v2);
            Assert.assertNotEquals(1,vehiclePresent);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void givenAVehicle_WhenParkedInParkingLot_ShouldReturnTrue(){
        try {
            boolean isParked=parkingLotSystem.park_Vehicle(v1,parkedVehicleDetails1);
            Assert.assertTrue(isParked);

        } catch (ParkingLotException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void givenAVehicle_WhenParkedInFullParkingLot_ShouldReturnMessage(){
        try {
            parkingLot2.park_vehicle_slot(v1,parkedVehicleDetails1);
            parkingLot2.park_vehicle_slot(v2,parkedVehicleDetails1);
            parkingLot2.park_vehicle_slot(v3,parkedVehicleDetails1);


        } catch (ParkingLotException e) {
            e.printStackTrace();
            Assert.assertEquals(ParkingLotException.ExceptionType.PARKING_FULL,e.type);
        }

    }

    @Test
    public void givenAVehicle_WhenUNParkedInParkingLot_ShouldReturnTrue(){
        try {
            parkingLot0.park_vehicle_slot(v1,parkedVehicleDetails1);
            boolean unparkTheVehicle=parkingLot0.unPark(v1);
            int vehiclePresent=parkingLot0.searchVehicle(v1);
            Assert.assertTrue(unparkTheVehicle);
            Assert.assertEquals(1,vehiclePresent);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void givenAVehicle_WhenUNParkedInParkingLot_ShouldReturnFalse(){
        try {
            parkingLot0.park_vehicle_slot(v1,parkedVehicleDetails1);
            boolean unparkTheVehicle=parkingLot0.unPark(v2);
            Assert.assertFalse(unparkTheVehicle);

        } catch (ParkingLotException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void givenAVehicle_WhenUnParkedInParkingLotAndNotThereinLot_ShouldReturnMessage(){
        try {
            parkingLotSystem.park_Vehicle(v1,parkedVehicleDetails1);
            boolean unparkTheVehicle=parkingLotSystem.unPark(v2,parkedVehicleDetails1);
            Assert.assertFalse(unparkTheVehicle);
        } catch (ParkingLotException e) {
            Assert.assertEquals(ParkingLotException.ExceptionType.VEHICLE_NOT_FOUND,e.type);
        }


    }

    @Test
    public void GivenVehicleInTheParkingLot_WhenSearched_shouldReturnTrue(){
        try {
            parkingLot0.park_vehicle_slot(v1,parkedVehicleDetails1);
            parkingLot0.park_vehicle_slot(v2,parkedVehicleDetails1);
            parkingLot0.park_vehicle_slot(v3,parkedVehicleDetails1);
            int searchedVehicle=parkingLot0.searchVehicle(v3);
            Assert.assertEquals(3,searchedVehicle);

        } catch (ParkingLotException e) {
            e.printStackTrace();

        }


    }


    @Test
    public void GivenTheVehicle_InTheParkingLotWhenNotFoundShouldReturn_aMessage(){
        try {
            parkingLot0.park_vehicle_slot(v1,parkedVehicleDetails1);

            parkingLot0.park_vehicle_slot(v3,parkedVehicleDetails1);
            int searchedVehicle=parkingLot0.searchVehicle(v2);
            Assert.assertEquals(2,searchedVehicle);

        } catch (ParkingLotException e) {
            e.printStackTrace();
            Assert.assertEquals(ParkingLotException.ExceptionType.VEHICLE_NOT_FOUND,e.type);

        }


    }



    @Test
    public void GivenVehicle_WhenParked_ShouldParkInEvenlyMannerInParkingLot(){
        try {
            parkingLotSystem.park_Vehicle(v1,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v2,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v3,parkedVehicleDetails2);

            Assert.assertEquals(parkingLot0.ParkingSLotList.get(0).getVehicle(),v1);
            Assert.assertEquals(parkingLot1.ParkingSLotList.get(0).getVehicle(),v2);
            Assert.assertEquals(parkingLot0.ParkingSLotList.get(1).getVehicle(),v3);



        } catch (ParkingLotException e) {
            e.printStackTrace();

        }


    }

    @Test
    public void GivenVehicle_WhenParkedWhenDriverIsOfHandicapType_ShouldReturnEqual(){
        try {
            parkingLotSystem.park_Vehicle(v1,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v2,parkedVehicleDetails1);
            parkingLotSystem.unPark(v1,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v3,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v1,parkedVehicleDetails1);
            Assert.assertEquals(parkingLot0,parkingLotSystem.search_Vehicle(v1));
        } catch (ParkingLotException e) {
            e.printStackTrace();

        }


    }

    @Test
    public void GivenVehicle_WhenParkedWhenDriverIsOfHandicapeType_ShouldReturnNotEqual(){
        try {
            parkingLotSystem.park_Vehicle(v1,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v2,parkedVehicleDetails1);
            parkingLotSystem.unPark(v1,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v3,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v1,parkedVehicleDetails1);
            Assert.assertNotEquals(parkingLot2,parkingLotSystem.search_Vehicle(v1));
        } catch (ParkingLotException e) {
            e.printStackTrace();

        }


    }
    @Test
    public void GivenVehicle_WhenParkedWhenDriverIsOfHandicapType_ShouldReturnMessage_WhenNotFound(){
        try {
            parkingLotSystem.park_Vehicle(v1,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v2,parkedVehicleDetails1);
            parkingLotSystem.unPark(v1,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v3,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v1,parkedVehicleDetails1);

        } catch (ParkingLotException e) {
            Assert.assertEquals(ParkingLotException.ExceptionType.VEHICLE_NOT_FOUND,e.type);
        }


    }

    @Test
    public void GivenVehicle_WhenParkedWillUnparkWhenDriverIsOfHandicapeType_ShouldReturnTrue(){
        try {
            parkingLotSystem.park_Vehicle(v1,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v2,parkedVehicleDetails1);
            boolean isUnpark=parkingLotSystem.unPark(v1,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v3,parkedVehicleDetails2);
            Assert.assertTrue(isUnpark);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void GivenVehicle_WhenParkedWillUnparkWhenDriverIsOfHandicapType_ShouldReturnFalse(){
        try {
            parkingLotSystem.park_Vehicle(v2,parkedVehicleDetails1);
            boolean isUnpark=parkingLotSystem.unPark(v1,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v3,parkedVehicleDetails2);
            Assert.assertFalse(isUnpark);
        } catch (ParkingLotException e) {
            e.printStackTrace();

        }


    }

    @Test
    public void GivenVehicle_WhenParkedWillUnparkWhenDriverIsOfHandicapType_ShouldReturnMessage(){
        try {
            parkingLotSystem.park_Vehicle(v2,parkedVehicleDetails1);
            boolean isUnpark=parkingLotSystem.unPark(v1,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v3,parkedVehicleDetails2);
        }catch (ParkingLotException e) {
           e.printStackTrace();
           Assert.assertEquals(ParkingLotException.ExceptionType.VEHICLE_NOT_FOUND,e.type);
        }


    }


    @Test
    public void GivenVehicle_WhenParkedWhenDriverIsOfBigVehicles_ShouldReturnEqual(){
        try {
            parkingLotSystem.park_Vehicle(v1,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v2,parkedVehicleDetails1);
            parkingLotSystem.unPark(v2,parkedVehicleDetails1);
            parkingLotSystem.park_Vehicle(v2,parkedVehicleDetails3);
            parkingLotSystem.unPark(v1,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v3,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v1,parkedVehicleDetails1);
            parkingLotSystem.park_Vehicle(v4,parkedVehicleDetails2);
            Assert.assertEquals(parkingLot0,parkingLotSystem.search_Vehicle(v2));
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void GivenVehicle_WhenParkedWhenDriverIsOfBigVehicles_ShouldReturnNotEqual(){
        try {
            parkingLotSystem.park_Vehicle(v1,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v2,parkedVehicleDetails1);
            parkingLotSystem.unPark(v2,parkedVehicleDetails1);
            parkingLotSystem.park_Vehicle(v2,parkedVehicleDetails3);
            parkingLotSystem.unPark(v1,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v3,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v1,parkedVehicleDetails1);
            parkingLotSystem.park_Vehicle(v4,parkedVehicleDetails2);
            Assert.assertNotEquals(parkingLot1,parkingLotSystem.search_Vehicle(v2));
        } catch (ParkingLotException e) {

        }

    }

    @Test
    public void GivenVehicle_WhenParkedShouldUnpark_WhenDriverISofBigVehicles_ShouldReturnTrue() throws ParkingLotException {
        try{
            parkingLotSystem.park_Vehicle(v1,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v2,parkedVehicleDetails1);
            parkingLotSystem.unPark(v2,parkedVehicleDetails1);
            parkingLotSystem.park_Vehicle(v2,parkedVehicleDetails3);
            boolean isUnparked=parkingLotSystem.unPark(v1,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v3,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v1,parkedVehicleDetails1);
            parkingLotSystem.park_Vehicle(v4,parkedVehicleDetails2);
            Assert.assertTrue(isUnparked);

        } catch (ParkingLotException e) {
            e.printStackTrace();


        }

    }

    @Test
    public void GivenVehicle_WhenParkedShouldUnpark_WhenDriverISofBigVehicles_ShouldReturnFalse() throws ParkingLotException {
        try{
            parkingLotSystem.park_Vehicle(v1,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v2,parkedVehicleDetails1);
            parkingLotSystem.unPark(v2,parkedVehicleDetails1);
            parkingLotSystem.park_Vehicle(v2,parkedVehicleDetails3);
            parkingLotSystem.unPark(v1,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v3,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v1,parkedVehicleDetails1);
            parkingLotSystem.park_Vehicle(v4,parkedVehicleDetails2);
            boolean isUnparked= parkingLotSystem.unPark(v1,parkedVehicleDetails2);
            Assert.assertFalse(isUnparked);

        } catch (ParkingLotException e) {
            e.printStackTrace();

        }

    }

    @Test
    public void GivenVehicle_WhenParkedShouldUnpark_WhenDriverISofBigVehicles_ShouldReturnMessage() throws ParkingLotException {
        try{
            parkingLotSystem.park_Vehicle(v1,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v2,parkedVehicleDetails1);
            parkingLotSystem.unPark(v2,parkedVehicleDetails1);
            parkingLotSystem.park_Vehicle(v2,parkedVehicleDetails3);
            parkingLotSystem.unPark(v1,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v3,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v1,parkedVehicleDetails1);
            parkingLotSystem.park_Vehicle(v4,parkedVehicleDetails2);
            boolean isUnparked= parkingLotSystem.unPark(v1,parkedVehicleDetails2);


        } catch (ParkingLotException e) {
            Assert.assertEquals(ParkingLotException.ExceptionType.VEHICLE_NOT_FOUND,e.type);

        }

    }




    @Test
    public void GivenVehicle_WhenParkedBefore30minInParkingLot_shouldReturnVehicle(){
        try {
            parkingLot0.park_vehicle_slot(v1,parkedVehicleDetails1);
            parkingLot0.park_vehicle_slot(v2,parkedVehicleDetails1);
            parkingLot0.park_vehicle_slot(v3,parkedVehicleDetails1);
            ArrayList<vehicle> parkedVehicles=parkingLot0.vehicleParkedBefore30min();
            Assert.assertEquals(3,parkedVehicles.size());
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }



    }

    @Test
    public void GivenVehicle_WhenParkedBefore30minInParkingLot_shouldReturnVehicleWithNotEualcondition(){
        try {
            parkingLot2.park_vehicle_slot(v1,parkedVehicleDetails2);
            ArrayList<vehicle> parkedVehicles=parkingLot0.vehicleParkedBefore30min();
            Assert.assertNotEquals(3,parkedVehicles.size());
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }



    }




    @Test
    public void GivenVehicle_WhenParkedBefore30minInParkingLotSystem_shouldReturnVehicle(){
        try {
            parkingLotSystem.park_Vehicle(v1,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v2,parkedVehicleDetails1);
            parkingLotSystem.unPark(v2,parkedVehicleDetails1);
            parkingLotSystem.park_Vehicle(v2,parkedVehicleDetails3);
            parkingLotSystem.unPark(v1,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v3,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v1,parkedVehicleDetails1);
            ArrayList<ArrayList<ParkingSlot>> parkedVehiclesList=parkingLotSystem.vehicleParkedInSystemBefore30min();
            Assert.assertEquals(2,parkedVehiclesList.size());
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }



    }

    @Test
    public void GivenVehicle_WhenParkedBefore30minInParkingLotSystem_shouldReturnVehicleWithNotEqualCondition(){
        try {
            parkingLotSystem.park_Vehicle(v1,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v2,parkedVehicleDetails1);
            parkingLotSystem.park_Vehicle(v4,parkedVehicleDetails3);
            parkingLotSystem.park_Vehicle(v3,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v5,parkedVehicleDetails3);
            ArrayList<ArrayList<ParkingSlot>> parkedVehiclesList=parkingLotSystem.vehicleParkedInSystemBefore30min();
            System.out.println(parkedVehiclesList.size());
            Assert.assertNotEquals(5,parkedVehiclesList.size());
        } catch (ParkingLotException e) {

        }



    }

    @Test
    public void GivenVehicle_WhenParked_ShouldReturnListOfLocationOfBMWCAR(){

        try {
            parkingLotSystem.park_Vehicle(v1,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v2,parkedVehicleDetails1);
            parkingLotSystem.park_Vehicle(v3,parkedVehicleDetails3);
            parkingLotSystem.park_Vehicle(v4,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v5,parkedVehicleDetails1);
            parkingLotSystem.park_Vehicle(v6, parkedVehicleDetails2);
            ParkedVehicleAttribute parkedVehicleAttribute=new ParkedVehicleAttribute(ParkedVehicleAttribute.VehicleModel.BMW,null);
            ArrayList<List<Integer>> lotlist = parkingLotSystem.getLotList(ParkingSlotSorting.BY_MODEL, parkedVehicleAttribute);
            Assert.assertEquals(2,lotlist.size());

        } catch (ParkingLotException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void GivenVehicle_WhenParked_ShouldReturnListOfLocationOfBMWCARWithNotEqualCondition() {

        try {
            parkingLotSystem.park_Vehicle(v1, parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v2, parkedVehicleDetails1);
            parkingLotSystem.park_Vehicle(v3, parkedVehicleDetails3);
            parkingLotSystem.park_Vehicle(v4, parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v5, parkedVehicleDetails1);
            parkingLotSystem.park_Vehicle(v6, parkedVehicleDetails2);
            ParkedVehicleAttribute parkedVehicleAttribute = new ParkedVehicleAttribute(ParkedVehicleAttribute.VehicleModel.BMW, null);
            ArrayList<List<Integer>> lotlist = parkingLotSystem.getLotList(ParkingSlotSorting.BY_MODEL, parkedVehicleAttribute);
            Assert.assertNotEquals(3, lotlist.size());

        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void GivenVehicle_WhenParked_ShouldReturnListOfLocationOfWhiteCar(){

        try {
            parkingLotSystem.park_Vehicle(v1,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v2,parkedVehicleDetails1);
            parkingLotSystem.unPark(v2,parkedVehicleDetails1);
            parkingLotSystem.park_Vehicle(v2,parkedVehicleDetails3);
            parkingLotSystem.unPark(v1,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v3,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v1,parkedVehicleDetails1);
            parkingLotSystem.park_Vehicle(v4, parkedVehicleDetails2);
            ParkedVehicleAttribute parkedVehicleAttribute=new ParkedVehicleAttribute(null,ParkedVehicleAttribute.VehicleColor.White);
            ArrayList<List<Integer>> lotlist = parkingLotSystem.getLotList(ParkingSlotSorting.BY_COLOR, parkedVehicleAttribute);
            Assert.assertEquals(2,lotlist.size());

        } catch (ParkingLotException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void GivenVehicle_WhenParked_ShouldReturnListOfLocationOfWhiteCarWithNotEqualCondition(){

        try {
            parkingLotSystem.park_Vehicle(v1,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v2,parkedVehicleDetails1);
            parkingLotSystem.unPark(v2,parkedVehicleDetails1);
            parkingLotSystem.park_Vehicle(v2,parkedVehicleDetails3);
            parkingLotSystem.unPark(v1,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v3,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v1,parkedVehicleDetails1);
            parkingLotSystem.park_Vehicle(v4, parkedVehicleDetails2);
            ParkedVehicleAttribute parkedVehicleAttribute=new ParkedVehicleAttribute(null,ParkedVehicleAttribute.VehicleColor.White);
            ArrayList<List<Integer>> lotlist = parkingLotSystem.getLotList(ParkingSlotSorting.BY_COLOR, parkedVehicleAttribute);
            Assert.assertNotEquals(3,lotlist.size());

        } catch (ParkingLotException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void GivenVehicle_WhenParked_ShouldReturnListOfLocationAndDetailsOfToyotaCar(){

        try {
            parkingLotSystem.park_Vehicle(v1,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v2,parkedVehicleDetails1);
            parkingLotSystem.park_Vehicle(v3,parkedVehicleDetails3);
            parkingLotSystem.park_Vehicle(v4,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v5,parkedVehicleDetails1);
            parkingLotSystem.park_Vehicle(v6, parkedVehicleDetails2);
            ParkedVehicleAttribute parkedVehicleAttribute=new ParkedVehicleAttribute(ParkedVehicleAttribute.VehicleModel.TOYOTA,ParkedVehicleAttribute.VehicleColor.blue);
            ArrayList<List<Integer>> lotlist = parkingLotSystem.getLotList(ParkingSlotSorting.BY_COLOR_MODEL, parkedVehicleAttribute);
            for (int i =0 ; i<lotlist.size() ;i++){
                System.out.println(lotlist.get(i));
            }

            Assert.assertEquals(2,lotlist.size());


        } catch (ParkingLotException e) {
            e.printStackTrace();
        }


    }


    @Test
    public void GivenVehicle_WhenParked_ShouldReturnListOfLocationOfVehicleOfHandicapDriversInLots(){
        try {
            parkingLotb.park_vehicle_slot(v1,parkedVehicleDetails3);
            parkingLotb.park_vehicle_slot(v2,parkedVehicleDetails3);
            parkingLotd.park_vehicle_slot(v3,parkedVehicleDetails3);
            parkingLotd.park_vehicle_slot(v4,parkedVehicleDetails3);


            ArrayList<List<Integer>> HandicapCars= parkingLotSystem.searchForHandicapeDriver(parkedVehicleDetails3);
            Assert.assertEquals(2,HandicapCars.size());

        } catch (ParkingLotException e) {
            e.printStackTrace();
        }



    }





    @Test
    public void GivenVehicle_WhenParked_ShouldReturnListOfLocationOfAllVehicles(){
        try {
            parkingLotSystem.park_Vehicle(v1, parkedVehicleDetails1);
            parkingLotSystem.park_Vehicle(v2, parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v3, parkedVehicleDetails3);

            ArrayList<ArrayList<ParkingSlot>> ListLot = parkingLotSystem.getAllVehicleListInLot();
            for (int i = 0; i < ListLot.size(); i++) {
                System.out.println(ListLot.get(i));
            }

            Assert.assertEquals(2, ListLot.size());
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void GivenVehicle_WhenParkedAndSearchedInParkingLotSystem_shouldReturnEqual(){
        try {
            parkingLotSystem.park_Vehicle(v1,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v2,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v3,parkedVehicleDetails2);
            ParkingLot searchParkingLot = parkingLotSystem.search_Vehicle(v1);
            Assert.assertEquals(parkingLot0,searchParkingLot);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }



    }

    @Test
    public void GivenVehicle_WhenParkedAndSearchedInParkingLotSystem_shouldReturnNotEqual(){
        try {
            parkingLotSystem.park_Vehicle(v1,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v2,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v3,parkedVehicleDetails2);
            ParkingLot searchParkingLot = parkingLotSystem.search_Vehicle(v1);
            Assert.assertNotEquals(parkingLot1,searchParkingLot);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }



    }

    @Test
    public void GivenVehicle_WhenParkedAndSearchedInParkingLotSystem_shouldReturnMessageWhenNotFound(){
        try {
            parkingLotSystem.park_Vehicle(v1,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v2,parkedVehicleDetails2);
            parkingLotSystem.park_Vehicle(v3,parkedVehicleDetails2);
            ParkingLot searchParkingLot = parkingLotSystem.search_Vehicle(v4);

        } catch (ParkingLotException e) {
            e.printStackTrace();
            Assert.assertEquals(ParkingLotException.ExceptionType.VEHICLE_NOT_FOUND,e.type);
        }



    }
}
