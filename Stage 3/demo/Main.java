// to test out select 4.) appointments then 2.) Add then 200 for cust id, then 100 for vehicle id  3 for num of days out, it will then print attributes of the 
// appointment that is in this case in position index 0, if we decide to go with it i can add the print appointments method, along with the others

// this is just to demonstrate a way in which we could implement an appointments class to be able to create/work with appointments
// the way i went about it was to create the class appointments, it holds all the other objects of the different classes (i.e. Customer,Vehicle, Employees) as attributes

// i also came up with a way that can calculate the cost associated with an appointment, it does require the user to know the days and miles associated with an appointment


// to test out select 4.) appointments then 2.) Add then 200 for cust id, then 100 for vehicle id  3 for num of days out, it will then print attributes of the 
// appointment that is in this case in position index 0, if we decide to go with it i can add the print appointments method, along with the others
import java.util.ArrayList;
import java.util.Scanner;


public class Main 
{
	static Scanner in = new Scanner(System.in);
	static ArrayList<Customer> customers = new ArrayList<>();  
	static ArrayList<Vehicle> vehicles = new ArrayList<>();
	static DataBaseActions action = new DataBaseActions();
	
	static ArrayList<Appointment> appointments = new ArrayList<>(); 
	
	
	public static void main(String[] args) 				// main method calls the first menu
	{
																						
		action.initiateDB(vehicles, customers);
		mainMenu(vehicles,customers);                 		// i think eventually all arrays will have to be passed through the main menu

	}

																						// this method calls the method that searches for customers, it is located in the data base actions class
	public static void searchCustomer(ArrayList<Customer> customers)					
	{
		action.searchCustomer(customers);
	}
	public static void searchCustomerOption(ArrayList<Customer> customers)				
	{																					// if this option is selected it will call the method that searches for a customer
		searchCustomer(customers);
	}
	public static void addCustomer(ArrayList<Customer> customers)
	{	
		action.addCustToDB(customers);
	}
	
	public static void addCustomerOption(ArrayList<Customer> customers)
	{
		addCustomer(customers);
	}
	public static void removeCustomer(ArrayList<Customer> customers)
	{
		action.removeCustFromDB(customers);
	}
	public static void removeCustomerOption(ArrayList<Customer> customers)
	{
		removeCustomer(customers);
	}
	public static void modifyCustomer(ArrayList<Customer> customers)
	{
		action.modifyCustFromDB(customers);
	}
	public static void modifyCustomerOption(ArrayList<Customer> customers)
	{
		modifyCustomer(customers);
	}
	public static void printReport(ArrayList<Customer> customers)
	{
		action.printCustReport(customers);
	}
	public static void printReportOption(ArrayList<Customer> customers)
	{
		printReport(customers);
	}
	
	public static void customerMenu(ArrayList<Customer> customers)
	{
		int selection = showMenu();														// shows the customers menu options
		
		switch(selection)																// the option is checked
		{
		case 1:
			searchCustomer(customers);                   		
			customerMenu(customers);								// customer menu method is called after option is selected to keep the program running
			break;
		case 2:
			addCustomerOption(customers);                   		
			customerMenu(customers);
			break;
		case 3: 
			removeCustomerOption(customers);						// menu is called but with an updated parameter/ updated array
			customerMenu(customers);
			break;
		case 4: 
			modifyCustomerOption(customers);
			customerMenu(customers);
			break;
		case 5:
			printReportOption(customers);
			customerMenu(customers);
			break;
		case 6:
			mainMenu(vehicles, customers);
			
		}
		
	}
	
	public static void addAppointment(ArrayList<Appointment> appointments)
	{
		action.addAppointment(vehicles, customers,appointments);
	}
	public static void addAppointmentOption(ArrayList<Appointment> appointments)
	{
		addAppointment(appointments);
	}
	
	
	
	public static void appointmentMenu(ArrayList<Appointment> appointments)
	{
		int selection = showMenu();														// shows the customers menu options
		
		switch(selection)																// the option is checked
		{
//		case 1:
//			searchCustomer(customers);                   		
//			customerMenu(customers);								// customer menu method is called after option is selected to keep the program running
//			break;
		case 2:
			addAppointmentOption(appointments);                   		
			appointmentMenu(appointments);
			break;
//		case 3: 
//			removeCustomerOption(customers);						// menu is called but with an updated parameter/ updated array
//			customerMenu(customers);
//			break;
//		case 4: 
//			modifyCustomerOption(customers);
//			customerMenu(customers);
//			break;
//		case 5:
//			printReportOption(customers);
//			customerMenu(customers);
//			break;
//		case 6:
//			mainMenu(customers);
			
		}
		
	}
		
	
	public static void mainMenu(ArrayList<Vehicle> vehicles, ArrayList<Customer> customers)															// first menu will lead to more menus
	{
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Select an option: \n1.) Customers \n2.) Vehicles \n3.) Employees \n4.) Appointments \n5.) Quit");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		int selection;
		selection = in.nextInt();
		in.nextLine();
		while( selection >5 || selection <0)
		{
			System.out.printf("You selected %d \n", selection);
			System.out.println("invalid option");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("Select an option: \n1.) Customers \n2.) Vehicles \n3.) Employees \n4.) Other \n5.) Quit");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			selection = in.nextInt();
			in.nextLine();
		}
		System.out.printf("You selected %d \n", selection);
		
		switch(selection)
		{
		case 1:
			customerMenu(customers);                   							// only the customer option is working right now
			break;
//		case 2:
//			vehicleMenu(customers);
//			break;
//		case 3: 
//			employeeMenu(customers));						
//			break;
		case 4: 
			appointmentMenu(appointments);        // do you need to pass customers through as param..... i dont think so because you wont be midifying it just acccessing it...
			break;
		case 5:
			System.out.println("bye.");			// only in option 5 is menu method no longer called
		}
		
		
		
	}
	public static int showMenu()   																	// just a method to print menu options for the sub menus
	{
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Select an option: \n1.) Search ID \n2.) Add \n3.) Remove \n4.) Modify \n5.) Print Report \n6.) Main Menu");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		int selection;
		selection = in.nextInt();
		in.nextLine();
		while( selection >6 || selection <0)
		{
			System.out.printf("You selected %d \n", selection);
			System.out.println("invalid option");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("Select an option: \n1.) Search ID \n2.) Add \n3.) Remove \n4.) Modify \n5.) Print Report \n6.) Quit");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			selection = in.nextInt();
			in.nextLine();
		}
		System.out.printf("You selected %d \n", selection);
		
		return selection;
	}
	
	

}