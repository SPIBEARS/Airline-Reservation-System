package ARS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FlightReservation
{
	Scanner input;
	String tripType; // will be "roundtrip" or "oneway"
	String destination;
	Date departureDate, returnDate;
	int numberOfPassengers;
	
	public FlightReservation()
	{
		input = new Scanner(System.in);
	}
	
	public void prompt()
	{
		promptTripType();
		promptDestination();
		promptDepartureDate();
		if (tripType.equals("roundtrip"))
		{
			promptReturnDate();
		}
		promptNumberOfPassengers();
		printChoices();
	}
	
	public void promptTripType()
	{
		boolean correctResponse = false;
		do 
		{
			System.out.println("Select one option (1 or 2):\nRoundtrip (1)\nOne-way (2)");
			String tripChoice = input.nextLine();
			if (tripChoice.equals("1") || tripChoice.equalsIgnoreCase("Roundtrip")
					|| tripChoice.equalsIgnoreCase("Round Trip"))
			{
				tripType = "roundtrip";
				correctResponse = true;
			} else if (tripChoice.equals("2") || tripChoice.equalsIgnoreCase("One-way")
					|| tripChoice.equalsIgnoreCase("Oneway") || tripChoice.equalsIgnoreCase("One way"))
			{
				tripType = "oneway";
				correctResponse = true;
			}
			else
			{
				System.out.println("Invalid response.. please type \"1\" or \"2\"");
			}
		} while (!correctResponse);
	}
	
	public void promptDepartureDate()
	{
		boolean correctResponse = false;
		SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy");
		do 
		{
			System.out.println("Enter departure date (mm/dd/yyyy):");
			String choice = input.nextLine();
			try
			{
				departureDate = ft.parse(choice);
				correctResponse = true;
			} catch (ParseException e)
			{
				System.out.println("Invalid date - please use mm/dd/yyyy format");
			}
		} while (!correctResponse);
	}
	
	public void promptReturnDate()
	{
		boolean correctResponse = false;
		SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy");
		do 
		{
			System.out.println("Enter return date (mm/dd/yyyy):");
			String choice = input.nextLine();
			try
			{
				returnDate = ft.parse(choice);
				correctResponse = true;
			} catch (ParseException e)
			{
				System.out.println("Invalid date - please use mm/dd/yyyy format");
			}
		} while (!correctResponse);
	}
	
	public void promptDestination()
	{
		boolean correctResponse = false;
		do 
		{
			System.out.println("Select your destination (1-29):\nBeijing (1)\nChicago (2)\nLondon (3)\nTokyo (4)"
					+ "\nLos Angeles (5)\nParis (6)\nDallas (7)\nFrankfurt (8)\nDenver (9)\nHong Kong (10)\nMadrid (11)"
					+ "\nDubai (12)\nNew York (13)\nAmsterdam (14)\nJakarta (15)\nBangkok (16)\nSingapore (17)\nGuangzhou (18)"
					+ "\nShanghai (19)\nHouston (20)\nLas Vegas (21)\nSan Francisco (22)\nPhoenix (23)\nCharlotte (24)"
					+ "\nRome (25)\nSydney (26)\nMiami (27)\nOrlando (28)\nMunich (29)");
			String destinationChoice = input.nextLine();
			if (destinationChoice.equals("1") || destinationChoice.equalsIgnoreCase("Beijing"))
			{
				destination = "Beijing";
				correctResponse = true;
			} else if (destinationChoice.equals("2") || destinationChoice.equalsIgnoreCase("Chicago"))
			{
				destination = "Chicago";
				correctResponse = true;
			} else if (destinationChoice.equals("3") || destinationChoice.equalsIgnoreCase("London"))
			{
				destination = "London";
				correctResponse = true;
			} else if (destinationChoice.equals("4") || destinationChoice.equalsIgnoreCase("Tokyo"))
			{
				destination = "Tokyo";
				correctResponse = true;
			} else if (destinationChoice.equals("5") || destinationChoice.equalsIgnoreCase("LosAngeles")
					|| destinationChoice.equals("Los Angeles"))
			{
				destination = "Los Angeles";
				correctResponse = true;
			} else if (destinationChoice.equals("6") || destinationChoice.equalsIgnoreCase("Paris"))
			{
				destination = "Paris";
				correctResponse = true;
			} else if (destinationChoice.equals("7") || destinationChoice.equalsIgnoreCase("Dallas"))
			{
				destination = "Dallas";
				correctResponse = true;
			} else if (destinationChoice.equals("8") || destinationChoice.equalsIgnoreCase("Frankfurt"))
			{
				destination = "Frankfurt";
				correctResponse = true;
			} else if (destinationChoice.equals("9") || destinationChoice.equalsIgnoreCase("Denver"))
			{
				destination = "Denver";
				correctResponse = true;
			} else if (destinationChoice.equals("10") || destinationChoice.equalsIgnoreCase("Hong Kong")
					|| destinationChoice.equalsIgnoreCase("HongKong"))
			{
				destination = "Hong Kong";
				correctResponse = true;
			} else if (destinationChoice.equals("11") || destinationChoice.equalsIgnoreCase("Madrid"))
			{
				destination = "Madrid";
				correctResponse = true;
			} else if (destinationChoice.equals("12") || destinationChoice.equalsIgnoreCase("Dubai"))
			{
				destination = "Dubai";
				correctResponse = true;
			} else if (destinationChoice.equals("13") || destinationChoice.equalsIgnoreCase("New York")
					|| destinationChoice.equalsIgnoreCase("NewYork"))
			{
				destination = "New York";
				correctResponse = true;
			} else if (destinationChoice.equals("14") || destinationChoice.equalsIgnoreCase("Jakarta"))
			{
				destination = "Jakarta";
				correctResponse = true;
			} else if (destinationChoice.equals("15") || destinationChoice.equalsIgnoreCase("Amsterdam"))
			{
				destination = "Amsterdam";
				correctResponse = true;
			} else if (destinationChoice.equals("16") || destinationChoice.equalsIgnoreCase("Bangkok"))
			{
				destination = "Bangkok";
				correctResponse = true;
			} else if (destinationChoice.equals("17") || destinationChoice.equalsIgnoreCase("Singapore"))
			{
				destination = "Singapore";
				correctResponse = true;
			} else if (destinationChoice.equals("18") || destinationChoice.equalsIgnoreCase("Guangzhou"))
			{
				destination = "Guangzhou";
				correctResponse = true;
			} else if (destinationChoice.equals("19") || destinationChoice.equalsIgnoreCase("Shanghai"))
			{
				destination = "Shanghai";
				correctResponse = true;
			} else if (destinationChoice.equals("20") || destinationChoice.equalsIgnoreCase("Houston"))
			{
				destination = "Houston";
				correctResponse = true;
			} else if (destinationChoice.equals("21") || destinationChoice.equalsIgnoreCase("Las Vegas")
					|| destinationChoice.equalsIgnoreCase("LasVegas"))
			{
				destination = "Las Vegas";
				correctResponse = true;
			} else if (destinationChoice.equals("22") || destinationChoice.equalsIgnoreCase("San Francisco")
					|| destinationChoice.equalsIgnoreCase("SanFrancisco"))
			{
				destination = "San Francisco";
				correctResponse = true;
			} else if (destinationChoice.equals("23") || destinationChoice.equalsIgnoreCase("Phoenix"))
			{
				destination = "Phoenix";
				correctResponse = true;
			} else if (destinationChoice.equals("24") || destinationChoice.equalsIgnoreCase("Charlotte"))
			{
				destination = "Charlotte";
				correctResponse = true;
			} else if (destinationChoice.equals("25") || destinationChoice.equalsIgnoreCase("Rome"))
			{
				destination = "Rome";
				correctResponse = true;
			} else if (destinationChoice.equals("26") || destinationChoice.equalsIgnoreCase("Sydney"))
			{
				destination = "Sydney";
				correctResponse = true;
			} else if (destinationChoice.equals("27") || destinationChoice.equalsIgnoreCase("Miami"))
			{
				destination = "Miama";
				correctResponse = true;
			} else if (destinationChoice.equals("28") || destinationChoice.equalsIgnoreCase("Orlando"))
			{
				destination = "Orlando";
				correctResponse = true;
			} else if (destinationChoice.equals("29") || destinationChoice.equalsIgnoreCase("Munich"))
			{
				destination = "Munich";
				correctResponse = true;
			}
			else
			{
				System.out.println("Invalid response.. please type a number from \"1\" to \"29\"");
			}
		} while (!correctResponse);
	}
	
	public void promptNumberOfPassengers()
	{
		boolean correctResponse = false;
		do 
		{
			System.out.println("Enter number of passengers:");
			String choice = input.nextLine();
			try
			{
				numberOfPassengers = Integer.parseInt(choice);
				if (numberOfPassengers>0)
				correctResponse = true;
				else {
					System.out.println("Invalid response - please enter a number greater than 0");
				}
			} catch (NumberFormatException e)
			{
				System.out.println("Invalid response - please enter a number greater than 0");
			}
			
		} while (!correctResponse);
	}
	
	public void printChoices()
	{
		if (tripType.equals("roundtrip"))
		{
			System.out.println("Your choices are:\nTrip type: " + tripType + "\nDestination: " + destination + "\nDeparture date: " + departureDate + 
					"\nReturn date: " + returnDate + "\nNumber of passengers: "+ numberOfPassengers);
		}
		System.out.println("Your choices are:\nTrip type: " + tripType + "\nDestination: " + destination + "\nDeparture date: " + departureDate + 
				 "\nNumber of passengers: "+ numberOfPassengers);
	}
	
}