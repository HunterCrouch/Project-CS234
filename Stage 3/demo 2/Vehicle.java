public class Vehicle 
{
	private double ratePer25Mile;
	private double ratePerDay;
	private String plateNumber;
	private int mileage;
	private double gasInGals;
	private boolean rentStatus;
	private int spotInPark;
	private boolean maintenance;
	//private vehicleType moved to subclass
	//private int custId; may switch to vehicleID
	private String vehicleID;
	private String vehicleModel;										// a few attribute to demonstrate how the class will work
	
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





	public void setVehicleID(String id) 													// first 3 methods gather values for variables custID, name, and city.
	{
		this.vehicleID = id;
	}
	
	public void setVehicleModel(String vehicleModel) 
	{
		this.vehicleModel = vehicleModel;
	}
	
	
	public String getVehicleID() 																	// next 4 methods allow access to variables custID, name, and city and number of elements in array list .
	{
		return vehicleID;
	}
	
	public String getVehicleModel()  
	{
		return vehicleModel;
	}
}
