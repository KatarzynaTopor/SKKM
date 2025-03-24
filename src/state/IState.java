package state;

import base.FireTruck;

public interface IState {
    boolean isAvailable();
    void sendToIncident(FireTruck truck);
    void returnToBase(FireTruck truck);
}
