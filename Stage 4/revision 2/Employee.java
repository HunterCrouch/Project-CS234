import java.text.DecimalFormat;
public class Employee {
	//instance varaible listed below
	//variables are initially declared as private, will need a public method to access 
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
    
    //sets the employee's name
    public void setName(String nm) {
    	name = nm;
    }
    //recieves the employee's name
    public String getName() {
    	return name;
    } 

    //sets the employee's address
    public void setAddress(String add) {
    	address=add;
    }
    //recieves the employee's address
    public String getAddress() {
    	return address;
    }

    //sets the employee's ethnicity
    public void setEthnicity(String eth) {
    	ethnicity=eth;
    }
    //recieves the employee's ethnicity
    public String getEthnicity() {
    	return ethnicity;
    }
    
    //sets the employee's gender
    public void setGender(String gen) {
    	gender=gen;
    }
    //recieves the employee's gender
    public String getGender() {
    	return gender;
    }
    
    //sets the employee's phone number
    public void setPhoneNumber(String num) {
    	phoneNumber=num; 
    }
    //recieves the employee's phone number
    public String getPhoneNumber() {
    	return phoneNumber;
    }
    
    //sets the employee's hours
    public void setHours(double hrs) {
    	hours=hrs;
    }
    //recieves the employee's hours
    public double getHours() {
    	return hours;
    }

    //sets the employee's pay rate
    public void setPayRate(double pay) {
    	payRate=pay;
    }
    //recieves the employee's pay rate
    public double getPayRate() { 
    	return payRate;
    }

    //sets the insurance
    public void setInsurance(boolean ins) {
    	insurance=ins;
    }
    //recieves the insurance
    public boolean getInsurance(){
    	return insurance;
    }

    //sets the untaxed wage for the employee
    public void setUntaxedWage() {
        unTaxedWage=payRate*hours;
    }
    //recieves the untaxed wage for the employee
    public double getUntaxedWage()
    {
        setUntaxedWage();
        return unTaxedWage;
    }

    //sets the taxed wage for the employee
    public void setTaxedWage() {
        taxedWage=unTaxedWage*.864;//average tax rate for united states
    }
    //sets the taxed wage for the employee
    public double getTaxedWage() {
        setTaxedWage();
        return taxedWage;
    }

    //recieves the employee's ID
    public int getEmployeeID() {
    	return employeeId;
    }
    
    //toString method that prints out the report for the employee's
    public String toString()
    {
        String s ="";
        s = "Name: "+name+"\nAddress: "+address+"\nEthnicity: "+ethnicity+"\nGender: "+gender+"\nPhone-Number: "+phoneNumber+"\n"+
        "Hours: "+hours+"\nPay-Rate:"+payRate+"\nInsurance:"+insurance+"\nUntaxed-Wage:"
        +df.format(unTaxedWage)+"\nTaxed-Wage: "+df.format(taxedWage)+"\n";


        return s;
    }
}
