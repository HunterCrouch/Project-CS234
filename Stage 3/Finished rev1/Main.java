// only the customer's menu works
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner in = new Scanner(System.in);
	static ArrayList<Customer> customers = new ArrayList<>(); 
	static ArrayList<Vehicle> vehicles = new ArrayList<>();
	static ArrayList<Employee> employees = new ArrayList<>();
	static ArrayList<Payment> payments = new ArrayList<>();
	static DataBaseActions action = new DataBaseActions();
	
	
	public static void main(String[] args) { // main method calls the first menu

																						
		action.initiateDB(customers,vehicles,employees,payments);
		//Payment py = new Payment(vehicles.get(0),customers.get(0));	
		mainMenu();

	}

	public static void vehicleMenu(ArrayList<Vehicle> vehicles){
	 	
		int selection = showMenu();
		
		switch(selection)																
		{
		case 1:
			action.searchVehicle(vehicles);	
			vehicleMenu(vehicles);							
			break;
		case 2:
			action.addVehicleToDB(vehicles);
			vehicleMenu(vehicles);
			break;
		case 3: 
			action.removeVehicleFromDB(vehicles);
			vehicleMenu(vehicles);
			break;
		case 4: 
			action.modifyVehicleFromDB(vehicles);
			vehicleMenu(vehicles);
			break;
		case 5:
			System.out.println("List of Vehicles in our car lot:");
			action.printVehicleReport(vehicles);
			vehicleMenu(vehicles);
			break;
		case 6:
			mainMenu();
			
		}
	}
	public static void customerMenu(ArrayList<Customer> customers)
	{
		int selection = showMenu();// shows the customers menu options
		
		switch(selection)// the option is checked
		{
		case 1:
			action.searchCustomer(customers);                   		
			customerMenu(customers);// customer menu method is called after option is selected to keep the program running
			break;
		case 2:
			action.addCustToDB(customers);                   		
			customerMenu(customers);
			break;
		case 3: 
			action.removeCustFromDB(customers);// menu is called but with an updated parameter/ updated array
			customerMenu(customers);
			break;
		case 4: 
			action.modifyCustFromDB(customers);
			customerMenu(customers);
			break;
		case 5:
			System.out.println("List of Customers are listed below:");
			action.printCustReport(customers);
			customerMenu(customers);
			break;
		case 6:
			mainMenu();
			
		}
		
	}
	public static void employeeMenu(ArrayList<Employee> employee)
	{
		int selection = showMenu();														
		
		switch(selection)																
		{
		case 1: 
			int i=action.searchEmployee(employee);
			if(i>=0){
				System.out.println(employee.get(i));
			}
			employeeMenu(employee);	
			break;							
		case 2:
			action.addEmployeeToDB(employee);
			employeeMenu(employee);	
			break;
		case 3: 
			action.removeEmployeeFromDB(employees);						
			employeeMenu(employee);	
			break;
		case 4: 
			action.modifyEmployeeFromDB(employee);
			employeeMenu(employee);	
			break;
		case 5:
			System.out.println("The List of Employee's are listed below:");
			action.printEmployeeReport(employee);
			employeeMenu(employee);	
			break;
		case 6:
			mainMenu();
			
		}
		
	}
	public static void paymentMenu(ArrayList<Payment> payments,ArrayList<Customer>customer)
	{
		int selection = showMenu();														
		
		switch(selection)																
		{
		case 1:
			action.searchPayments(customer, payments);
			paymentMenu(payments,customer);
			break;							
		case 2:
			action.createPayment(customer, vehicles, payments);
			paymentMenu(payments,customer);
			break;
		case 3: 
			action.removePaymentFromDB(customer, payments);
			paymentMenu(payments,customer);	
			break;
		case 4: 
			action.modifyPayments(customer, vehicles, payments);
			paymentMenu(payments,customer);
			break;
		case 5:
			System.out.println("Payment Information listed below:");
			action.printPayments(payments);
			paymentMenu(payments,customer);
			break;
		case 6:
			mainMenu();
		}
		
	}	
	
	public static void mainMenu() {// first menu will lead to more menus
		System.out.println("Welcome to Our Car Rental Management System");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Select an option: \n1.) Customers \n2.) Vehicles \n3.) Employees \n4.) Payment \n5.) Quit");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		int selection;
		selection = in.nextInt();
		in.nextLine();
		while( selection >5 || selection <0)
		{
			System.out.printf("You selected %d \n", selection);
			System.out.println("invalid option");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("Select an option: \n1.) Customers \n2.) Vehicles \n3.) Employees \n4.) Payment \n5.) Quit");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			selection = in.nextInt();
			in.nextLine();
		}
		System.out.printf("You selected %d \n", selection);
		
		switch(selection)
		{
		case 1:
			customerMenu(customers);// only the customer option is working right now
			break;
		case 2:
			vehicleMenu(vehicles);
			break;
		case 3: 
			employeeMenu(employees);						
			break;
		case 4: 
			paymentMenu(payments,customers);
			break;
		case 5:
			System.out.println("bye.");// only in option 5 is menu method no longer called
		}
		
		
		
	}
	public static int showMenu()// just a method to print menu options for the sub menus
	{
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Select an option: \n1.) Search ID/Name  \n2.) Add \n3.) Remove \n4.) Modify \n5.) Print Report \n6.) Main Menu");
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
