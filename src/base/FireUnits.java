package base;

import base.Coordinates;
import base.FireStation;
import iterator.UnitIterator;

import java.util.*;
public class FireUnits {
    private List<FireStation> stations;

    public FireUnits() {
        this.stations = new ArrayList<>();
        initializeStations();
    }

    private void initializeStations() {
        stations.add(new FireStation("JRG-1", new Coordinates(50.060012, 19.943198), 5));
        stations.add(new FireStation("JRG-2", new Coordinates(50.033439, 19.935939), 5));
        stations.add(new FireStation("JRG-3", new Coordinates(50.076198, 19.883794), 5));
        stations.add(new FireStation("JRG-4", new Coordinates(50.037626, 20.005706), 5));
        stations.add(new FireStation("JRG-5", new Coordinates(50.0922, 19.921726), 5));
        stations.add(new FireStation("JRG-6", new Coordinates(50.015969, 20.015861), 5));
        stations.add(new FireStation("JRG-7", new Coordinates(50.094098, 19.977145), 5));
        stations.add(new FireStation("JRG Szkoły Aspirantów PSP", new Coordinates(50.07735, 20.033058), 5));
        stations.add(new FireStation("JRG Skawina", new Coordinates(49.970807, 19.791477), 5));
        stations.add(new FireStation("LSP Lotniska w Balicach", new Coordinates(50.071615317615375, 19.80358122880753), 5));
    }

    public iterator.Iterator<FireStation> createIterator() {
        return new UnitIterator(stations);
    }
}
