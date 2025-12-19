package h2;

import java.util.ArrayList;

public class Bus {
	private ArrayList<Passenger> passengers = new ArrayList<>();

	public Bus() {
		passengers = new ArrayList<>();
	}

	public void enterBus(Passenger p) {
		passengers.add(p);
	}

	private void exitBus() {
		for (int i = passengers.size() - 1; i >= 0; i--) {
			if (passengers.get(i).visited == passengers.get(i).planned) {
		        passengers.remove(i);
		    }

		}
	}

	public void nextStop(Passenger[] boarding) {
		for (int i = 0; i < passengers.size(); i++) {
			passengers.get(i).visited++;
		}
		exitBus();
		for (int i = 0; i < boarding.length; i++) {
			passengers.add(boarding[i]);
		}
	}

	public void nextStop() {
		for (int i = 0; i < passengers.size(); i++) {
			passengers.get(i).visited++;
		}
		exitBus();
	}

	public ArrayList<Passenger> findPassengersWithoutTickets() {
		ArrayList<Passenger> kicked = new ArrayList<>();
		for (int i = 0; i < passengers.size(); i++) {
			if (!passengers.get(i).ticket) {
				kicked.add(passengers.get(i));
			}
		}
		passengers.removeAll(kicked);
		return kicked;
	}

	public void transferPassengers(Bus otherBus, String[] passengerNames) {
		for (int i = 0; i < passengers.size(); i++) {
			for (int k = 0; k < passengerNames.length; k++) {
				if (passengers.get(i).name.equals(passengerNames[k])) {
					otherBus.passengers.add(passengers.get(i));
					passengers.remove(i);
					break;
				}
			}
		}
	}

	public ArrayList<Passenger> getPassengers() {
		return passengers;
	}
}
