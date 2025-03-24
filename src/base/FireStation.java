package base;

import base.Coordinates;

import java.util.*;

public class FireStation {
    private String name;
    private Coordinates location;
    private List<FireTruck> fireTrucks;

    public FireStation(String name, Coordinates location, int truckCount) {
        this.name = name;
        this.location = location;
        this.fireTrucks = new ArrayList<>();
        for (int i = 0; i < truckCount; i++) {
            fireTrucks.add(new FireTruck());
        }
    }

    public String getName() {
        return name;
    }

    public Coordinates getLocation() {
        return location;
    }

    public List<FireTruck> sendTrucks(int count) {
        List<FireTruck> dispatched = new ArrayList<>();
        for (FireTruck truck : fireTrucks) {
            if (truck.isAvailable() && dispatched.size() < count) {
                truck.sendToIncident();
                dispatched.add(truck);
            }
        }
        return dispatched;
    }
    public boolean hasAvailableTrucks() {
        return fireTrucks.stream().anyMatch(FireTruck::isAvailable);
    }

    public void returnTrucks(List<FireTruck> trucks) {
        for (FireTruck truck : trucks) {
            if (!truck.isAvailable()) { // Sprawdzamy czy pojazd nie jest już dostępny
                truck.returnToBase();
            }
        }
    }
    public int getAvailableTruckCount() {
        return (int) fireTrucks.stream().filter(FireTruck::isAvailable).count();
    }


}
