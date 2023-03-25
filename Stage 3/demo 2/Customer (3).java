
public class Customer 
{																// a few attribute to demonstrate how the class will work

	private String custID;										// variables are initially declared as private, will need a public method to access 
	private String custName;
	private String custAddress;
				
	
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
		String s = "|" + custID + "\t|" + custAddress + "\t|" + custName + "\t|" ;
		
		return s;
	}
	
	
	
	
}