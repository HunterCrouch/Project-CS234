
import java.util.ArrayList;
import java.util.Scanner;

public class DataBaseActions 


{
	Scanner in = new Scanner(System.in);
	
	private int custIndex = -1;						     // set at -1 so it can start at zero .... because the index gets updated before in the add method not after						
	private int vehicleIndex = 1;						// will be used for other vehicle array
	private int appointmentIndex = 0;
	
		
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
	public void removeVehicleFromDB( ArrayList<Vehicle> vehicles)    	
	{
		int vehicleID;
		System.out.println("Enter vehicle ID to remove: ");
		vehicleID = in.nextInt();

		int index = -1;																		
		for (int i = 0; i< vehicles.size(); i++)
		{
			if (vehicles.get(i).getVehicleID()==vehicleID)													
			{
				index = i;
			}
		}
		if (index != -1)
		{
			vehicles.remove(index);
			vehicleIndex --;
		}
		else
		{
			System.out.println("The id selected does not exist");
		}
	}
	public void searchVehicle(ArrayList<Vehicle>vehicles)
	{
		int vehicleID;
		System.out.println("Enter vehicle ID to search: ");
		vehicleID = in.nextInt();

		int index = -1;																		
		for (int i = 0; i< vehicles.size(); i++)
		{
			if (vehicles.get(i).getVehicleID()==vehicleID)													
			{
				index = i;
			}
		}

		if (index != -1)
		{
			System.out.println(vehicles.get(index));							
		}
		else
		{
			System.out.println("The id selected does not exist");
		}
	}
	public void addVehicleToDB(ArrayList<Vehicle> vehicles)
	{
		String vehicleType="";
		int x =0;

		System.out.println("enter Type of vehicle(Van,Car, or Truck): ");
		vehicleType = in.nextLine();
		if(vehicleType.equals("Van")||vehicleType.equals("Car")||vehicleType.equals("Truck"))
		{
			x=0;
		}
		else
		{
			System.out.println("Invalid option");
			x=1;
		}
		if(x==1)
		{
			return;
		}
		Van van = new Van();
		Car car = new Car();
		Truck truck = new Truck();

		double ratePer25Mile=0;//
		double ratePerDay=0;//
		String plateNumber="";//
		int mileage=0;//
		double gasInGals=0;//
		boolean rentStatus=true;//
		int spotInPark=0;//
		boolean maintenance=true;//
		int vehicleID=0;//
		//String vehicleModel;
		boolean manual=true;//
    	String make="";//
    	int year=0;//
    	String color=""; //
		
		System.out.println("enter year: ");
		year = in.nextInt();

		System.out.println("enter color: ");
		color = in.next();

		System.out.println("enter make: ");
		make = in.next();

		System.out.println("enter true if it is manual false otherwise: ");
		manual = in.nextBoolean();

		System.out.println("enter the rate to charge per 25 miles: ");
		ratePer25Mile = in.nextDouble();

		System.out.println("enter the rate to charge per day: ");
		ratePerDay = in.nextDouble();

		System.out.println("enter the plate number: ");
		plateNumber = in.next();

		System.out.println("enter the current milleage: ");
		mileage = in.nextInt();

		System.out.println("enter current gas in gallons: ");
		gasInGals = in.nextDouble();

		System.out.println("enter rent status(true or false): ");
		rentStatus = in.nextBoolean();

		System.out.println("enter spot in parking lot: ");
		spotInPark = in.nextInt();

		System.out.println("enter true if in maintenance false for not: ");
		maintenance = in.nextBoolean();

		System.out.println("enter vehicle id number(four digits): ");
		vehicleID = in.nextInt();
		if(vehicleType.equals("Van"))
		{
			van.set25Rate(ratePer25Mile);
			van.setPerDayRate(ratePerDay);
			van.setPlateNum(plateNumber);
			van.setMileage(mileage);
			van.setGasInTank(gasInGals);
			van.setRentStat(rentStatus);
			van.setParkSpot(spotInPark);
			van.setMaint(maintenance);
			van.setVehicleID(vehicleID);
			van.setManual(manual);
			van.setMake(make);
			van.setYear(year);
			van.setColor(color);
			vehicles.add(van);
			vehicleIndex++;
		}
		else if(vehicleType.equals("Car"))
		{
			car.set25Rate(ratePer25Mile);
			car.setPerDayRate(ratePerDay);
			car.setPlateNum(plateNumber);
			car.setMileage(mileage);
			car.setGasInTank(gasInGals);
			car.setRentStat(rentStatus);
			car.setParkSpot(spotInPark);
			car.setMaint(maintenance);
			car.setVehicleID(vehicleID);
			car.setManual(manual);
			car.setMake(make);
			car.setYear(year);
			car.setColor(color);
			vehicles.add(car);
			vehicleIndex++;
		}
		else if(vehicleType.equals("Truck"))
		{
			truck.set25Rate(ratePer25Mile);
			truck.setPerDayRate(ratePerDay);
			truck.setPlateNum(plateNumber);
			truck.setMileage(mileage);
			truck.setGasInTank(gasInGals);
			truck.setRentStat(rentStatus);
			truck.setParkSpot(spotInPark);
			truck.setMaint(maintenance);
			truck.setVehicleID(vehicleID);
			truck.setManual(manual);
			truck.setMake(make);
			truck.setYear(year);
			truck.setColor(color);
			vehicles.add(truck);
			vehicleIndex++;
		}
		
		
	}
	public void modifyVehicleFromDB(ArrayList<Vehicle> vehicles)
	{
		double ratePer25Mile=0;
		double ratePerDay=0;
		String plateNumber="";
		int mileage=0;
		double gasInGals=0;
		boolean rentStatus=true;
		int spotInPark=0;
		boolean maintenance=true;

		int vehicleID;
		System.out.println("Enter vehicle ID to search: ");
		vehicleID = in.nextInt();

		int index = -1;																		
		for (int i = 0; i< vehicles.size(); i++)
		{
			if (vehicles.get(i).getVehicleID()==vehicleID)													
			{
				index = i;
			}
		}

		if (index != -1)
		{
		System.out.println("enter the rate to charge per 25 miles: ");
		ratePer25Mile = in.nextDouble();

		System.out.println("enter the rate to charge per day: ");
		ratePerDay = in.nextDouble();

		System.out.println("enter the plate number: ");
		plateNumber = in.next();

		System.out.println("enter the current milleage: ");
		mileage = in.nextInt();

		System.out.println("enter current gas in gallons: ");
		gasInGals = in.nextDouble();

		System.out.println("enter rent status(true or false): ");
		rentStatus = in.nextBoolean();

		System.out.println("enter spot in parking lot: ");
		spotInPark = in.nextInt();

		System.out.println("enter true if in maintenance false for not: ");
		maintenance = in.nextBoolean();

		vehicles.get(index).set25Rate(ratePer25Mile);
		vehicles.get(index).setPerDayRate(ratePerDay);
		vehicles.get(index).setPlateNum(plateNumber);
		vehicles.get(index).setMileage(mileage);
		vehicles.get(index).setGasInTank(gasInGals);
		vehicles.get(index).setRentStat(rentStatus);
		vehicles.get(index).setParkSpot(spotInPark);
		vehicles.get(index).setMaint(maintenance);					
		}
		else
		{
			System.out.println("The id selected does not exist");
		}
	}
	public void printVehicleReport( ArrayList<Vehicle> vehicles)
	{
		for (int i = 0; i< vehicles.size(); i++)
		{
			System.out.println(vehicles.get(i));
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
	
	

	/*
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
	*/
	public void initiateDB(ArrayList<Customer> customers,ArrayList<Vehicle> vehicle)
	{
		// attempting to have a unique object in each index WORKS!!!!!!!!!!!!!
		Van van = new Van();
		Car car = new Car();
		Truck truck = new Truck();
		van.set25Rate(10.50);
		van.setPerDayRate(85.75);
		van.setPlateNum("GYK1235");
		van.setMileage(120135);
		van.setGasInTank(5);
		van.setRentStat(false);
		van.setParkSpot(3);
		van.setMaint(false);
		van.setVehicleID(1004);
		van.setManual(true);
		van.setMake("Ford Transit");
		van.setYear(2009);
		van.setColor("White");
		vehicle.add(van);
		vehicleIndex++;

		car.set25Rate(5.15);
		car.setPerDayRate(51.80);
		car.setPlateNum("BLX5248");
		car.setMileage(80458);
		car.setGasInTank(9);
		car.setRentStat(false);
		car.setParkSpot(2);
		car.setMaint(true);
		car.setVehicleID(1005);
		car.setManual(false);
		car.setMake("Toyota Camry");
		car.setYear(2015);
		car.setColor("Blue");
		vehicle.add(car);
		vehicleIndex++;

		truck.set25Rate(7.45);
		truck.setPerDayRate(67.55);
		truck.setPlateNum("BXY4689");
		truck.setMileage(150198);
		truck.setGasInTank(15);
		truck.setRentStat(true);
		truck.setParkSpot(4);
		truck.setMaint(false);
		truck.setVehicleID(1006);
		truck.setManual(true);
		truck.setMake("Ford F150");
		truck.setYear(2008);
		truck.setColor("Red");
		vehicle.add(truck);
		vehicleIndex++;

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