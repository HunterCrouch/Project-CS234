/* This class gives inheritance to the van, truck, and car class.
 * 
 */
public abstract class Vehicle 
{
	// the rate per 25 mile, and rate per day are used to calculate the total payment amount
	private double ratePer25Mile; 		// each vehicle has a set fee for every 25 miles it is driven
	private double ratePerDay;			// each vehicle has a set fee for every day that it is used	
	
	// additional attributes to give characteristics to vehicle objects
	private String plateNumber; 		
	private int mileage;
	private double gasInGals;
	private boolean rentStatus;
	private int spotInPark;
	private boolean maintenance;
	private int vehicleID;      		// vehicle id is used to access the specific vehicle object you want
	private String vehicleModel;										// a few attribute to demonstrate how the class will work
	
	
	/* There is a get method to access, and a set method
	 * to modify all attributes.
	 * 
	 */
	public double get25Rate(){return ratePer25Mile;}
	public void set25Rate(double rate){ratePer25Mile=rate;}

	public double getPerDayRate(){return ratePerDay;}
	public void setPerDayRate(double rate){ratePerDay=rate;}

	public String getPlateNum(){return plateNumber;}
	public void setPlateNum(String plt){plateNumber=plt;}

	public int getMileage(){return mileage;}
	public void setMileage(int mil){mileage=mil;}

	public double getGasInTank(){return gasInGals;}
	public void setGasInTank(double gas){gasInGals=gas;}

	public boolean getRentStat(){return rentStatus;}
	public void setRentStat(boolean rent){rentStatus=rent;}

	public int getParkSpot(){return spotInPark;}
	public void setParkSpot(int spot){spotInPark=spot;}

	public boolean getMaint(){return maintenance;}
	public void setMaint(boolean maint){maintenance=maint;}

        public String getName(){return "Car";}

	public void setVehicleID(int id) 													
	{
		this.vehicleID = id;
	}
	
	public void setVehicleModel(String vehicleModel) 
	{
		this.vehicleModel = vehicleModel;
	}
	
	
	public int getVehicleID() 																	
	{
		return vehicleID;
	}
	
	public String getVehicleModel()  
	{
		return vehicleModel;
	}

        public boolean getManual(){return true;}
        public String getMake(){return "x";}
        public int getYear(){return 0;}
        public String getColor(){return "x";}
 
}
