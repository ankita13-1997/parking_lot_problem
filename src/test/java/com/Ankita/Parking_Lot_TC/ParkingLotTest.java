package com.Ankita.Parking_Lot_TC;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;


public class ParkingLotTest{

    ParkingLotSystem parkinglotsystem =null;
    Object vehicle = new Object();
    int size;





    @Before
    public void setUp() throws ParseException {
        vehicle = new Object();
        parkinglotsystem = new ParkingLotSystem();


    }

    @Test
    public void givenVehicle_WhenParked_ShouldReturnTrue() {


        try {
             parkinglotsystem.park(vehicle);
             boolean isParked=parkinglotsystem.isVehicleParked(vehicle);
             Assert.assertTrue(isParked);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void givenVehicle_WhenAlreadyParked_ShouldReturnFalse(){
        try {
            parkinglotsystem.park(vehicle);
            parkinglotsystem.park(new Object());
        } catch (ParkingLotException e) {
            Assert.assertEquals("Parking Lot has that vehicle",e.getMessage());
            e.printStackTrace();
        }


    }



     @Test
    public void givenVehicle_WhenUnParked_ShouldReturnTrue() {
        try {
            parkinglotsystem.park(vehicle);
            boolean isUnpark = parkinglotsystem.unPark(vehicle);
            Assert.assertFalse(isUnpark);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }


    }



     @Test
    public void givenVehicle_WhenNotPresent_ShouldReturnMessage(){
        try {
            parkinglotsystem.isVehiclePresentInLot(vehicle);
            parkinglotsystem.isVehiclePresentInLot(new Object());
        } catch (ParkingLotException e) {
            Assert.assertEquals("Vehicle is not present in The lot",e.getMessage());
            e.printStackTrace();
        }


    }
    @Test
    public void givenVehicle_WhenPresent_ShouldReturnTrue() {
        try {
            parkinglotsystem.park(vehicle);
            boolean ispark = parkinglotsystem.unPark(vehicle);
            Assert.assertFalse(ispark);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }


     @Test
     public void theLot_isFull_shouldReturnTrue(){
         try {
             parkinglotsystem.lotCapacityNotFull(size);
             boolean isfull=parkinglotsystem.lotCapacity(size);
             Assert.assertTrue(isfull);
         } catch (ParkingLotException e) {
             e.printStackTrace();
         }




    }

    @Test
    public void theLot_isFull_shouldReturnFalse() {
        try {
            parkinglotsystem.lotCapacity(size);
            parkinglotsystem.lotCapacityNotFull(size);
        } catch (ParkingLotException e) {
            e.printStackTrace();
            Assert.assertEquals("Parking Lot is full", e.getMessage());
        }
    }

    @Test
    public void theSpace_isThere_shouldReturnTrue() {
        try {
            parkinglotsystem.park(vehicle);
            parkinglotsystem.lotCapacityNotFull(size);
            boolean isfull = parkinglotsystem.lotCapacity(size);
            Assert.assertTrue(isfull);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

        @Test
        public void thespace_isiFthere_shouldReturnFalse(){
            try {
                parkinglotsystem.park(vehicle);
                parkinglotsystem.lotCapacityNotFull(size);
            } catch (ParkingLotException e) {
                e.printStackTrace();
                Assert.assertEquals("Parking Lot is not full",e.getMessage());
            }

    }

    @Test
    public void givenThat_whenParkingLot_isFull_shouldInform_toOwner(){
         ParkingLotOwner owner = new ParkingLotOwner();
        parkinglotsystem.registerParkingLotObserver(owner);
        try {
            parkinglotsystem.park(vehicle);
            parkinglotsystem.park(new Object());

        } catch (ParkingLotException e) {}

        boolean capacityFull=owner.isCapacityFull();
        Assert.assertFalse(capacityFull);


    }

    @Test
    public void givenCapacity_is2_shouldBeAbleToPark2Vehicle(){
        Object vehicle2 = new Object();
        parkinglotsystem.setCapacity(2);
        try {
            parkinglotsystem.park(vehicle);
            parkinglotsystem.park(vehicle2);
            boolean isParked1=parkinglotsystem.isVehicleParked(vehicle);
            boolean isParked2=parkinglotsystem.isVehicleParked(vehicle2);
            Assert.assertTrue(isParked1 && isParked2);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void givenThat_whenParkingLot_isFull_shouldInform_toAirportSecurity(){
        AirPortSecurity airPortSecurity = new AirPortSecurity();
        parkinglotsystem.registerParkingLotObserver(airPortSecurity);
        try {
            parkinglotsystem.park(vehicle);
            parkinglotsystem.park(new Object());


        } catch (ParkingLotException e) {}
        boolean capacityFull=airPortSecurity.isCapacityFull();
        Assert.assertFalse(capacityFull);



    }
    @Test
    public void givenWhenParkingLotSpaceIsAvailableAfterFull_shouldreturnTrue(){
        Object vehicle2 = new Object();
        ParkingLotOwner owner = new ParkingLotOwner();
        parkinglotsystem.registerParkingLotObserver(owner);

        try {
            parkinglotsystem.park(vehicle);
            parkinglotsystem.park(vehicle2);
        } catch (ParkingLotException e) {}

        parkinglotsystem.unPark(vehicle);
        boolean capacityFull=owner.isCapacityFull();
        Assert.assertFalse(capacityFull);


    }


}
