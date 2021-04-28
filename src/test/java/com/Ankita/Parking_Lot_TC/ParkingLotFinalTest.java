package com.Ankita.Parking_Lot_TC;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotFinalTest {
    public ParkingLotSystem parkingLotSystem;


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
        parkingLotb=new ParkingLot(20);
        parkingLotc=new ParkingLot(20);
        parkingLotd=new ParkingLot(20);

        parkedVehicleDetails1 =new ParkedVehicleDetails(ParkingType.HANDICAPPED);
        parkedVehicleDetails2=new ParkedVehicleDetails(ParkingType.NORMAL);
        parkedVehicleDetails3=new ParkedVehicleDetails(ParkingType.LARGE);

        parkingLotSystem = new ParkingLotSystem(parkingLot0,parkingLot1);




    }
    @Test
    public void givenAVehicle_WhenParkedInParkingLot_ShouldReturnTrue(){
        try {
           parkingLot0.park_vehicle_slot(v1,parkedVehicleDetails1);

            int vehiclePresent = parkingLot0.searchVehicle(v1);
            Assert.assertEquals(1,vehiclePresent);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void givenAVehicle_WhenUN_ParkedInParkingLot_ShouldReturnTrue(){
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
    public void ToFIndThe_vehicle_inTheParkingLot_shouldReturn_true(){
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
    public void ToFIndThe_vehicle_inTheParkingLot_shouldReturn_aMessage(){
        try {
            parkingLot0.park_vehicle_slot(v1,parkedVehicleDetails1);

            parkingLot0.park_vehicle_slot(v3,parkedVehicleDetails1);
            int searchedVehicle=parkingLot0.searchVehicle(v2);
            Assert.assertEquals(2,searchedVehicle);

        } catch (ParkingLotException e) {
            e.printStackTrace();

        }


    }


    @Test
    public void get_vehicle_Parked_inEvenly_Manner_InParkingLot(){
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
    public void get_Vehicle_Parked_when_DriverIS_ofHandicapeType(){
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
    public void get_Vehicle_Parked_when_DriverIS_ofBigVehicles(){
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
    public void shoultReturn_vehicles_iInParkingLot_ParkedBefore30min(){
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
    public void shouldReturn_vehicles_iInParkingLotSystem_ParkedBefore30min(){
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
    public void shouldReturn_ListOfLocatnOfBMWCAR(){

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
    public void shouldReturn_ListOfLocationOfWhiteCar(){

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
    public void shouldReturn_ListOfLocation_And_OtherDetails_OfBlue_TOYOTA_Car(){

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
    public void shouldReturn_vehicles_ofTypeHandiCape_Parked_inLotBanddLotD_inParkingLot(){
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
    public void should_ReturnAll_Vehicles_InParkingLotSystem(){
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


}
