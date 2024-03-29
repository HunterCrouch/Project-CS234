import java.text.DecimalFormat;
public class Employee {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private String name;
    private String address;
    private String ethnicity;
    private String gender;
    private String phoneNumber;
    private double hours;
    private double payRate;
    private boolean insurance = false;
    private double unTaxedWage=0;
    private double taxedWage=0;
    private String employeeID;
    
    public void setName(String nm){name = nm;}
    public String getName(){return name;} 

    public void setAddress(String add){address=add;}
    public String getAddress(){return address;}

    public void setEthnicity(String eth){ethnicity=eth;}
    public String getEthnicity(){return ethnicity;}
    
    public void setGender(String gen){gender=gen;}
    public String getGender(){return gender;}
    
    public void setPhoneNumber(String num){phoneNumber=num;}
    public String getPhoneNumber(){return phoneNumber;}

    public void setHours(double hrs){hours=hrs;}
    public double getHours(){return hours;}

    public void setPayRate(double pay){payRate=pay;}
    public double getPayRate(){return payRate;}

    public void setInsurance(boolean ins){insurance=ins;}
    public boolean getInsurance(){return insurance;}

    public void setUntaxedWage()
    {
        unTaxedWage=payRate*hours;
    }
    public double getUntaxedWage()
    {
        setUntaxedWage();
        return unTaxedWage;
    }

    public void setTaxedWage()
    {
        taxedWage=unTaxedWage*.864;//average tax rate for united states
    }
    public double getTaxedWage()
    {
        setTaxedWage();
        return taxedWage;
    }
    public void setEmployeeID(String ID){employeeID = ID;}
    public String getEmployeeID(){return employeeID;}
    public String toString()
    {
//      String s ="";
//      s = "|"+name+"|\t"+address+"| "+ethnicity+" |\t"+gender+"|\t"+phoneNumber+"|\n"+
//      "| hours: "+hours+" | pay rate:"+payRate+" | insurance:"+insurance+" | untaxed wage:"
//      +df.format(unTaxedWage)+" | taxed wage:"+df.format(taxedWage)+"|";
    	
    	String s = "Employee name: " + name + "\n";
        s+= "Employee address: " + address + "\n";
        s+= "Employee ethnicity: " + ethnicity + "\n";
        s+= "Employee gender: " + gender + "\n";
        s+= "Employee phoneNumber: " + phoneNumber+ "\n";
        s+= "Employee hours: " + hours + "\n";
        s+= "Employee pay rate:" + payRate + "\n";
        if (insurance == true)
        {
        	s+= "Employee has health insurance" + "\n";
        }
        else 
        	s+= "Employee does not have health insurance" + "\n";
        
        s+= "Employee untaxed wage: " + df.format(unTaxedWage) + "\n";
        s+= "Employee taxed wage: " + df.format(taxedWage) + "\n";

        return s;
    }
}
