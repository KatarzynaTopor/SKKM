package base;

import base.Coordinates;
import base.IncidentType;

public class Incident {
    private IncidentType type;
    private Coordinates location;

    public Incident(IncidentType type, Coordinates location) {
        this.type = type;
        this.location = location;
    }

    public IncidentType getType() {
        return type;
    }

    public Coordinates getLocation() {
        return location;
    }

}