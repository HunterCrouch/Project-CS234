/* this class is a child class of the Vehicle class
 */
public class Truck extends Vehicle{
	// additional characteristics for the child class Truck
    private boolean manual;
    private String make;
    private int year;
    private String color;
    // constructor for the truck class
    Truck()
    {
        super();
    }
    
    // there is a get method and a set method 
    // for the new attributes associated with the 
    // Truck class
    
    public boolean getManual(){super.getManual();return manual;}
    public void setManual(boolean man){manual = man;}
    public void setMake(String mk){make = mk;}
    public void setYear(int yr){year = yr;}
    public String getName(){super.getName();return "Truck";}
    public String getMake(){super.getMake();return make;}
    public int getYear(){super.getYear();return year;}
    public String getColor(){super.getColor();return color;}
    public void setColor(String clr){color=clr;}
    
    // this method allows for all the attributes to be displayed when called
    public String toString()
	{

//		String s="";
//		s = "|" + year +"|\t"+ make + "|\t" +color+ "|\t manual: "+ manual+ "|\t per25 rate: "+get25Rate()+"|\t perday rate:"+getPerDayRate()+
//    
//        "|\n plate num:"+getPlateNum()+"|\t mileage:"+getMileage()+"|\t gas in tank:"
//        +getGasInTank()+"|\t"+"rent status: "+getRentStat()+"| \n"
//
//        +"| parkspot: "+getParkSpot()+"|\t maint: "+getMaint()+"|\t Id: "+ getVehicleID()+"|";
		
		String s = "Vehicle Information"+"\n"; 
    	s+= "Year: " + year + "\n";
		s+= "Make: " + make + "\n";
		s+= "Color: " + color + "\n"; 
		if (manual == true)
		{
			s+= "The vehicle is Manual: " + "\n";
		}
		else
			s+= "The vehicle is not Manual: " + "\n";
			
		s+= "25 mile rate: " + get25Rate() + "\n"; 
		s+= "Day Rate: " + getPerDayRate() + "\n"; 
		s+= "Plate number: " + getPlateNum() + "\n"; 
		s+= "Mileage: " + getMileage() + "\n"; 
		s+= "Gas in tank: " + getGasInTank() + "\n"; 
		s+= "Rent status: " + getRentStat() + "\n"; 
		s+= "Parkin Spot: " + getParkSpot() + "\n"; 
		s+= "Maintnace Fee: " + getMaint() + "\n"; 
		s+= "Vehicle ID: : " + getVehicleID() + "\n";
		return s;
	}
}
    
    