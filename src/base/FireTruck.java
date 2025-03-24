package base;

import state.AvailableState;
import state.IState;

public class FireTruck {
    private IState state;

    public FireTruck() {
        this.state = new AvailableState();
    }

    public boolean isAvailable() {
        return state.isAvailable();
    }

    public void sendToIncident() {
        state.sendToIncident(this);
    }

    public void returnToBase() {
        state.returnToBase(this);
    }

    public void setState(IState state) {
        this.state = state;
    }
}
