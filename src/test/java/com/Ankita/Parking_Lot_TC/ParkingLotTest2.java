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




    @Before
    public void setUp() throws ParseException {
        parkingLot = new ParkingLot(1);

        parkinglotsystem =new ParkingLotSystem(parkingLot);


    }

    @Test
    public void givenVehicle_WhenParked_ShouldReturnTrue() {


        try {
            parkingLot.park(vehicle);
            //parkinglotsystem.park(vehicle);
            boolean isParked = parkinglotsystem.isVehicleParked(vehicle);
            boolean isParkedinSlot = parkingLot.isVehicleparkedInSlot(vehicle);
            Assert.assertTrue(isParkedinSlot);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }


    }


}
