// this class is used to work with the arraylists of the objects ( Customer,Vehicle,Employee, and Payment)
// it holds various methods that bring in a arraylist and performs a CRUD (Modify, Delete, Add, Display) operation.
// in addition it holds a method that initializes each arraylist with pre-set values. 

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;

public class DataBaseActions 
{
	Scanner in = new Scanner(System.in);
	
	// this is a helper method for the searchCusomer method
	// it searches for a particular customer object using the 
	// customer id in the list of customers, and returns a 
	// -1 if it does not exist, or the index where the object is located
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
	// this method calls the helper method searchCust Id, and if a valid id is
	// found it displays the customer's attributes. 
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
	// this method adds a customer object to the list of customers,
	// it fist checks if the id you want to add is allready in the data
	// base, to prevent over writing. using the helper id it checks the IDs
	// if it is a new id than, an object of the class Customer is created
	// and its attributes are gathered, using prompts. then the object is added
	// to the arraylist of customers
	public void addCustToDB(ArrayList<Customer> customers)
	{
		String custID;
		System.out.println("Enter customer ID to search: ");
		custID = in.nextLine();														// needs to check if id is already being used
		int index = searchCustID(custID, customers);								// once we have the index that is associated with the id, we can print the attributes of the customer object
		if (index == -1)
		{
			String custName;
			String custAddress; 
			String pickUpTime;
			String dropOffTime;
			String licenseNum;
			String insurComp;
			String cardNum;
			boolean hasAppoint;
			boolean carLate;
			int choice1;  // variables to help with the boolean variables
			int choice2;
			
			Customer customer = new Customer(); 
	
			System.out.println("enter cust Name: ");						
			custName = in.nextLine();
			
			System.out.println("enter cust Adress: ");
			custAddress = in.nextLine();
			
			System.out.println("enter pick up time in mm/dd/yyyy format: ");
			pickUpTime = in.nextLine();
			
			System.out.println("enter drop off time in mm/dd/yyyy format: ");
			dropOffTime = in.nextLine();
			
			System.out.println("enter License number: ");
			licenseNum = in.nextLine();
			
			System.out.println("enter insurance company: ");
			insurComp = in.nextLine();
			
			System.out.println("enter credit card number: ");
			cardNum = in.nextLine();
			
			
			System.out.println("Does the customer have an appointment? enter 1 for yes and 0 for no:  ");
			choice1 = in.nextInt();
			if (choice1 == 1)
			{
				hasAppoint = true;
			}
			else
			{
				hasAppoint = false;
			}
			
			System.out.println("is the car late 1 is yes 0 is no:  ");
			choice2 = in.nextInt();
			if (choice2 == 1)
			{
				carLate = true;
			}
			else
			{
				carLate = false;
			}
			in.nextLine();  // just to clear scanner
			
			customer.setCustID(custID);
			customer.setCustName(custName);
			customer.setCustAddress(custAddress);
			customer.setPickUpTime(pickUpTime);
			customer.setDropOffTime(dropOffTime);
			customer.setLicenseNumber(licenseNum);
			customer.setIns(insurComp);
			customer.setCardNum(cardNum);
			customer.setHasAppointment(hasAppoint);
			customer.setCarLate(carLate);
			customers.add(customer);
		}
		else
		{
			System.out.println("That ID already exists.");
		}
	}
	
	// this method removes a cusomer object form the arraylist of customers
	// checks the if the ID exists using the search ID helper method.
	// if the ID is in the list then it removes it using the arraylist remove() method
	public void removeCustFromDB( ArrayList<Customer> customers)    	
	{
		String custID;
		
		System.out.println("Enter customer ID: ");
		custID = in.nextLine();
		
		int index = searchCustID(custID, customers);
		if (index != -1)
		{
			customers.remove(index);
		}
		else
		{
			System.out.println("The id selected does not exist");
		}
	}
	
	// this method modifies an existing object of the class customer in the arraylist 
	// customers. it uses the helper method search cust ID. then it uses the index it 
	// gets from the helper method to update the desired object in the arraylist.
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
			String pickUpTime;
			String dropOffTime;
			String licenseNum;
			String insurComp;
			String cardNum;
			boolean hasAppoint;
			boolean carLate;
			int choice1;
			int choice2;
				
