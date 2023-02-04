package application;

import java.util.ArrayList;

public class Flight {
	private int flightId;//will be generated automatically when the object is created
	private String departure;
	private String destination;
	private ValidDate date;
	private  ValidTime time;
	private String planeId;

	


	public Flight (String departure,String destination, ValidDate date, ValidTime time) {
		this.departure=departure;
		this.destination=destination;
		this.date = date;
		this.time=time;
		
		

		
	}
	
	public Flight (int ID,String departure,String destination, ValidDate date, ValidTime time) {
		this.departure=departure;
		this.destination=destination;
		this.date = date;
		this.time=time;
		this.flightId= ID;
		
		
	}
	
	
/////////getters
	
	public String getDeparture() {
		return this.departure;
	}
	public String getDestination() {
		return this.destination;
	}
	public int getFlightId() {
		return this.flightId;
	}
	public String getPlanId() {
		return this.planeId;
	}
	public ValidDate getDate(){
		return this.date;
	
	}
	public ValidTime getTime() {
		return this.time;
	}
	
	

//////////setters
	
	public void setFlightId(int id) {
		this.flightId=id;
		
	}
	public void setDeparture(String departure) {
		this.departure=departure;
	
	}
	public void setDestination(String destination) {
		this.destination=destination;
	
	}
	public void setPlanId(String planId) {
		this.planeId=planId;
	}
	
	public void setDate(ValidDate date) {
		this.date= date;
	}

	public void setTime(ValidTime time) {
		this.time= time;
	}
	
	

///
	public String toSave() {
		return this.departure+","+this.destination +
				","+this.date
				+","+this.time+","+this.planeId+","+ this.flightId;
	}
	

	public String toString() {
		return "Flight id:"+this.flightId+"\nFrom "+this.departure+" to "+this.destination +
				"\nDate: "+this.date
				+"\nTime: "+this.time;
	}
	
	
}