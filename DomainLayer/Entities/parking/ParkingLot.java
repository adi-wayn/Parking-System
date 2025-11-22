package parking;
import java.util.ArrayList;
import java.util.List;

import iterators.ParkingSpotIterator;
import iterators.SpotIterator;
import parking.spots.ParkingSpot;
import tickets.Ticket;
import tickets.TicketStatus;
import vehicles.VehicleType;

public class ParkingLot {
	private final List<Floor> floors = new ArrayList<>();
	private final List<Ticket> activeTickets = new ArrayList<>();
	final List<Ticket> history = new ArrayList<>();

	public void addFloor(Floor f) { floors.add(f); }

	public boolean isFull() {
		return floors.stream().allMatch(Floor::isFull);
	}

	public ParkingSpot findSpot(VehicleType type) {
		for (Floor f : floors) {
			ParkingSpot s = f.findSpot(type);
			if (s != null) return s;
		}
		return null;
	}

	public void addActiveTicket(Ticket t) { activeTickets.add(t); }

	public Ticket getActiveTicket(String plate) {
		return activeTickets.stream().filter(t -> t.getPlate().equals(plate) && t.getStatus() == TicketStatus.PENDING).findFirst().orElse(null);
	}

	public List<Ticket> getPendingTickets(String plate) {
		List<Ticket> res = new ArrayList<>();
		for (Ticket t : activeTickets) if (t.getPlate().equals(plate) && t.getStatus() == TicketStatus.PENDING) res.add(t);
		return res;
	}


	public List<Ticket> getHistory() {
		return history;
	}

	public List<Floor> getFloors() {
		return floors;
	}
	
	public void addToHistory(Ticket t) {
		history.add(t);
		activeTickets.remove(t);
	}

	public void freeSpotByNumber(int spotNumber) {
		for (Floor f : floors) {
			for (ParkingSpot s : f.getSpots()) {
				if (s.getSpotNumber() == spotNumber) {
					s.freeSpot();
					return;
				}
			}
		}
	}

	public ParkingSpotIterator iteratorAll() {
    List<ParkingSpot> all = new ArrayList<>();
    for (Floor f : floors) {
        ParkingSpotIterator it = f.getSpots().iterator();
        while (it.hasNext()) {
            all.add(it.next());
        }
    }
    return new ParkingSpotIteratorImpl(all);
}

}
