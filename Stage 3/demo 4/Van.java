public class Van extends Vehicle{
    
    private boolean manual;
    private String make;
    private int year;
    private String color;   
    Van()
    {
        super();
    }
    public boolean getManual(){return manual;}
    public void setManual(boolean man){manual = man;}
    public void setMake(String mk){make = mk;}
    public void setYear(int yr){year = yr;}

    public String getMake(){return make;}
    
    public int getYear(){return year;}
    
    
    public String getColor(){return color;}
    public void setColor(String clr){color=clr;}
    public String toString()
	{

		String s="";
		s = "|" + year +"|\t"+ make + "|\t" +color+ "|\t manual: "+ manual+ "|\t per25 rate: "+get25Rate()+"|\t perday rate:"+getPerDayRate()+
    
        "|\n plate num:"+getPlateNum()+"|\t mileage:"+getMileage()+"|\t gas in tank:"
        +getGasInTank()+"|\t"+"rent status: "+getRentStat()+"| \n"

        +"| parkspot: "+getParkSpot()+"|\t maint: "+getMaint()+"|\t Id: "+ getVehicleID()+"|";
		return s;
	}
    
}
