import java.util.Scanner;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.text.DecimalFormat;
public class Payment 
{
    Scanner in = new Scanner(System.in);

    private static final DecimalFormat df = new DecimalFormat("0.00");
    private double miles;
    private LocalDate pickup;
    private LocalDate dropoff;
    private int timeInDays;
    private boolean discountApplied;
    private double discountPerc;
    private boolean wasCleanupNeeded;
    private double total;
    private Customer cust;
    private Vehicle vehi;
    private int check = 0;   //at zero current payment at 1 payment no longer in use

    /*set miles and getm miles for a payment object*/
    public void setMiles(double mile)
    {
        miles =mile;
    }
    public double getMiles()
    {
        return miles;
    }

    /*
     * takes the string in format of(mm/dd/yyyy) and splits it up into m d and y and sends it to the month method
     * 2nd method returns the Local date
    */
    public void setPickup(String pickup)
    {
        int m = Integer.valueOf(String.valueOf(pickup.charAt(0)-48)+String.valueOf(pickup.charAt(1)-48));
        int d = Integer.valueOf(String.valueOf(pickup.charAt(3)-48)+String.valueOf(pickup.charAt(4)-48));
        int y = Integer.valueOf(String.valueOf(pickup.charAt(6)-48)+String.valueOf(pickup.charAt(7)-48)
        +String.valueOf(pickup.charAt(8)-48)+String.valueOf(pickup.charAt(9)-48)); 
        month(m,d,y);
    }
    public LocalDate getPickup()
    {
        return pickup;
    }
    /* takes the string in format of(mm/dd/yyyy) and splits it up into m d and y and sends it to the monthDrop method
     * 2nd method returns the Local date
    */
    public void setDropoff(String dropoff)
    {
        int m = Integer.valueOf(String.valueOf(dropoff.charAt(0)-48)+String.valueOf(dropoff.charAt(1)-48));
        int d = Integer.valueOf(String.valueOf(dropoff.charAt(3)-48)+String.valueOf(dropoff.charAt(4)-48));
        int y = Integer.valueOf(String.valueOf(dropoff.charAt(6)-48)+String.valueOf(dropoff.charAt(7)-48)
        +String.valueOf(dropoff.charAt(8)-48)+String.valueOf(dropoff.charAt(9)-48)); 
        monthDrop(m, d, y);
    }
    public LocalDate getDropoff()
    {
        return dropoff;
    }

    /*
     * finds how many days between pickup and dropoff and set timeInDays
    */
    public void setTimeInDays()
    {
        Period diff = Period.between(this.pickup, this.dropoff);
        timeInDays = diff.getDays()+(diff.getMonths()*30)+(diff.getMonths()*365);
    }

    /**
     * set and get the parameter for if discount was applied
     */
    public void setDiscountApplied(boolean disc){discountApplied=disc;}
    public boolean getDiscountApplied(){return discountApplied;}

    /*
     * sets and gets the multiplier for if the discount would be applied
    */
    public void setDiscountPercentage(double percent){discountPerc=percent;}
    public double getDiscountPercentage(){return discountPerc;}

    /*
     * set and gets the boolean for if the vehicle needed to be cleaned after the rentals
    */
    public void setWasCleanupNeeded(boolean needed){wasCleanupNeeded=needed;}
    public boolean getWasCleanupNeeded(){return wasCleanupNeeded;}

    /*
     * uses the variables that the class has to calculate and set total and depends
     * on if a discount is applied or if needed to be cleaned
     * and the get total return the number
    */
    public void setTotal()
    {
        if(wasCleanupNeeded==true)
        {
            if(discountApplied==true){
                total = (((miles/25*vehi.get25Rate()))+(timeInDays*vehi.getPerDayRate())+(50))*discountPerc;
            }
            else
            {
                total = (((miles/25*vehi.get25Rate()))+(timeInDays*vehi.getPerDayRate())+(50));
            }
        }
        else
        {
            if(discountApplied==true){
                total = (((miles/25*vehi.get25Rate()))+(timeInDays*vehi.getPerDayRate()))*discountPerc;
            }
            else
            {
                total = (((miles/25*vehi.get25Rate()))+(timeInDays*vehi.getPerDayRate()));
            }
        }
    }
    public double getTotal(){return total;}

    /*
     * get and set the customer that the payment is for
    */
    public void setCustomer(Customer customer){cust=customer;}
    public Customer getCustomer(){return cust;}

    /*
     * get and set the vehicle that was rented
    */
    public void setVehicle(Vehicle vehicle){vehi=vehicle;}
    public Vehicle getVehicle(){return vehi;}

    /*
     * sets and gets a check value that is used to remove oldest payment from search
    */
    public void setCheck(){check=1;}
    public int getCheck(){return check;}

