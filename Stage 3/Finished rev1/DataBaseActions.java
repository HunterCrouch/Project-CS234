import java.util.ArrayList;
import java.util.Scanner;

public class DataBaseActions 
{
	Scanner in = new Scanner(System.in);
	
	private int custIndex = -1;						     // set at -1 so it can start at zero .... because the index gets updated before in the add method not after						
	private int vehicleIndex = 1;						// will be used for other vehicle array
	private int employeeIndex = 1;
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
		custID = in.next();

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
		String pickUpTime;
		String dropOffTime;
		String licenseNum;
		String insurComp;
		String cardNum;
//		String appointPickUp;       will be used if we decide to go with the appointment class
//		String appointDropOff;
		boolean hasAppoint;
		boolean carLate;
		int choice1;
		int choice2;
		
		Customer customer = new Customer(); 

		System.out.println("enter cust id: ");							
		custID = in.nextLine();												
		
		System.out.println("enter cust Name: ");						
		custName = in.nextLine();
		
		System.out.println("enter cust Adress: ");
		custAddress = in.nextLine();
		
		System.out.println("enter pick up time: ");
		pickUpTime = in.nextLine();
		
		System.out.println("enter drop off time: ");
		dropOffTime = in.nextLine();
		
		System.out.println("enter License number: ");
		licenseNum = in.nextLine();
		
		System.out.println("enter insurance company: ");
		insurComp = in.nextLine();
		
		System.out.println("enter credit card number: ");
		cardNum = in.nextLine();
		
//		System.out.println("enter appointment pick up time enter in mm/dd/yyyy format: ");
//		appointPickUp = in.nextLine();
//		
//		System.out.println("enter appointment drop of time in mm/dd/yyyy: ");
//		appointDropOff = in.nextLine();
		
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
//		customer.setPickTime(appointPickUp);
//		customer.setDropTime(appointDropOff);
		customer.setHasAppointment(hasAppoint);
		customer.setCarLate(carLate);
		customers.add(customer);
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
			String pickUpTime;
			String dropOffTime;
			String licenseNum;
			String insurComp;
			String cardNum;
//			String appointPickUp;    
//			String appointDropOff;
			boolean hasAppoint;
			boolean carLate;
			int choice1;
			int choice2;
				
			
			System.out.println("enter cust Name: ");						
			custName = in.nextLine();
			
			System.out.println("enter cust Adress: ");
			custAddress = in.nextLine();
			
			System.out.println("enter pick up time: ");
			pickUpTime = in.nextLine();
			
			System.out.println("enter drop off time: ");
			dropOffTime = in.nextLine();
			
			System.out.println("enter License number: ");
			licenseNum = in.nextLine();
			
			System.out.println("enter insurance company: ");
			insurComp = in.nextLine();
			
			System.out.println("enter credit card number: ");
			cardNum = in.nextLine();
			
//			System.out.println("enter appointment pick up time enter in mm/dd/yyyy format: ");
//			appointPickUp = in.nextLine();
//			
//			System.out.println("enter appointment drop of time in mm/dd/yyyy: ");
//			appointDropOff = in.nextLine();
			
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
//			customers.get(index).setPickTime(appointPickUp);
//			customers.get(index).setDropTime(appointDropOff);
			customers.get(index).setHasAppointment(hasAppoint);
			customers.get(index).setCarLate(carLate);
			
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
	public void initiateDB(ArrayList<Customer> customers,ArrayList<Vehicle> vehicle,ArrayList<Employee> employees,ArrayList<Payment> payments)
	{
		// attempting to have a unique object in each index WORKS!!!!!!!!!!!!!
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
		vehicleIndex++;

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
		vehicleIndex++;

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
		vehicleIndex++;

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
		customer1.setCustAddress("mexio");
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
		custIndex++;
		customers.add(customer2);
		custIndex++;
		customers.add(customer3);
		custIndex++;

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
		employeeIndex++;
	}
	public void removeEmployeeFromDB(ArrayList<Employee> employees)
	{
		int index = searchEmployee(employees);
		if (index != -1)
		{
			employees.remove(index);
			employeeIndex --;
		}
		else
		{
			System.out.println("The name selected does not exist");
		}
	}
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
	public void printEmployeeReport(ArrayList<Employee> employee)
	{
		for (int i = 0; i< employee.size(); i++)
		{
			System.out.println(employee.get(i));
		}
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
	public void printPayments(ArrayList<Payment>payments)
	{
		for (int i = 0; i< payments.size(); i++)
		{
			System.out.println(payments.get(i)+"\n");
		}
	}
		
			
	
}