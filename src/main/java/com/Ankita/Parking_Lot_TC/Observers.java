package com.Ankita.Parking_Lot_TC;

import java.util.ArrayList;
import java.util.List;

public class Observers {

    private List<ParkingLotObserver> observerList;

    public Observers() {
        this.observerList = new ArrayList<>();
        this.observerList.add(new ParkingLotOwner());
        this.observerList.add(new AirPortSecurity());
    }

    public void informAllStatus(boolean isPakringFull) {
        this.observerList.forEach(parkingLotObserver -> parkingLotObserver.capacityIsFull(isPakringFull));
    }
}
