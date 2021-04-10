package com.Ankita.Parking_Lot_TC;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ParkingLotTest {

    ParkingLotSystem parkinglotsystem=null;
    Object vehicle=null;
    int size;

    @Before
    public void setUp() throws Exception{
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
            Assert.assertTrue(isUnpark);
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
            Assert.assertTrue(ispark);
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
        public void thespace_isFthere_shouldReturnFalse(){
            try {
                parkinglotsystem.park(vehicle);
                parkinglotsystem.lotCapacityNotFull(size);
            } catch (ParkingLotException e) {
                e.printStackTrace();
                Assert.assertEquals("Parking Lot is not full",e.getMessage());
            }

    }




}
