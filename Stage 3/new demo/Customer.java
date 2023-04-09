
public class Customer 
{																// a few attribute to demonstrate how the class will work
	private String pickUpTime;
	private String dropOffTime;
	private String licenseNum;
	private String custName;
	private String insurComp;
	private String cardNum;
	private int numPrevRentals=0;
	private boolean hasAppoint;
	private String appointPickUp;
	private String appointDropOff;
	private boolean carLate;
	private String custID;										// variables are initially declared as private, will need a public method to access 
	private String custAddress;
	
	public void setPickUpTime(String time){pickUpTime=time;}
	public String getPickUpTime(){return pickUpTime;}

	public void setDropOffTime(String time){dropOffTime=time;}
	public String getDropOffTime(){return dropOffTime;}

	public void setLicenseNumber(String licenNum){licenseNum=licenNum;}
	public String getLicenseNumber(){return licenseNum;}

	public void setIns(String ins){insurComp=ins;}
	public String getIns(){return insurComp;}

	public void setCardNum(String num){cardNum=num;}
	public String getCardNum(){return cardNum;}

	public void addToNumOfRent(){numPrevRentals++;}
	public int getNumOfRentals(){return numPrevRentals;}

	public void setHasAppointment(boolean apt){hasAppoint=apt;}
	public boolean getHasAppoinment(){return hasAppoint;}

	public void setPickTime(String date){appointPickUp=date;}
	public String getPickTime(){return appointPickUp;}

	public void setDropTime(String date){appointDropOff=date;}
	public String getDropTime(){return appointDropOff;}

	public void setCarLate(boolean lt){carLate=lt;}
	public boolean getCarLate(){return carLate;}
	
	/*
	 * Assigns the customer’s ID to the correspondent instance variable.
	 * @param id, the customer’s id.
	 */
	public void setCustID(String custID) 													// first 3 methods gather values for variables custID, name, and address.
	{
		this.custID = custID;
	}
	
	/*
	 * Assigns the customer’s name to the correspondent instance variable.
	 * @param custName, the customer’s name.
	 */
	public void setCustName(String custName) 
	{
		this.custName = custName;
	}
	
	/*
	 * Assigns the customer’s city to the correspondent instance variable.
	 * @param custCity, the customer’s city.
	 */
	public void setCustAddress(String custCity) 
	{
		this.custAddress = custCity;
	}
	
	/*
	 * Returns the customer’s id.
	 * @return, customer’s id.
	 */
	public String getCustID() 																	// next 4 methods allow access to variables custID, name, and city and number of elements in array list .
	{
		return custID;
	}
	
	/*
	 * Returns the customer’s name.
	 * @return, the customer's name.
	 */
	public String getCustName()  
	{
		return custName;
	}
	
	/*
	 * Returns the customer’s city.
	 * @return, the customer's city.
	 */
	public String getCustAddress()   
	{
		return custAddress;
	}
	
	
	public String toString()
	{
		String space = " ";
//		String s = "|" 	+ custID + space.repeat(15 - custID.length()) + "|" + custAddress + space.repeat(15 - custAddress.length()) + "|"                 // alternative way to display
//						+ custName + space.repeat(15 - custName.length()) ;
		
		String s = "Customer id: " + custID + "\n";
		s+= "Customer name: " + custName + "\n";
		s+= "Customer Address: " + custAddress + "\n";
		s+= "Pick up time: " + pickUpTime + "\n";
		s+= "Drop off time: " + dropOffTime + "\n";
		s+= "License: " + licenseNum + "\n";
		s+= "Insurance company: " +insurComp+ "\n";
		s+= "Credit card Number: " +cardNum+ "\n";
		s+= "Number of Previous rentals: " +numPrevRentals+ "\n";
		if (carLate == true)
		{
			s+= "Car was Late\n";
		}
		else
			s+= "Car was not Late\n";
		
		if (hasAppoint == true)
		{
			s+= "Customer has appointment\n";
		}
		else
			s+= "Customer does not have appointment\n";
		
		return s;
	}
	
	
	
	
}
