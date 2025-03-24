package base;

public enum IncidentType {
    PZ(3),  // Pożary
    MZ(2),  // Miejscowe zagrożenia
    AF(0);  // Alarmy fałszywe

    private final int requiredVehicles;

    IncidentType(int requiredVehicles) {
        this.requiredVehicles = requiredVehicles;
    }

    public int getRequiredVehicles() {
        return requiredVehicles;
    }
}
