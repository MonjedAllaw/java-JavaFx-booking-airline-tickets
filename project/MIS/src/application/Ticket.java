package application;

import java.util.ArrayList;
import java.util.Arrays;

public class Ticket{
	public static ArrayList <String> Classes = new ArrayList(Arrays.asList("First Class","Business Class","Economy Class"));
	private Flight flight;
	private Passenger passenger;
	private String ticket_ID;
	private double price;
	private String travel_class;//economy business
	public Ticket(Flight flight,Passenger passenger,double price,String travel_class) {
		this.flight=flight;
		this.passenger=passenger;
		if(Classes.contains(travel_class)) {
			this.travel_class=travel_class;
		
				
		}
		this.price=price;
		
		
	}
	public Ticket(Flight flight,Passenger passenger,String travel_class) {
		this.flight=flight;
		this.passenger=passenger;
		if(Classes.contains(travel_class)) {
			this.travel_class=travel_class;
		
				
		}
		
		
		
	}
	public Ticket(String ticketId,Flight flight,Passenger passenger,String travel_class) {
		this.ticket_ID=ticketId;
		this.flight=flight;
		this.passenger=passenger;
		if(Classes.contains(travel_class)) {
			this.travel_class=travel_class;
		
				
		}
		
		
		
	}
	
	
	public ArrayList<String> getClasses() {
		return Classes;
	}
	public void setClasses(ArrayList<String> classes) {
		Classes = classes;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public String getTicket_ID() {
		return ticket_ID;
	}
	public void setTicket_ID(String ticket_ID) {
		this.ticket_ID = ticket_ID;
	}
	public String getTravel_class() {
		return travel_class;
	}
	public void setTravel_class(String travel_class) {
		this.travel_class = travel_class;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Flight getFlights() {
		return this.flight;
	}
	public Passenger getPassenger() {
		return this.passenger;
	}
	public String getTicketId() {
		return this.ticket_ID;
	}
	public double getPrice() {
		return this.price;
	}
	
	

	

	public String toString() {
		return "\nPassenger:"+this.passenger.getName()+"\nFlight from "+this.flight.getDeparture()+"to "+this.flight.getDestination()+"\nTravel Class: "+ this.travel_class+"\nticket Id: "+this.ticket_ID+"\n";
	}
	
	
	
	

}
