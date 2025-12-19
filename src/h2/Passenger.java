package h2;

public class Passenger {
	public String name;
	public int planned; //>=1
	public int visited;
	public boolean ticket;
	
public Passenger(String name, int planned, boolean ticket) {
	this.name = name;
	this.planned = planned;
	this.visited = 0;
	this.ticket = ticket;
}
}
