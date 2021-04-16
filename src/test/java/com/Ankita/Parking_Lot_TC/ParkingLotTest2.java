package com.Ankita.Parking_Lot_TC;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;

public class ParkingLotTest2 {

    ParkingLotSystem parkinglotsystem ;
    Object vehicle = new Object();
    int size;
    ParkingLot parkingLot;
    private String Handicape;


    @Before
    public void setUp() throws ParseException {
        parkingLot = new ParkingLot(1);

        parkinglotsystem =new ParkingLotSystem(parkingLot);


    }

    @Test
    public void givenVehicle_WhenParked_ShouldReturnTrue() {


        try {

             parkinglotsystem.park(vehicle);
             parkingLot.park(vehicle);
            boolean isParked = parkinglotsystem.isVehicleParked(vehicle);
            boolean isParkedinSlot = parkingLot.isVehicleparkedInSlot(vehicle);
            Assert.assertTrue(isParkedinSlot);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void givenVehicle_shouldBe_EvenlyDirected_ToAllSpaces_shouldReturnTrue() throws ParkingLotException {
       // parkinglotsystem.park(vehicle);
        //parkingLot.park(vehicle);
        parkingLot.unPark(vehicle);
        boolean isSpaceavailable=parkingLot.isSpaceAvailable();
        Assert.assertTrue(isSpaceavailable);


    }

    @Test
    public void givenVehicle_shouldBe_EvenlyDirected_ToAllSpaces_shouldReturnfalse()  {
        // parkinglotsystem.park(vehicle);
        try {
            parkingLot.park(vehicle);
            parkingLot.unPark(vehicle);
            boolean isSpaceavailable=parkingLot.isSpaceAvailable();
            Assert.assertFalse(isSpaceavailable);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }



    }

    @Test
    public void givenHandicapeDriver_shouldBe_given_nearest_space(){
         parkingLot.HandicapeSlot(Handicape);
         boolean isParked=parkingLot.isLotHaveHandicape_vehicle(vehicle);
         Assert.assertTrue(isParked);

    }


}
