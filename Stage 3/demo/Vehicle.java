public class Vehicle 
{
	private String vehicleID;
	private String vehicleModel;										// a few attribute to demonstrate how the class will work
	
	
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
