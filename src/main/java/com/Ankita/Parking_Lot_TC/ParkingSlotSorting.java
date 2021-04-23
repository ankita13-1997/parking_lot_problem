package com.Ankita.Parking_Lot_TC;

public enum ParkingSlotSorting {
    BY_COLOR(new SortByColor()),
    BY_MODEL(new SortBYMODEL()),
    BY_COLOR_MODEL(new sortByColorAndModel());

    public ParkingLotSorting sorting;


    ParkingSlotSorting(ParkingLotSorting sorting) {
        this.sorting = sorting;
    }
}
