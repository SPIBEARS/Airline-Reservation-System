package ARS;
/*
 * SPIBE Airline Reservation Payment Gateway
 * Author: John Bent
 * Last date modified: October 5, 2016
 * 
 * Payment Gateway class is responsible for prompting
 * the user for payment information after the selection 
 * of desired seat(s) on flight(s). Payment Gateway Window
 * is displayed with fields indicating required user input.
 * 
 * All input information is stored with flyer information in 
 * the flight database.
 */

public class PaymentGateway
{
	
	public PaymentGateway()
	{
		/*
		 * Default constructor is invoked from the Flight Summary
		 * window when user accepts the flight details.
		 * 
		 * Pre: Flight Summary window is open.
		 * Post: FLight summary window closed. PaymentGateway window
		 * now open.
		 */
	}
	
	public void checkPayment()
	{
		/* This method checks the validity of a payment 
		 * type (credit card) with the customer's bank.
		 * 
		 * pre: User has entered Customer's payment information
		 * Post: If payment is valid, the Customer info is stored in database,
		 * transaction is permitted, and the customer is provided with ticket(s)
		 * If payment method is invalid, the transaction will not be permitted, and the 
		 * user will be asked to provide an alternate form of payment.
		 */
	}
	
	public void createTicket()
	{
		/*
		 * This method is called when the user clicks the "Submit" button
		 * after filling in the required fields with their payment information.
		 * It performs the checkPayment method, closes the Payment Gateway window,
		 * and opens an eTicket window.
		 * 
		 * pre: User has provided required payment information. The checkPayment
		 * method approves the payment.
		 * Post: Customer information stored in database and flight availability 
		 * updated to reflect reserved seats. Customer is provided with ticket through
		 * email and instant eTicket window.
		 */
	}
	
}