    /*
     * takes a vehicle and a customer and prompts for user for variables of the Payment
    */
    public void createPayment(Vehicle vehicle,Customer customer)
    {
        cust =customer;
        vehi=vehicle;
        System.out.println("enter the new mileage of the vehicle(old mileage:"+vehi.getMileage()+"): ");
        this.miles = in.nextDouble()-vehicle.getMileage();
        vehicle.setMileage(vehicle.getMileage()+(int)this.miles);

        System.out.println("enter date of pickup date(mm/dd/yyyy)");
        String pickup = in.next();
        int m = Integer.valueOf(String.valueOf(pickup.charAt(0)-48)+String.valueOf(pickup.charAt(1)-48));
        int d = Integer.valueOf(String.valueOf(pickup.charAt(3)-48)+String.valueOf(pickup.charAt(4)-48));
        int y = Integer.valueOf(String.valueOf(pickup.charAt(6)-48)+String.valueOf(pickup.charAt(7)-48)
        +String.valueOf(pickup.charAt(8)-48)+String.valueOf(pickup.charAt(9)-48)); 
        month(m,d,y);

        System.out.println("enter date of dropoff date(mm/dd/yyyy)");
        String dropoff = in.next();
        m = Integer.valueOf(String.valueOf(dropoff.charAt(0)-48)+String.valueOf(dropoff.charAt(1)-48));
        d = Integer.valueOf(String.valueOf(dropoff.charAt(3)-48)+String.valueOf(dropoff.charAt(4)-48));
        y = Integer.valueOf(String.valueOf(dropoff.charAt(6)-48)+String.valueOf(dropoff.charAt(7)-48)
        +String.valueOf(dropoff.charAt(8)-48)+String.valueOf(dropoff.charAt(9)-48)); 
        monthDrop(m, d, y);

        
        Period diff = Period.between(this.pickup, this.dropoff);
        timeInDays = diff.getDays()+(diff.getMonths()*30)+(diff.getMonths()*365);

        System.out.println("is discount applied(true or false): ");
        discountApplied = in.nextBoolean();

        if(discountApplied==true)
        {
            System.out.println("enter percentage off as whole number: ");
            discountPerc=(100-in.nextDouble())/100;
        }
        System.out.println("was cleanup necessary: ");
        wasCleanupNeeded  = in.nextBoolean();
        if(wasCleanupNeeded==true)
        {
            if(discountApplied==true){
                total = (((miles/25*vehicle.get25Rate()))+(timeInDays*vehicle.getPerDayRate())+(50))*discountPerc;
            }
            else
            {
                total = (((miles/25*vehicle.get25Rate()))+(timeInDays*vehicle.getPerDayRate())+(50));
            }
        }
        else
        {
            if(discountApplied==true){
                total = (((miles/25*vehicle.get25Rate()))+(timeInDays*vehicle.getPerDayRate()))*discountPerc;
            }
            else
            {
                total = (((miles/25*vehicle.get25Rate()))+(timeInDays*vehicle.getPerDayRate()));
            }
        }
        System.out.println(df.format(total));
        cust.addToNumOfRent();
    }

    /*
     * used to set and figure out the month for the Local date to be made
    */
    private void month(int m,int d,int y)
    {
        switch(m)
        {
            case 1:
            this.pickup=LocalDate.of(y,Month.JANUARY,d);
            break;
            case 2:
            this.pickup=LocalDate.of(y,Month.FEBRUARY,d);
            break;
            case 3:
            this.pickup=LocalDate.of(y,Month.MARCH,d);
            break;
            case 4:
            this.pickup=LocalDate.of(y,Month.APRIL,d);
            break;
            case 5:
            this.pickup=LocalDate.of(y,Month.MAY,d);
            break;
            case 6:
            this.pickup=LocalDate.of(y,Month.JUNE,d);
            break;
            case 7:
            this.pickup=LocalDate.of(y,Month.JULY,d);
            break;
            case 8:
            this.pickup=LocalDate.of(y,Month.AUGUST,d);
            break;
            case 9:
            this.pickup=LocalDate.of(y,Month.SEPTEMBER,d);
            break;
            case 10:
            this.pickup=LocalDate.of(y,Month.OCTOBER,d);
            break;
            case 11:
            this.pickup=LocalDate.of(y,Month.NOVEMBER,d);
            break;
            case 12:
            this.pickup=LocalDate.of(y,Month.DECEMBER,d);
            break;
        }
    }

    /*
     * for the dropoff Local date to be made and month to be determined
    */
    private void monthDrop(int m,int d,int y)
    {
        switch(m)
        {
            case 1:
            this.dropoff=LocalDate.of(y,Month.JANUARY,d);
            break;
            case 2:
            this.dropoff=LocalDate.of(y,Month.FEBRUARY,d);
            break;
            case 3:
            this.dropoff=LocalDate.of(y,Month.MARCH,d);
            break;
            case 4:
            this.dropoff=LocalDate.of(y,Month.APRIL,d);
            break;
            case 5:
            this.dropoff=LocalDate.of(y,Month.MAY,d);
            break;
            case 6:
            this.dropoff=LocalDate.of(y,Month.JUNE,d);
            break;
            case 7:
            this.dropoff=LocalDate.of(y,Month.JULY,d);
            break;
            case 8:
            this.dropoff=LocalDate.of(y,Month.AUGUST,d);
            break;
            case 9:
            this.dropoff=LocalDate.of(y,Month.SEPTEMBER,d);
            break;
            case 10:
            this.dropoff=LocalDate.of(y,Month.OCTOBER,d);
            break;
            case 11:
            this.dropoff=LocalDate.of(y,Month.NOVEMBER,d);
            break;
            case 12:
            this.dropoff=LocalDate.of(y,Month.DECEMBER,d);
            break;
        }
    }

    /*
     * prints out the payment out as a String and returns it
    */
    public String toString()
    {
        String s;
        s="Miles driven:"+miles+"\nPickup: "+pickup+"\nDropoff: "+dropoff+"\nDiscount applied: "+discountApplied
        +"\nDiscount Percentage: "+discountPerc+"\nCleanup needed: "+wasCleanupNeeded+"\nTotal:"+df.format(total);
        return s;
    }
}
