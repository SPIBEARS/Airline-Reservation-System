

// Driver that has the main method, which will prompt user to input passenger information
// then it tries to create a new Passenger object with this information



import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Driver {
	public static void main(String args[]){
		PassengerNameRecord table = new PassengerNameRecord();
		for(int i=0; i<2; i= i+1) {
				Scanner sc=new Scanner(System.in);
			   System.out.println("Enter passenger's Name");
			  // Scanner s = new Scanner(sc).useDelimiter("\\s");  
			   String name=sc.next();
			   System.out.println("Enter passenger's Status");
			   String status = sc.next();
			   System.out.println("Enter passenger's Class");
			   String _class = sc.next();
			   System.out.println("Enter passenger's Contact Number");
			   int number = sc.nextInt();
			   System.out.println("Enter passenger's Special Request");
			   String specialRequest = sc.next();

			   Passenger p = new Passenger(name, status, _class, number, specialRequest);		
			   
			   table.add(p);
			   System.out.println("successfully added passenger");
		}
		
		table.print();
	}
	
	
}
