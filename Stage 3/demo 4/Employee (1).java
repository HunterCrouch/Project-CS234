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
    private boolean insurance;
    private double unTaxedWage=0;
    private double taxedWage=0;
    private int employeeId;
    
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

    public int getEmployeeID(){return employeeId;}
    public String toString()
    {
        String s ="";
        s = "|"+name+"|\t"+address+"| "+ethnicity+" |\t"+gender+"|\t"+phoneNumber+"|\n"+
        "| hours: "+hours+" | pay rate:"+payRate+" | insurance:"+insurance+" | untaxed wage:"
        +df.format(unTaxedWage)+" | taxed wage:"+df.format(taxedWage)+"|";


        return s;
    }
}
