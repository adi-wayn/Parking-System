package services;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import parking.ParkingLot;

public class WaitingListService {

    private final Map<ParkingLot, Queue<String>> waitingLists = new HashMap<>();

    public void enqueue(String plate, ParkingLot lot) {
        waitingLists
            .computeIfAbsent(lot, k -> new LinkedList<>())
            .add(plate);
    }

    public String dequeue(ParkingLot lot) {
        Queue<String> q = waitingLists.get(lot);
        return (q == null ? null : q.poll());
    }

    public boolean hasWaiting(ParkingLot lot) {
        Queue<String> q = waitingLists.get(lot);
        return q != null && !q.isEmpty();
    }
}