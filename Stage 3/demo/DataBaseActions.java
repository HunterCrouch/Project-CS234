
import java.util.ArrayList;
import java.util.Scanner;

public class DataBaseActions 


{
	Scanner in = new Scanner(System.in);
	
	private int custIndex = -1;						     // set at -1 so it can start at zero .... because the index gets updated before in the add method not after						
	private int vehicleIndex = -1;						// will be used for other vehicle array
	private int appointmentIndex = -1;
	
	
	
	
	
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
		
			String custName;
			String custAddress;  												
			
			System.out.println("enter cust Name: ");						
			custName = in.nextLine();
			
			System.out.println("enter cust Adress: ");
			custAddress = in.nextLine();
			
			
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
	
	public int searchVehicleID(String ID, ArrayList<Vehicle> vehicles)					// searches ids and returns the index they are located
	{
		int index = -1;																		
		for (int i = 0; i< vehicles.size(); i++)
		{
			if (vehicles.get(i).getVehicleID().equals(ID))													
			{
				index = i;
			}
		}
		
		return index;
	}

	
	public void addCarToDB()																
	{																						
		
		
		vehicleIndex++;                 
	}
	
	public void initiateDB(ArrayList<Vehicle> vehicles, ArrayList<Customer> customers)
	{
		
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
		
		Vehicle vehicle = new Vehicle();
		Vehicle vehicle2 = new Vehicle();
		Vehicle vehicle3 = new Vehicle();
		
		vehicles.add(vehicle);
		vehicles.add(vehicle2);
		vehicles.add(vehicle3);
		
		vehicles.get(0).setVehicleID("100");
		vehicles.get(0).setVehicleModel("Camry");
		vehicles.get(0).setVehicle50MileRate(20); 
		vehicles.get(0).setVehicleDayRate(50);
		vehicleIndex++;
		
		vehicles.get(1).setVehicleID("101");
		vehicles.get(1).setVehicleModel("Acord");
		vehicles.get(1).setVehicle50MileRate(20); 
		vehicles.get(1).setVehicleDayRate(51);
		vehicleIndex++;
		
		vehicles.get(2).setVehicleID("102");
		vehicles.get(2).setVehicleModel("Maxima");
		vehicles.get(2).setVehicle50MileRate(20); 
		vehicles.get(2).setVehicleDayRate(52);
		vehicleIndex++;
		
		
		
	}
	
	// essentially this method gets an object from the other arrays and sets it as an attribute for the newly created object of the class Appointment and 
	// adds that appointment object to the array of appointments ( which in this case its index is 0)
	// the way it gets the right object to add as an attribute is by using the search method to get the index
	// in addition it also asks users to provide the days/ time they will be gone. it adds that value to an attribute of the appointment object 
	// then it calculates the bill/ cost of the trip, and also adds it as an attribute of the appointment object
	
	// this all goes back to the whole idea of objects existing in the arraylist
	// not on there own... so every time you want to access a particular attribute of a particular object you have to 
	//Reference it's position in the list.... which kinda makes a mess/ hard to follow

	public void addAppointment(ArrayList<Vehicle> vehicles, ArrayList<Customer> customers, ArrayList<Appointment> appointments)                                      
	{
		appointmentIndex ++;
		String appointmentID;                                         	
		String carID;													
		String custID;													// have to use a 2d ArrayList
		
		Appointment appointment = new Appointment();
		appointments.add(appointment);
		
		System.out.println("Enter customer ID to add: ");
		custID = in.nextLine();
		int carIndex = searchCustID(custID, customers);								// once we have the index that is associated with the id, we can print the attributes of the customer object
		
		if (carIndex != -1)
		{
			appointments.get(appointmentIndex).setCustomer(customers.get(carIndex));  // program will probably have to end if an invalid id is entered
										
		}
		else
		{
			System.out.println("The id selected does not exist");
		}
		
		System.out.println("Enter the car id you want to add: ");
		String vehicleID = in.nextLine();
		int vehicleIndex = searchVehicleID(vehicleID,vehicles);
		
		if (vehicleIndex != -1)
		{
			appointments.get(appointmentIndex).setVehicle(vehicles.get(vehicleIndex));
		}
		else
		{
			System.out.println("The id selected does not exist");
		}
		
		
		System.out.println("enter number of days out");                                        // program relys on the user to calculate the days gone ... and the miles driven , although there is 
		 																					   // probably a way to have the program calculate it for the user.
		int days = in.nextInt();
		appointments.get(appointmentIndex).setTime(days);
		
		appointments.get(appointmentIndex).setBill(appointments.get(appointmentIndex).getVehicle().getVehicleDayRate() * days);      
		
		
		System.out.println("the person making the appointment is: " + appointments.get(0).getCustomer().getCustName());     						// only to show that we could add customer objects to the appointment object and access an attribute from it
		System.out.println("Total cost is: " + appointments.get(0).getBill());							// only to show that the appointment exist in the array, and holds the value of the calculation just made
	}

	
		
		
		
			
	
}