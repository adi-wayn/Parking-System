package gates;
import java.util.LinkedList;
import java.util.Queue;

import customers.MonthlySub;
import vehicles.VehicleType;

public class WaitingList {
    private final Queue<String> visitorsWaitingList = new LinkedList<>();
    private final Queue<MonthlySub> subsWaitingList = new LinkedList<>();

    public void enqueueVisitor(String plate) {
        visitorsWaitingList.add(plate);
    }

    public void enqueueSub(MonthlySub sub, VehicleType type) {
        subsWaitingList.add(sub);
    }

    public String dequeueVisitor(VehicleType type) {
        return visitorsWaitingList.poll();
    }

    public MonthlySub dequeueSub(VehicleType type) {
        return subsWaitingList.poll();
    }

    public boolean hasVisitorsWaiting() {
        return !visitorsWaitingList.isEmpty();
    }

    public boolean hasSubsWaiting() {
        return !subsWaitingList.isEmpty();
    }
}