			System.out.println("enter cust Name: ");						
			custName = in.nextLine();
			
			System.out.println("enter cust Adress: ");
			custAddress = in.nextLine();
			
			System.out.println("enter pick up time in mm/dd/yyyy format: ");
			pickUpTime = in.nextLine();
			
			System.out.println("enter drop off time in mm/dd/yyyy format: ");
			dropOffTime = in.nextLine();
			
			System.out.println("enter License number: ");
			licenseNum = in.nextLine();
			
			System.out.println("enter insurance company: ");
			insurComp = in.nextLine();
			
			System.out.println("enter credit card number: ");
			cardNum = in.nextLine();

			System.out.println("Does the customer have an appointment? enter 1 for yes and 0 for no:  ");
			choice1 = in.nextInt();
			if (choice1 == 1)
			{
				hasAppoint = true;
			}
			else
			{
				hasAppoint = false;
			}
			
			System.out.println("is the car late 1 is yes 0 is no:  ");
			choice2 = in.nextInt();
			if (choice2 == 1)
			{
				carLate = true;
			}
			else
			{
				carLate = false;
			}
			in.nextLine();  // just to clear scanner
			
			customers.get(index).setCustName(custName);
			customers.get(index).setCustAddress(custAddress);
			customers.get(index).setPickUpTime(pickUpTime);
			customers.get(index).setDropOffTime(dropOffTime);
			customers.get(index).setLicenseNumber(licenseNum);
			customers.get(index).setIns(insurComp);
			customers.get(index).setCardNum(cardNum);
			customers.get(index).setHasAppointment(hasAppoint);
			customers.get(index).setCarLate(carLate);
			
		}
		else
		{
			System.out.println("The id selected does not exist");
		}		
	}
	
	// this method prints all the attributes of the Customer class,
	// that are located in the arraylist using a for loop to traverse
	// each element, and utilizing the customer class's toString method
	public void printCustReport( ArrayList<Customer> customers)
	{
		for (int i = 0; i< customers.size(); i++)
		{
			System.out.println(customers.get(i));
		}
	}

	// this method removes a vehicle object from the vehicle arraylist,
	// it uses a condition to check if the ID exists, if it does then it 
	// uses the arraylist method remove() to delete the vehicle from the list
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
		}
		else
		{
			System.out.println("The id selected does not exist");
		}
	}
	
	// this method searches and displays a vehicle's attributes. the vehicle's ID is used to 
	// locate it in the arrayList 
        public int searchVehic(int id,ArrayList<Vehicle>vehicles)
        {
            int index = -1;																		
		for (int i = 0; i< vehicles.size(); i++)
		{
			if (vehicles.get(i).getVehicleID()==id)													
			{
				index = i;
			}
                }
            return index;
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
	// this method adds a vehicle object to the list of vehicles,
	// it fist checks what kind of vehicle you want to add. once a valid option is 
	// selected an object of the class child class vehicle is created
	// and its attributes are gathered, using prompts. then the object is added
	// to the arraylist of customers
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
		int y=-1;
		do
		{
			y=-1;
			System.out.println("enter vehicle id number(four digits): ");
			vehicleID = in.nextInt();
			for(int i=0;i<vehicles.size();i++)
			{
				if(vehicles.get(i).getVehicleID()==vehicleID)
				{
					y=0;
				}
			}
			if(y==-1)
			{
				break;
			}
			else
			{
				System.out.println("Id already exists");
			}
		}
		while(y==0);
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
		
		}
		
		
	}
	
	// this method modifies an existing object of the class vehicle in the arraylist 
	// vehicles. it searches for the index using the vehicle ID in a for-loop. then it uses the index it 
	// gets to update the desired object in the arraylist.
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
	
	// this method prints all the attributes of the Vehicle class,
	// that are located in the arraylist using a for loop to traverse
	// each element, and utilizing the Vehicle's toString method
	public void printVehicleReport( ArrayList<Vehicle> vehicles)
	{
		for (int i = 0; i< vehicles.size(); i++)
		{
			System.out.println(vehicles.get(i));
		}
	}
	public void closeDB(ArrayList<Customer> customers,ArrayList<Vehicle> vehicle,ArrayList<Employee> employees,ArrayList<Payment> payments)
        {
        try {
            // Creates a FileWriter
            FileWriter file = new FileWriter("Data.txt");

            // Writes the string to the file
            try ( // Creates a BufferedWriter
                    BufferedWriter output = new BufferedWriter(file)) {
                // Writes the string to the file
                for (int i = 0; i< customers.size(); i++)
                {
                    output.write("Cust");
                    output.write(" ");
                    output.write(customers.get(i).getCustID());
                    output.write(" ");
                    output.write(customers.get(i).getCustName());
                    output.write(" ");
                    output.write(customers.get(i).getCustAddress());
                    output.write(" ");
                    output.write(customers.get(i).getPickUpTime());
                    output.write(" ");
                    output.write(customers.get(i).getDropOffTime());
                    output.write(" ");
                    output.write(customers.get(i).getLicenseNumber());
                    output.write(" ");
                    output.write(customers.get(i).getIns());
                    output.write(" ");
                    output.write(customers.get(i).getCardNum());
                    output.write(" ");
                    output.write(String.valueOf(customers.get(i).getHasAppoinment()));
                    output.write(" ");
                    output.write(String.valueOf(customers.get(i).getCarLate()));
                    output.write(" ");
                    output.newLine();
                }
                for (int i = 0; i< employees.size(); i++)
                {
                    output.write("Empl");
                    output.write(" ");
                    output.write(employees.get(i).getName());
                    output.write(" ");
                    output.write(employees.get(i).getAddress());
                    output.write(" ");
                    output.write(employees.get(i).getEthnicity());
                    output.write(" ");
                    output.write(employees.get(i).getGender());
                    output.write(" ");
                    output.write(String.valueOf(employees.get(i).getPhoneNumber()));
                    output.write(" ");
                    output.write(String.valueOf(employees.get(i).getHours()));
                    output.write(" ");
                    output.write(String.valueOf(employees.get(i).getPayRate()));
                    output.write(" ");
                    output.write(String.valueOf(employees.get(i).getInsurance()));
                    output.write(" ");
                    output.newLine();
                }
                for (int i = 0; i< vehicle.size(); i++)
                {
                    output.write(vehicle.get(i).getName());
                    output.write(" ");
                    output.write(String.valueOf(vehicle.get(i).get25Rate()));
                    output.write(" ");
                    output.write(String.valueOf(vehicle.get(i).getPerDayRate()));
                    output.write(" ");
                    output.write(vehicle.get(i).getPlateNum());
                    output.write(" ");
                    output.write(String.valueOf(vehicle.get(i).getMileage()));
                    output.write(" ");
                    output.write(String.valueOf(vehicle.get(i).getGasInTank()));
                    output.write(" ");
                    output.write(String.valueOf(vehicle.get(i).getRentStat()));
                    output.write(" ");
                    output.write(String.valueOf(vehicle.get(i).getParkSpot()));
                    output.write(" ");
                    output.write(String.valueOf(vehicle.get(i).getMaint()));
                    output.write(" ");
                    output.write(String.valueOf(vehicle.get(i).getVehicleID()));
                    output.write(" ");
                    output.write(String.valueOf(vehicle.get(i).getManual()));
                    output.write(" ");
                    output.write(vehicle.get(i).getMake());
                    output.write(" ");
                    output.write(String.valueOf(vehicle.get(i).getYear()));
                    output.write(" ");
                    output.write(vehicle.get(i).getColor());
                    output.write(" ");
                    output.newLine();
                }
                for (int i = 0; i< payments.size(); i++)
                {
                    output.write("Paym");
                    output.write(" ");
                    output.write(payments.get(i).getCustomer().getCustID());
                    output.write(" ");
                    output.write(String.valueOf(payments.get(i).getVehicle().getVehicleID()));
                    output.write(" ");
                    output.write(String.valueOf(payments.get(i).getMiles()));
                    output.write(" ");
                    output.write(String.valueOf(payments.get(i).getPickup()));
                    output.write(" ");
                    output.write(String.valueOf(payments.get(i).getDropoff()));
                    output.write(" ");
                    output.write(String.valueOf(payments.get(i).getDiscountApplied()));
                    output.write(" ");
                    output.write(String.valueOf(payments.get(i).getDiscountPercentage()));
                    output.write(" ");
                    output.write(String.valueOf(payments.get(i).getWasCleanupNeeded()));
                    output.write(" ");
                    output.write(String.valueOf(payments.get(i).getCheck()));
                    output.write(" ");
                    output.newLine();
                }
                output.flush();
                output.close();
                // Closes the writer
            }
            }

        catch (IOException e) 
        {
            e.getStackTrace();
        }
        }
	// this method is used to load values to the customers,vehicles,payments, and employees lists/ database
	// , to have some existing data to work with. objects are created of each class with hard coded values in there
	// set method Parameters then the object is added to the corresponding arraylist
        public void initiateDb(ArrayList<Customer> customers,ArrayList<Vehicle> vehicle,ArrayList<Employee> employees,ArrayList<Payment> payments)
        {
            try
            {
            File file = new File("Data.txt");
            Scanner sc = new Scanner(file);
            int x=0;
            while (sc.hasNextLine())
            {
                String[] line=sc.nextLine().split(" ");
                if("Cust".equals(line[0]))
                {
                    Customer cust = new Customer();
                    cust.setCustID(line[1]);     				
                    cust.setCustName(line[2]);
                    cust.setCustAddress(line[3]);
                    cust.setPickUpTime(line[4]);
                    cust.setDropOffTime(line[5]);
                    cust.setLicenseNumber(line[6]);
                    cust.setIns(line[7]);
                    cust.setCardNum(line[8]);
                    cust.setHasAppointment(Boolean.parseBoolean(line[9]));
                    cust.setCarLate(Boolean.parseBoolean(line[10]));
                    customers.add(cust);
                }
                if("Empl".equals(line[0]))
                {
                    Employee empl=new Employee();
                    empl.setName(line[1]);
                    empl.setAddress(line[2]+" "+line[3]+" "+line[4]);
                    empl.setEthnicity(line[5]);
                    empl.setGender(line[6]);
                    empl.setPhoneNumber(line[7]);
                    empl.setHours(Double.parseDouble(line[8]));
                    empl.setPayRate(Double.parseDouble(line[9]));
                    empl.setInsurance(Boolean.parseBoolean(line[10]));
                    empl.setUntaxedWage();
                    empl.setTaxedWage();
                    employees.add(empl);
                }
                if("Van".equals(line[0])||"Truck".equals(line[0])||"Car".equals(line[0]))
                {
                    if("Van".equals(line[0]))
                    {
                        Van van = new Van();
                        van.set25Rate(Double.parseDouble(line[1]));
                        van.setPerDayRate(Double.parseDouble(line[2]));
                        van.setPlateNum(line[3]);
                        van.setMileage(Integer.parseInt(line[4]));
                        van.setGasInTank(Double.parseDouble(line[5]));
                        van.setRentStat(Boolean.parseBoolean(line[6]));
                        van.setParkSpot(Integer.parseInt(line[7]));
                        van.setMaint(Boolean.parseBoolean(line[8]));
                        van.setVehicleID(Integer.parseInt(line[9]));
                        van.setManual(Boolean.parseBoolean(line[10]));
                        van.setMake(line[11]+" "+line[12]);
                        van.setYear(Integer.parseInt(line[13]));
                        van.setColor(line[14]);
                        vehicle.add(van);
                    }
                    if("Car".equals(line[0]))
                    {
                        Car car = new Car();
                        car.set25Rate(Double.parseDouble(line[1]));
                        car.setPerDayRate(Double.parseDouble(line[2]));
                        car.setPlateNum(line[3]);
                        car.setMileage(Integer.parseInt(line[4]));
                        car.setGasInTank(Double.parseDouble(line[5]));
                        car.setRentStat(Boolean.parseBoolean(line[6]));
                        car.setParkSpot(Integer.parseInt(line[7]));
                        car.setMaint(Boolean.parseBoolean(line[8]));
                        car.setVehicleID(Integer.parseInt(line[9]));
                        car.setManual(Boolean.parseBoolean(line[10]));
                        car.setMake(line[11]+" "+line[12]);
                        car.setYear(Integer.parseInt(line[13]));
                        car.setColor(line[14]);
                        vehicle.add(car);
                    }
                    if("Truck".equals(line[0]))
                    {
                        Truck trk = new Truck();
                        trk.set25Rate(Double.parseDouble(line[1]));
                        trk.setPerDayRate(Double.parseDouble(line[2]));
                        trk.setPlateNum(line[3]);
                        trk.setMileage(Integer.parseInt(line[4]));
                        trk.setGasInTank(Double.parseDouble(line[5]));
                        trk.setRentStat(Boolean.parseBoolean(line[6]));
                        trk.setParkSpot(Integer.parseInt(line[7]));
                        trk.setMaint(Boolean.parseBoolean(line[8]));
                        trk.setVehicleID(Integer.parseInt(line[9]));
                        trk.setManual(Boolean.parseBoolean(line[10]));
                        trk.setMake(line[11]+" "+line[12]);
                        trk.setYear(Integer.parseInt(line[13]));
                        trk.setColor(line[14]);
                        vehicle.add(trk);
                    }
                }
                if("Paym".equals(line[0]))
                {
                    Payment pay = new Payment();
                    pay.setCustomer(customers.get(searchCustID(line[1],customers)));
                    pay.setVehicle(vehicle.get(searchVehic(Integer.parseInt(line[2]),vehicle)));
                    pay.setMiles(Double.parseDouble(line[3]));
                    System.out.println(line[4]);
                    pay.setPickup(String.valueOf(line[4].charAt(5)-48)+String.valueOf(line[4].charAt(6)-48)+"/"+
                                  String.valueOf(line[4].charAt(8)-48)+String.valueOf(line[4].charAt(9)-48)+"/"+
                                  String.valueOf(line[4].charAt(0)-48)+String.valueOf(line[4].charAt(1)-48)+
                                  String.valueOf(line[4].charAt(2)-48)+String.valueOf(line[4].charAt(3)-48));
                    pay.setDropoff(String.valueOf(line[5].charAt(5)-48)+String.valueOf(line[5].charAt(6)-48)+"/"+
                                   String.valueOf(line[5].charAt(8)-48)+String.valueOf(line[5].charAt(9)-48)+"/"+
                                   String.valueOf(line[5].charAt(0)-48)+String.valueOf(line[5].charAt(1)-48)+
                                   String.valueOf(line[5].charAt(2)-48)+String.valueOf(line[5].charAt(3)-48));
                    pay.setTimeInDays();
                    pay.setDiscountApplied(Boolean.parseBoolean(line[6]));
                    pay.setDiscountPercentage(Double.parseDouble(line[7]));
                    pay.setWasCleanupNeeded(Boolean.parseBoolean(line[8]));
                    if(Integer.parseInt(line[9])==1)
                    {
                        pay.setCheck();
                    }
                    pay.setTotal();
                    payments.add(pay);
                }
            }
            }
            catch(FileNotFoundException e)
            {
                e.getStackTrace();
            }
        }
	public void initiateDB(ArrayList<Customer> customers,ArrayList<Vehicle> vehicle,ArrayList<Employee> employees,ArrayList<Payment> payments)
	{
		Van van = new Van();
		Car car = new Car();
		Truck truck = new Truck();

		van.set25Rate(0.1);
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
	

		car.set25Rate(0.15);
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


		truck.set25Rate(0.05);
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
	

		Employee employee1=new Employee();
		Employee employee2=new Employee();
		Employee employee3=new Employee();

		employee1.setName("Laura");
		employee1.setAddress("1613 2nd Street");
		employee1.setEthnicity("White");
		employee1.setGender("Female");
		employee1.setPhoneNumber("1-408-123-4567");
		employee1.setHours(30);
		employee1.setPayRate(14.56);
		employee1.setInsurance(false);
		employee1.setUntaxedWage();
		employee1.setTaxedWage();
		employees.add(employee1);

		employee2.setName("Matthew");
		employee2.setAddress("898 Roosevelt Rd");
		employee2.setEthnicity("n/a");
		employee2.setGender("Male");
		employee2.setPhoneNumber("1-408-456-1936");
		employee2.setHours(40);
		employee2.setPayRate(17.65);
		employee2.setInsurance(true);
		employee2.setUntaxedWage();
		employee2.setTaxedWage();
		employees.add(employee2);

		employee3.setName("Eduardo");
		employee3.setAddress("9 Apricot st");
		employee3.setEthnicity("n/a");
		employee3.setGender("Male");
		employee3.setPhoneNumber("1-408-515-1986");
		employee3.setHours(20);
		employee3.setPayRate(16.42);
		employee3.setInsurance(false);
		employee3.setUntaxedWage();
		employee3.setTaxedWage();
		employees.add(employee3);

		Customer customer1 = new Customer();								
		Customer customer2 = new Customer();	
		Customer customer3 = new Customer();	
		
		customer1.setCustID("200");     				
		customer1.setCustName("Eduardo");
		customer1.setCustAddress("mexico");
		customer1.setPickUpTime("3/26/2023");
		customer1.setDropOffTime("3/28/2023");
		customer1.setLicenseNumber("weis-29");
		customer1.setIns("Allstate");
		customer1.setCardNum("2340-5432-8587-3425");
		customer1.setHasAppointment(true);
		customer1.setCarLate(true);
		
		customer2.setCustID("201");								
		customer2.setCustName("Emma");
		customer2.setCustAddress("usa");
		customer2.setPickUpTime("2/10/2023");
		customer2.setDropOffTime("2/15/2023");
		customer2.setLicenseNumber("vfre-59");
		customer2.setIns("Progressive");
		customer2.setCardNum("3456-3265-7965-4930");
		customer2.addToNumOfRent();
		customer2.setHasAppointment(false);
		customer2.setCarLate(true);
		
		customer3.setCustID("203");
		customer3.setCustName("john");
		customer3.setCustAddress("usa");							
		customer3.setPickUpTime("2/15/2023");
		customer3.setDropOffTime("2/16/2023");
		customer3.setLicenseNumber("bcle-28");
		customer3.setIns("Liberty");
		customer3.setCardNum("4467-3404-5567-5689");
		customer3.addToNumOfRent();
		customer3.addToNumOfRent();
		customer3.addToNumOfRent();
		customer3.addToNumOfRent();
		customer3.setHasAppointment(true);
		customer3.setCarLate(false);
		
		customers.add(customer1);
		customers.add(customer2);
		customers.add(customer3);
	
		Payment payment1=new Payment();
		payment1.setCustomer(customer3);
		payment1.setVehicle(truck);
		payment1.setMiles(250);
		payment1.setPickup("01/05/2023");
		payment1.setDropoff("01/15/2023");
		payment1.setTimeInDays();
		payment1.setDiscountApplied(true);
		payment1.setDiscountPercentage(0.90);
		payment1.setWasCleanupNeeded(false);
		payment1.setCheck();
		payment1.setTotal();
		payments.add(payment1);

		Payment payment2=new Payment();
		payment2.setCustomer(customer3);
		payment2.setVehicle(van);
		payment2.setMiles(125);
		payment2.setPickup("03/25/2023");
		payment2.setDropoff("04/02/2023");
		payment2.setTimeInDays();
		payment2.setDiscountApplied(false);
		payment2.setDiscountPercentage(0);
		payment2.setWasCleanupNeeded(true);
		payment2.setTotal();
		payments.add(payment2);

		Payment payment3=new Payment();
		payment3.setCustomer(customer1);
		payment3.setVehicle(car);
		payment3.setMiles(500);
		payment3.setPickup("12/27/2022");
		payment3.setDropoff("01/05/2023");
		payment3.setTimeInDays();
		payment3.setDiscountApplied(true);
		payment3.setDiscountPercentage(0.80);
		payment3.setWasCleanupNeeded(false);
		payment3.setTotal();
		payments.add(payment3);

		Payment payment4=new Payment();
		payment4.setCustomer(customer2);
		payment4.setVehicle(van);
		payment4.setMiles(250);
		payment4.setPickup("04/05/2023");
		payment4.setDropoff("04/08/2023");
		payment4.setTimeInDays();
		payment4.setDiscountApplied(true);
		payment4.setDiscountPercentage(0.90);
		payment4.setWasCleanupNeeded(false);
		payment4.setTotal();
		payments.add(payment4);
	}
	
	// this method searches and displays an employee's attributes. the employee's ID is used to 
	// locate it in the arrayList  
	public int searchEmployee(ArrayList<Employee> employees)
	{
		System.out.println("Enter employee name: ");
		String name = in.next();

		int index = -1;																		
		for (int i = 0; i< employees.size(); i++)
		{
			if (employees.get(i).getName().equals(name))													
			{
				index = i;
			}
		}

		if (index != -1)
		{
			return index;							
		}
		else
		{
			System.out.println("The name selected does not exist");
			return -1;
		}
	}
	
	// this method adds an Employee object to the list of employees.
	// first it gathers the attributes, using prompts. then the object Employee is created
	// then the object is added to the arraylist of customers using the araylist's add() method
	public void addEmployeeToDB(ArrayList<Employee> employees)
	{
		String name;
		String address;
    	String ethnicity;
    	String gender;
    	String phoneNumber;
    	double hours;
    	double payRate;
    	boolean insurance;

		System.out.println("enter the name: ");
		name = in.nextLine();

		System.out.println("enter the adress: ");
		address = in.nextLine();

		System.out.println("enter ethnicity or n/a: ");
		ethnicity = in.nextLine();

		System.out.println("enter the gender: ");
		gender = in.nextLine();

		System.out.println("enter the phone number: ");
		phoneNumber = in.nextLine();

		System.out.println("the hours per week: ");
		hours = in.nextInt();

		System.out.println("enter the pay per hour: ");
		payRate = in.nextDouble();

		System.out.println("enter if they have insurance(true or false): ");
		insurance = in.nextBoolean();

		Employee employee = new Employee();

		employee.setName(name);
		employee.setAddress(address);
		employee.setEthnicity(ethnicity);
		employee.setGender(gender);
		employee.setPhoneNumber(phoneNumber);
		employee.setHours(hours);
		employee.setPayRate(payRate);
		employee.setInsurance(insurance);
		employee.setUntaxedWage();
		employee.setTaxedWage();
		
		System.out.println("the untaxed wage per week was: "+employee.getUntaxedWage());
		System.out.println("the taxed wage per week was: "+employee.getTaxedWage());
		employees.add(employee);
	}
	// this method removes a Employee object from the Employee arraylist,
	// it uses a the searchEmployee() to check if the ID exists, if it does then it 
	// uses the arraylist method remove() to delete the employee from the list
	public void removeEmployeeFromDB(ArrayList<Employee> employees)
	{
		int index = searchEmployee(employees);
		if (index != -1)
		{
			employees.remove(index);
		}
		else
		{
			System.out.println("The name selected does not exist");
		}
	}
	// this method modifies an existing object of the class Employee in the arraylist 
	// employees. it uses the searchEmployee() to determine a valid index. then it uses the index it 
	// gets from the searchEmployee() method to update the desired object in the customers arraylist.
	public void modifyEmployeeFromDB(ArrayList<Employee> employee)
	{
		int index = searchEmployee(employee);
		if (index != -1)
		{
		String address;
    	String gender;
    	String phoneNumber;
    	double hours;
    	double payRate;
    	boolean insurance;

		System.out.println("enter the new adress: ");
		address = in.next();

		System.out.println("enter the gender: ");
		gender = in.next();

		System.out.println("enter the phone number: ");
		phoneNumber = in.next();

		System.out.println("the hours per week: ");
		hours = in.nextInt();

		System.out.println("enter the pay per hour: ");
		payRate = in.nextDouble();

		System.out.println("enter if they have insurance(true or false): ");
		insurance = in.nextBoolean();

		employee.get(index).setAddress(address);
		employee.get(index).setGender(gender);
		employee.get(index).setPhoneNumber(phoneNumber);
		employee.get(index).setHours(hours);
		employee.get(index).setPayRate(payRate);
		employee.get(index).setInsurance(insurance);
		employee.get(index).setUntaxedWage();
		employee.get(index).setTaxedWage();
		
		System.out.println("the untaxed wage per week was: "+employee.get(index).getUntaxedWage());
		System.out.println("the taxed wage per week was: "+employee.get(index).getTaxedWage());
		}
		else
		{
			System.out.println("The name selected does not exist");
		}		
	}
	
	// this method prints all the attributes of the Employee class,
	// that are located in the arraylist using a for loop to traverse
	// each element, and utilizing the Employees class's toString method
	public void printEmployeeReport(ArrayList<Employee> employee)
	{
		for (int i = 0; i< employee.size(); i++)
		{
			System.out.println(employee.get(i));
		}
	}
	
	//this method uses the customer id to search for the payments 
	//that are made by the customer and then it prints the one 
	//found without a check value of 1
	public int searchPayments(ArrayList<Customer> customers,ArrayList<Payment>payments)
	{
		System.out.println("Enter customer ID of the payment needs to be searched: ");
		String ID=in.next();

		int index=searchCustID(ID, customers);
		int x=-1;
		if(index==-1)
		{
			System.out.println("Customer ID does not exists");
			return -1;
		}
		Customer cust=customers.get(index);
		for(int i=0;i<payments.size();i++)
		{
			if(payments.get(i).getCustomer().equals(cust)&&payments.get(i).getCheck()==0)
			{
				System.out.println(payments.get(i));
				x=i;
			}
			
		}
		if(x==-1)
		{
			System.out.println("No payment exists for customer");
			return -1;
		}
		return x;	
	}

	//Create the payment to be added to the to the array of payments and adds
	//the needed customer and vehicle to the object
	public void createPayment(ArrayList<Customer> customers,ArrayList<Vehicle> vehicles,ArrayList<Payment> payments)
	{
		System.out.println("Enter customer ID to search: ");
		int indexC = searchCustID(in.next(), customers);
		if(indexC==-1)
		{
			System.out.println("The id selected does not exist");
			return;
		}
		Customer cust=customers.get(indexC);
		for(int i=0;i<payments.size();i++)
		{
			if(payments.get(i).getCustomer().equals(cust)&&payments.get(i).getCheck()==0)
			{
				payments.get(i).setCheck();
			}
			
		}
		System.out.println("Enter vehicle ID to search: ");
		int vehicleID=in.nextInt();
		int indexV=-1;																	
		for (int i = 0; i< vehicles.size(); i++)
		{
			if (vehicles.get(i).getVehicleID()==vehicleID)													
			{
				indexV = i;
			}
		}

		if (indexV == -1)
		{
			System.out.println("The id selected does not exist");
			return;						
		}
		Payment payment = new Payment();
		payment.createPayment(vehicles.get(indexV), customers.get(indexC));
		payments.add(payment);	
	}
	
	//uses the customer id provided to determine which payment to provide to user
	// to be able to remove and choose the one to remove
	public void removePaymentFromDB(ArrayList<Customer> customers,ArrayList<Payment>payments)
	{
		System.out.println("Enter customer ID of the payment needs to be removed: ");
		String ID=in.next();
		int index=searchCustID(ID, customers);
		int x=-1;
		Customer cust=customers.get(index);
		for(int i=0;i<payments.size();i++)
		{
			if(payments.get(i).getCustomer().equals(cust))
			{
				System.out.println("\nIs this the Payment to be removed(true or false):\n"+payments.get(i));
				if(in.nextBoolean())
				{
					payments.remove(i);
					x=0;
					break;
				}
			}
			
		}
		if(x!=0)
		{
			System.out.println("No payment exists for customer");
		}


	}

	//allows the user to modify payment after recieving the cutomer id and vehicle id to chnge to
	//the changes the value in the payment
	public void modifyPayments(ArrayList<Customer> customers,ArrayList<Vehicle> vehicles,ArrayList<Payment> payments)
	{
		int x=-1;	
		System.out.println("Enter customer ID of payment to modify: ");
		int indexC = searchCustID(in.next(), customers);
		if(indexC==-1)
		{
			System.out.println("The id selected does not exist");
			return;
		}
		System.out.println("Enter vehicle ID to change to: ");
		int vehicleID=in.nextInt();
		int indexV=-1;																
		for (int i = 0; i< vehicles.size(); i++)
		{
			if (vehicles.get(i).getVehicleID()==vehicleID)													
			{
				indexV = i;
			}
		}
		Customer cust=customers.get(indexC);
		for(int i=0;i<payments.size();i++)
		{
			if(payments.get(i).getCustomer().equals(cust)&&payments.get(i).getCheck()==0)
			{
				x=i;
			}
			
		}
		if (indexV == -1)
		{
			System.out.println("The id selected does not exist");
			return;						
		}
		Payment payment = new Payment();
		payment.createPayment(vehicles.get(indexV), customers.get(indexC));
		if(x!=-1)
		{
			payments.set(x,payment);
		}
		else
		{
			System.out.println("Payment does not exists");
		}
	}

	//prints out payments using the for loop to print payment 
	// uses the to string method
	public void printPayments(ArrayList<Payment>payments)
	{
		for (int i = 0; i< payments.size(); i++)
		{
			System.out.println(payments.get(i)+"\n");
		}
	}
		
			
	
}
