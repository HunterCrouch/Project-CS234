import java.util.Scanner;
import java.util.ArrayList;


public class Appointment 
{

	Scanner in = new Scanner(System.in); 
	
	private int appointmentID;
	private Customer customer;
	private Vehicle vehicle;
	
	
	private String custName;
	
	private int time = 1;
	private int miles;
	
	private boolean checkedOut;   // this lets every one know if the cust has paid 
	
	private boolean onTheRoad;    // will let everyone know if the car is in the road when you are trying to make a new appointment youll have a condition that checks if there is an
	                 			// appointment with the car you are trying to take out and if it is in use/ on the road . if both are true then it wont let you take the car out/ make an
								// appointment
	
	private int bill;    			// the fee/ charge
		
	
	public void setCustomer(Customer cust)      // allows to have a particular object associated with the appointment class, once youve done that you can access all of the customer's attributes
	{
		customer = cust;      
	}
	
	public Customer getCustomer()
	{
		return customer;
	}
	
	public void setVehicle(Vehicle vehicle)
	{
		this.vehicle = vehicle;
	}
		
	public Vehicle getVehicle()
	{
		return vehicle;
	}
	
	public void setBill(int bill)
	{
		this.bill = bill;
	}
	public int getBill()
	{
		return bill;
	}
	
	public void setTime(int time)
	{
		this.time = time;
	}
	public int getTime()
	{
		return time;
	}
	
}