public class Customer { //a few attribute to demonstrate how the class will work 																
	//instance varaible listed below
	//variables are initially declared as private, will need a public method to access 
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
	private String custID;	
	private String custAddress;
	
	//sets the pickup time
	public void setPickUpTime(String time) {
		pickUpTime=time;
	}
	//receives the pickup time
	public String getPickUpTime() {
		return pickUpTime;
	}

	//sets the drop off time
	public void setDropOffTime(String time) {
		dropOffTime=time;
	}
	//recieves the drop off time
	public String getDropOffTime() {
		return dropOffTime;
	}

	//sets the license plate number
	public void setLicenseNumber(String licenNum) {
		licenseNum=licenNum;
	}
	//recieves the license plate number
	public String getLicenseNumber() {
		return licenseNum;
	}

	//sets the insurance company
	public void setIns(String ins) {
		insurComp=ins;
	}
	//receives the insurance company
	public String getIns() {
		return insurComp;
	}

	//sets the card number
	public void setCardNum(String num) { 
		cardNum=num;
	}
	//recives the card number
	public String getCardNum() {
		return cardNum;
	}

	//sets the number of rentals
	public void addToNumOfRent() {
		numPrevRentals++;
	}
	//gets the number of rentals
	public int getNumOfRentals() {
		return numPrevRentals;
	}

	//sets the appointment
	public void setHasAppointment(boolean apt) {
		hasAppoint=apt;
	}
	//gets the appointment
	public boolean getHasAppoinment() {
		return hasAppoint;
	}

	//sets the pick up time
	public void setPickTime(String date) {
		appointPickUp=date;
	}
	//recives the pick up time
	public String getPickTime() {
		return appointPickUp;
	}

	//sets the drop off date for an appointment
	public void setDropTime(String date) {
		appointDropOff=date;
	}
	//recives the drop off date for an appointment
	public String getDropTime() {
		return appointDropOff;
	}

	//check if the car is returned late
	public void setCarLate(boolean lt) {
		carLate=lt;
	}
	//returns true or false if the car is late or not
	public boolean getCarLate() {
		return carLate;
	}
	
	//sets the customer's ID
	public void setCustID(String custID) 													// first 3 methods gather values for variables custID, name, and address.
	{
		this.custID = custID;
	}
	
	//sets the customer's name
	public void setCustName(String custName) 
	{
		this.custName = custName;
	}
	
	//sets the customer's address
	public void setCustAddress(String custCity) 
	{
		this.custAddress = custCity;
	}
	
	//recieves the customer's ID
	public String getCustID() 																	// next 4 methods allow access to variables custID, name, and city and number of elements in array list .
	{
		return custID;
	}
	
	//recieves the customer's name
	public String getCustName()  
	{
		return custName;
	}
	
	//recieves the customer's address
	public String getCustAddress()   
	{
		return custAddress;
	}
	
	 //toString method that prints out the report for the customer's
	 public String toString()
	 {
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