package ARS;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Flight
{
	private String flightID; // Unique flight ID set in add flight class
	private int aircraft; // Number of the aircraft within fleet (1-10)
	private int capacity; // Maximum number of passengers (depends on aircraft model)
	
	private boolean arriving; // set to true if flight is arriving at airline terminal (->ATL)
		// false if departing from airline terminal (ATL->)
	private String destination; // flight destination airport code (ATL->DEST)
		// or if it is an arriving flight, stores the code of airport that flight is leaving from (DEST->ATL)
	private Date departureDate, arrivalDate; //Flight departure and arrival date
	private int flightTime; //Estimate flight duration
	
	private String status; // Status of flight (scheduled, boarding, taxi out, taxi in, landing, take off, enroute)
	private String gate; // Gate where flight docks and boards
	
	
	public Flight()
	{ //Default constructor - shouldn't be used except for testing
		this("Default Flight", 1, false, "Default Flight", new Date(), 0, "Default Flight");
	}
	
	public Flight(String flightID, int aircraft, boolean arriving, String destination, Date departure, int flightTime, String gate)
	{ //Flight constructor
		this.flightID = flightID;
		this.aircraft = aircraft;
		this.arriving = arriving;
		this.destination = destination;
		departureDate = departure;
		this.flightTime = flightTime;
		this.gate = gate;
		status = "scheduled";
	}
	
	public String getFlightID()
	{
		return flightID;
	}
	
	public void setFlightID(String newID)
	{
		flightID = newID;
	}
	
	public boolean getDirection()
	{
		return arriving;
	}
	
	public void setDirection(boolean newDirection)
	{
		arriving = newDirection;
	}
	
	public String getDestination()
	{
		return destination;
	}
	
	public void setDestination(String newDest)
	{
		destination = newDest;
	}
	
	public Date getDepartureDate()
	{
		return departureDate;
	}
	
	public void setDepartureDate(Date newDate)
	{
		departureDate = newDate;
	}
	
	public String printDepartureDate()
	{ // returns the departure date and time in readable format
		SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		return ft.format(departureDate);
	}
	
	public Date getArrivalDate()
	{
		return arrivalDate;
	}
	
	public void setArrivalDate(Date newDate)
	{
		arrivalDate = newDate;
	}
	
	public String printArrivalDate()
	{ // returns the departure date and time in readable format
		SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		return ft.format(arrivalDate);
	}
	
	public String getGate()
	{
		return gate;
	}
	
	public void setGate(String newGate)
	{
		gate = newGate;
	}
	
	public String getStatus()
	{
		return status;
	}
	
	public void setStatus(String newStatus)
	{
		status = newStatus;
	}
	
	
	
}