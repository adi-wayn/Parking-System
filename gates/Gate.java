package gates;

public abstract class Gate {
    protected final String gateId;

    public Gate(String id) {
        this.gateId = id;
    }

    public String getGateId() { return gateId; }

    protected void openGate() {
        System.out.println("Gate " + gateId + " opened.");
    }
}