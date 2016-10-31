package ARS;

// The PNR class will store an array list of Passenger objects that are created
// when the employee inputs passenger information

import java.util.ArrayList;



public class PassengerNameRecord {
	
	   ArrayList<Passenger> PNR = new ArrayList<Passenger>();
	   
	   
	   public void add(Passenger passenger){
		   PNR.add(passenger);
	   }
	   
	   public void remove(Passenger passenger){
		   PNR.remove(passenger);
	   }
	   public void print(){
		  for(int i = 0; i < PNR.size(); i++){
			 Passenger passenger = PNR.get(i);
			  System.out.println(passenger.name+","+passenger.status+","+passenger._class+","+Integer.toString(passenger.contact)+","+passenger.specialRequest);
		  }
		   
	   }
}
