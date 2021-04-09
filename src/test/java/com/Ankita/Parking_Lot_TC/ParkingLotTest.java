package com.Ankita.Parking_Lot_TC;


import org.junit.Assert;
import org.junit.Test;

public class ParkingLotTest {

    @Test
    public void givenVehicle_WhenParked_ShouldReturnTrue() {
      ParkingLotSystem parkinglotsystem = new ParkingLotSystem();
        boolean isParked = parkinglotsystem.park(new Object());
        Assert.assertTrue(isParked);

    }

    @Test
    public void givenVehicle_WhenParked_ShouldReturnTrue() {
    }
}
