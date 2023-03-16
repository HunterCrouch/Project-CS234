
import java.util.ArrayList;
import java.util.Scanner;

public class DataBaseActions 


{
	Scanner in = new Scanner(System.in);
	
	private int custIndex = -1;						     // set at -1 so it can start at zero .... because the index gets updated before in the add method not after						
	private int vehicleIndex = 0;						// will be used for other vehicle array
	private int appointmentIndex = 0;
	
	ArrayList<Vehicle> vehicles = new ArrayList<>();	
	ArrayList<String> appointments = new ArrayList<>();
	
	Vehicle vehicle = new Vehicle();
	
	
	
	
	
	public int searchCustID(String ID, ArrayList<Customer> customers)					// searches ids and returns the index they are located
	{
		int index = -1;																		
		for (int i = 0; i< customers.size(); i++)
		{
			if (customers.get(i).getCustID().equals(ID))													
			{
				index = i;
			}
		}
		
		return index;
	}
	
	public void searchCustomer(ArrayList<Customer> customers)                                    
	{
		
		String custID;
		System.out.println("Enter customer ID to search: ");
		custID = in.nextLine();

		int index = searchCustID(custID, customers);								// once we have the index that is associated with the id, we can print the attributes of the customer object
		
		if (index != -1)
		{
			System.out.println(customers.get(index));							
		}
		else
		{
			System.out.println("The id selected does not exist");
		}
		
	}
	public void addCustToDB(ArrayList<Customer> customers)
	{
		custIndex++;														// needs to check if id is already being used
		String custID;
		String custName;
		String custAddress;  												
		Customer customer = new Customer(); 
		customers.add(customer);
		
		System.out.println("enter cust id: ");							
		custID = in.nextLine();												
		
		System.out.println("enter cust Name: ");						
		custName = in.nextLine();
		
		System.out.println("enter cust Adress: ");
		custAddress = in.nextLine();
		
		
		customers.get(custIndex).setCustID(custID);
		customers.get(custIndex).setCustName(custName);
		customers.get(custIndex).setCustAddress(custAddress);	
	}
	public void removeCustFromDB( ArrayList<Customer> customers)    	
	{
		String custID;
		
		System.out.println("Enter customer ID: ");
		custID = in.nextLine();
		
		int index = searchCustID(custID, customers);
		if (index != -1)
		{
			customers.remove(index);
			custIndex --;
		}
		else
		{
			System.out.println("The id selected does not exist");
		}
	}
	public void modifyCustFromDB(ArrayList<Customer> customers)
	{
		String custID;
		
		System.out.println("Enter customer ID: ");
		custID = in.nextLine();
		int index = searchCustID(custID, customers);
		if (index != -1)
		{
			//String newCustID;
			String custName;
			String custAddress;  												
			
			//System.out.println("enter cust id: ");							// not sure if should ask if to change id?
			//newCustID = in.nextLine();												
			
			System.out.println("enter cust Name: ");						
			custName = in.nextLine();
			
			System.out.println("enter cust Adress: ");
			custAddress = in.nextLine();
			
			
			//customers.get(index).setCustID(newCustID);
			customers.get(index).setCustName(custName);
			customers.get(index).setCustAddress(custAddress);
		}
		else
		{
			System.out.println("The id selected does not exist");
		}		
	}
	public void printCustReport( ArrayList<Customer> customers)
	{
		for (int i = 0; i< customers.size(); i++)
		{
			System.out.println(customers.get(i));
		}
	}
	
	

	
	public void addCarToDB()																
	{																						
		String vehicleID;
		String vehicleModel;
	
		
		vehicles.add(vehicle);
		
		System.out.println("enter vehicle id: ");
		vehicleID = in.next();
		
		System.out.println("enter cust Name: ");
		vehicleModel = in.next();
		
		
		
		vehicles.get(vehicleIndex).setVehicleID(vehicleID);
		vehicles.get(vehicleIndex).setVehicleModel(vehicleModel);
		
		
		
		vehicleIndex++;                 
	}
	
	public void initiateDB(ArrayList<Customer> customers)
	{
		// attempting to have a unique object in each index WORKS!!!!!!!!!!!!!
		Customer customer = new Customer();								
		Customer customer2 = new Customer();	
		Customer customer3 = new Customer();	
		
		customers.add(customer);
		customers.add(customer2);
		customers.add(customer3);
		
		customers.get(0).setCustID("200");     				
		customers.get(0).setCustName("Eduardo");
		customers.get(0).setCustAddress("mexio");
		custIndex++;
		
		customers.get(1).setCustID("201");								
		customers.get(1).setCustName("Emma");
		customers.get(1).setCustAddress("usa");
		custIndex++;
		
		customers.get(2).setCustID("203");
		customers.get(2).setCustName("john");
		customers.get(2).setCustAddress("usa");							
		custIndex++;																
	}	
	
	public void addAppointment()                                       // can use an appointment id.... it will be the first element.
	{
		String appointmentID;                                         	// one appointment will take a whole row so will probably need a 2d array........
		String carID;													// and if dont want to create methods for each array action
		String custID;													// have to use a 2d ArrayList
		
		
		System.out.println("enter the appointment id");
		appointmentID = in.nextLine();
		System.out.println("enter the car id");						
		carID = in.nextLine();										
		System.out.println("enter the customer id");
		carID = in.nextLine();
			
	}
	public void searchAppointment()
	{
		
	}
		
		
		
			
	
}