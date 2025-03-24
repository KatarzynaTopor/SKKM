package state;

import base.FireTruck;
import state.AvailableState;
import state.IState;

class OccupiedState implements IState {
    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public void sendToIncident(FireTruck truck) {
        throw new IllegalStateException("Truck is already dispatched.");
    }

    @Override
    public void returnToBase(FireTruck truck) {
        truck.setState(new AvailableState());
    }
}
