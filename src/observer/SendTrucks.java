package observer;

import base.FireStation;
import base.FireTruck;
import base.Incident;
import base.IncidentType;
import strategy.StrategyContext;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class SendTrucks implements Observer {
    private List<FireStation> stations;
    private StrategyContext context;

    public SendTrucks(List<FireStation> stations, StrategyContext context) {
        this.stations = stations;
        this.context = context;
    }

    @Override
    public void update(Incident incident) {
        int vehiclesNeeded = incident.getType().getRequiredVehicles();
        List<FireStation> selectedStations = context.executeStrategy(stations, incident.getLocation(), vehiclesNeeded);

        Map<FireStation, List<FireTruck>> sentTrucks = new HashMap<>();

        try {
            int travelTimeToIncident = (int) (Math.random() * 3) + 1; //  1-3 s
            for (FireStation station : selectedStations) {
                List<FireTruck> trucksSent = station.sendTrucks(vehiclesNeeded);
                sentTrucks.put(station, trucksSent);
                for (int j = 0; j < trucksSent.size(); j++) {
                    System.out.println("Truck " + (j + 1) + " from " + station.getName() + " sent.");
                }
                System.out.println("Travel time to incident: " + travelTimeToIncident + " s.");
            }
            Thread.sleep(travelTimeToIncident * 1000);

            if (incident.getType() == IncidentType.AF) {
                System.out.println("False alarm - trucks return to base.");
            } else {
                int actionTime = (int) (Math.random() * 21) + 5;
                System.out.println("Time handling incident: " + actionTime + " s.");
                //Thread.sleep(actionTime * 1000);
                System.out.println("Incident managed - Fire trucks return.");
            }

            // Simulate return travel time
            int travelTimeToBase = (int) (Math.random() * 3) + 1; // Random return time 1-3 seconds
            for (Map.Entry<FireStation, List<FireTruck>> entry : sentTrucks.entrySet()) {
                FireStation station = entry.getKey();
                List<FireTruck> dispatchedTrucks = entry.getValue();
                for (int j = 0; j < dispatchedTrucks.size(); j++) {
                    System.out.println("Truck " + (j + 1) + " from " + station.getName() + " return.");
                }
                System.out.println("Travel time from incident: " + travelTimeToBase + " s");
                //Thread.sleep(travelTimeToBase * 1000);
                station.returnTrucks(dispatchedTrucks);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
