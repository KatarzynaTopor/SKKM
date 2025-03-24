package state;

import base.FireTruck;

public class AvailableState implements IState {
    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public void sendToIncident(FireTruck truck) {
        truck.setState(new OccupiedState());
    }

    @Override
    public void returnToBase(FireTruck truck) {
        throw new IllegalStateException("Truck is already in available state.");
    }
}
