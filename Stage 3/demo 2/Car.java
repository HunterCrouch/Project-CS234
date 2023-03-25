public class Car extends Vehicle 
{
    private boolean manual;
    private String make;
    private int year;
    private String color;   
    Car()
    {
        super();
    }
    public boolean getManual(){return manual;}

    public String getMake(){return make;}

    public int getYear(){return year;}

    public String getColor(){return color;}
    public void setColor(String clr){color=clr;}
}
