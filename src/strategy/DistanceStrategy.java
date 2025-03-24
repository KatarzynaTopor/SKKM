package strategy;

import base.Coordinates;
import base.FireStation;

import java.util.*;

public class DistanceStrategy implements IStrategy {
    @Override
    public List<FireStation> selectStations(List<FireStation> stations, Coordinates location, int vehiclesNeeded) {
        stations.sort(Comparator.comparingDouble(s -> s.getLocation().distanceTo(location)));
        List<FireStation> selectedStations = new ArrayList<>();
        int remainingVehicles = vehiclesNeeded;

        for (FireStation station : stations) {
            if (remainingVehicles <= 0) break;
            if (station.hasAvailableTrucks()) {
                selectedStations.add(station);
                remainingVehicles -= Math.min(station.getAvailableTruckCount(), remainingVehicles);
            }
        }
        return selectedStations;
    }

}
