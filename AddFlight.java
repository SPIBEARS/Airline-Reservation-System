package ARS;

import java.util.*;

public class AddFlight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		List<String> list = new ArrayList<String>(50);
		
        do {
            System.out.println("Current flights are as follows " + list);
            System.out.println("Add flight? (y/n)");
            if (sc.next().startsWith("y")) {
                System.out.println("Enter Departure Location: ");
                list.add(sc.next());
                System.out.println("Enter Destination: ");
                list.add(sc.next());
                System.out.println("Enter Departure Date: ");
                list.add(sc.next());
                System.out.println("Enter Plane: "); 
                for (int z = 0; z<1; z++){       		    
                	String input = sc.nextLine();
        		    if(list.contains(input)){
        		        System.out.println("Plane is Unavailable please enter an Available plane to add flight.");
        		        z--;
        		    }
        		    else{
        		        list.add(input);
        		    }
        		}                	
                System.out.println("Enter Gate: ");        		    
                for (int z = 0; z<1; z++){
                	String input = sc.nextLine();
        		    if(list.contains(input)){
        		        System.out.println("Gate is currently Unavailable please enter an Available Gate.");
        		        z--;
        		    }
        		    else{
        		        list.add(input);
        		    }
        		}
                
            } else {
                break;
            }
        } while (true);

        System.out.println("Current Flight List: " + list);
	}

}
