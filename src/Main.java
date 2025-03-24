import base.*;
import observer.ObservedSubject;
import observer.SendTrucks;
import strategy.DistanceStrategy;
import strategy.StrategyContext;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        FireUnits fireUnits = new FireUnits();
        List<FireStation> stations = new ArrayList<>();
        iterator.Iterator<FireStation> iterator = fireUnits.createIterator();
        while (iterator.hasNext()) {
            stations.add(iterator.next());
        }

        StrategyContext context = new StrategyContext();
        context.setStrategy(new DistanceStrategy());

        ObservedSubject notify = new ObservedSubject();
        SendTrucks send = new SendTrucks(stations, context);
        notify.addObserver(send);

        for (int i = 0; i < 5; i++) {
            double x = ThreadLocalRandom.current().nextDouble(19.688292482742394, 20.02470275868903);
            double y = ThreadLocalRandom.current().nextDouble(49.95855025648944, 50.154564013341734);

            // generujemy incydenty
            IncidentType type = generateRandomIncidentType();
            Incident incident = new Incident(type, new Coordinates(y, x));
            System.out.println("New incident: " + incident.getType() + " \n[ " + y + ", " + x + " ]");

            // powiadamiamy obserwaorow
            notify.notifyObservers(incident);

            // czemkamy przed nastepnym incydentem
            //Thread.sleep(ThreadLocalRandom.current().nextInt(500, 3000));
        }

        System.out.println("End.");
    }

    private static IncidentType generateRandomIncidentType() {
        double chance = Math.random();
        if (chance < 0.05) return IncidentType.AF;
        if (chance < 0.35) return IncidentType.PZ;
        return IncidentType.MZ;
    }
}
