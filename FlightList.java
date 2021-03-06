package ARS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class FlightList
{
	private ArrayList<Flight> flightList;
	private String[][] cities;
	private String[][] fleet;
	private String[][] gates = {{"G0", "Open"}, {"G1", "Open"}, {"G2", "Open"}, {"G3", "Open"},
			{"G4", "Open"}, {"G5", "Open"}, {"G6", "Open"}, {"G7", "Open"}};
	// Gates G0-G7 initially listed as "Open", indicating no craft is docked at that gate
	
	public FlightList()
	{
		flightList = new ArrayList<Flight>();
		setCities();
		setFleet();
	}
	
	private void setCities()
	{ // Reads from cities.txt (contains top trafficked airports)
		//to store destination cities in 2D array
		// {City name, Airport code, distance from ATL, est. travel time, last visited time}
		BufferedReader reader = null;
		ArrayList<String> cityList = new ArrayList<String>();
		try 
		{
			File file = new File("cities.txt");
			reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null)
			{
				cityList.add(line);
			}
			cities = new String[cityList.size()][5];
			String[] selectCity;
			for (int j=0; j<cityList.size(); j++)
			{
				line = cityList.get(j);
				selectCity = line.split(" ");
				for (int k=0; k<4; k++)
				{
					cities[j][k] = selectCity[k];
				}
				cities[j][4] = "na"; //set last visited time to "na" for each city initially
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				reader.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	} // end setCities
	
	public void setFleet()
	{ // Reads from fleet.txt to store airline's fleet information in fleet[][]
		// 10 aircraft
		// {aircraft number, aircraft model, aircraft capacity, aircraft range}
		BufferedReader reader = null;
		ArrayList<String> fleetList = new ArrayList<String>();
		try 
		{
			File file = new File("fleet.txt");
			reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null)
			{
				fleetList.add(line);
			}
			fleet = new String[fleetList.size()][6];
			String[] selectAircraft;
			for (int j=0; j<fleetList.size(); j++)
			{
				line = fleetList.get(j);
				selectAircraft = line.split(" ");
				for (int k=0; k<4; k++)
				{
					fleet[j][k] = selectAircraft[k];
				}
				fleet[j][4] = "available"; // Initially set this element to "available"
						// to represent that aircraft is available to schedule a flight
						// will change to "inUse" when aircraft is not available
				fleet[j][5] = "ATL"; // Current/most-recent location of aircraft
					//initially this will be ATL
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				reader.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}	
	} // end setFleet
	
	public void initialize()
	{ // creates an arbitrary flight list- can be used for testing code
		Date currentTime = new Date();
		Random rand = new Random(12345);
		Flight newFlight = null;
		String destination;
		for (int i=0; i<fleet.length; i++)
		{
			if (fleet[i][4].equals("available"))
			{
				int city;
				do
				{
					city = rand.nextInt(29);
					destination = cities[city][0];
				} while (!cities[city][4].equals("na"));
				
				int flightTime = Integer.parseInt(cities[city][3]);
				SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
				cities[city][4] = ft.format(getArrivalDate(currentTime, flightTime)); // set new "last visited time"
					//for destination city to the estimated arrival time of flight
				
				String gate = getFreeGate();
				if (gate != null)
				{ // If there is a free gate, create flight
					// New flight constructed
					newFlight = new Flight(constructFlightID(), (i+1), getAircraftDirection(i),
							destination, currentTime,flightTime, gate);
					fleet[i][4] = "inUse"; //set plane to "inUse
					flightList.add(newFlight); //add new flight to flight list
				}
			}
		}
	}
	
	public Date getArrivalDate(Date currentDate, int flightTime)
	{ // adds second to parameter to first parameter and returns resulting date
		Date arrivalDate = new Date(currentDate.getTime()+(flightTime*60000));
		return arrivalDate;
	}
	
	public String getFreeGate()
	{ // returns first free gate ("Open") in list and sets gate status to  "inUse"
		int i =0;
		while (i<gates.length && !gates[i][1].equals("Open"))
		{
			i++;
		}
		if (i==gates.length) return null;
		else
		{
			gates[i][1] = "inUse";
			return gates[i][0];
		}
	}
	
	public boolean getAircraftDirection(int fleetNumber)
	{ //return false (departing flight) if the plane's most recent location is "ATL" 
		// true otherwise (arriving in ATL)
		if (fleet[fleetNumber][5].equals("ATL"))
		{
			return false;
		}
		else return true;
	}
	
	public String constructFlightID()
	{
		String newID;
		String maxID = null;
		String selectedID;
		if (flightList.size()>0)
		{
			maxID = flightList.get(0).getFlightID();
			for (int i=0; i<flightList.size(); i++)
			{
				selectedID = flightList.get(i).getFlightID();
				if (selectedID.compareTo(maxID)>0)
				{
					maxID = selectedID;
				}
			}
			String flightNum = maxID.substring(1);
			int flightNumber = Integer.parseInt(flightNum);
			flightNumber++;
			newID = "S"+flightNumber;
		} else
		{
			newID = "S101";
		}
		return newID;
	}
	
	public void addFlight(Flight newFlight)
	{ // adds new flight to list sorted by departure date
		int i = 0;
		if (flightList.size()>0)
		{
			while (newFlight.getDepartureDate().before(flightList.get(i).getDepartureDate()))
			{
				i++;
			}
			flightList.add(i, newFlight);
		} else flightList.add(newFlight);
	}
	
	public void removeFlightWithID(String flightID)
	{ //removes a flight by flightID
		for (int i=0; i<flightList.size(); i++)
		{
			if (flightList.get(i).getFlightID().equals(flightID))
			{
				flightList.remove(i);
			}
		}	
	}
	
	public Flight getNextFlight()
	{ //returns next scheduled flight
		return flightList.get(0);
	}
	
	public Flight getFlightWithID(String flightID)
	{ // returns flight with flightID or null if it doesn't exist
		for (int i =0; i< flightList.size();i++)
		{
			if (flightList.get(i).getFlightID().equals(flightID))
			{
				return flightList.get(i);
			}
		}
		return null;
	}
	
	public void printFlightList()
	{ // prints flight list to console "# FlightID Destination DepartureTime Gate Status"
		Flight selected;
		System.out.println("Number\tFlight ID\tDestination\tDeparture Date\tGate\tStatus");
		for (int i=0; i<flightList.size(); i++)
		{
			selected = flightList.get(i);
			System.out.println(i + ": " + selected.getFlightID() + "\t" + selected.getDestination() + "\t"
					+ selected.printDepartureDate() + "\t" + selected.getGate() + "\t" + selected.getStatus());
		}
	}
	
}