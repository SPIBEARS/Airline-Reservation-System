package ARS;
/*
 * SPIBE Airline Reservation Home Screen
 * Author: John Bent
 * Last date modified: October 5, 2016
 * 
 * Home Screen class responsible for displaying terminal status view
 * and guiding users toward appropriate portal (employee or customer)
 */

public class HomeScreen
{
	
	public HomeScreen()
	{
		/* Constructor is called when program starts
		 * will initialize the terminal view at startup
		 */
	}
	
	public void simulateTerminal()
	{
		/*
		 * simulateTerminal allows the user to simulate the 
		 * terminal activity in scaled time for software
		 * demonstration purposes. The user clicks a simulate
		 * button and the terminal activity (flights and passengers
		 * coming and going) is shown in the home screen window
		 */
	}
	
	public void customerGateway()
	{
		/*
		 * This method is called when the user clicks the 
		 * customer button that says "Make Flight Reservation"
		 * It creates a flight reservation window where the
		 * user begins the process of making a reservation.
		 * 
		 * Post: Flight Reservation window is open. Home Screen is
		 * open and in background
		 */
	}
	
	public void employeeGateway()
	{
		/*
		 * This method is called when the user clicks the
		 * employee portal button that says "Employee Login"
		 * It creates a new employee login window where
		 * the employee enter their credentials.
		 * 
		 * Post: EMployee login window is open. Home screen
		 * remains open in background.
		 */
	}
	
	public void terminate()
	{
		/*
		 * This method serves as a way for the user to
		 * close the program completely. It can be called by
		 * clicking a button labeled "Close"
		 * 
		 * Post: ARS software terminates. All windows are closed.
		 */
	}
	
}