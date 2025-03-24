package strategy;

import base.Coordinates;
import base.FireStation;

import java.util.List;

public class StrategyContext {
    private IStrategy strategy;

    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }

    public List<FireStation> executeStrategy(List<FireStation> stations, Coordinates location, int vehiclesNeeded) {
        return strategy.selectStations(stations, location, vehiclesNeeded);
    }
}
