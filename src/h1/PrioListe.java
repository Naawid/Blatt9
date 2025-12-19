package h1;

import java.util.ArrayList;

public class PrioListe {
	private ArrayList<Patient> myList = new ArrayList<>();

	public PrioListe() {

	}

	public void addPatient(Patient p) {
		if (myList.isEmpty()) {
	        myList.add(p);
	        return;
	    }

	    for (int i = 0; i < myList.size(); i++) {
	        if (p.prio < myList.get(i).prio) {
	            myList.add(i, p);
	            return;
	        }
	    }
	    myList.add(p);

	}

	public Patient getNextPatient() {
		Patient next = myList.getFirst();
		myList.removeFirst();
		return next;
	}

	public int getPosition(Patient p) {
		return myList.indexOf(p);
		
	}

}
