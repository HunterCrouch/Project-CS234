import java.util.Scanner;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
public class Payment 
{
    Scanner in = new Scanner(System.in);

    private double miles;
    private LocalDate pickup;
    private LocalDate dropoff;
    private int timeInDays;
    private boolean discountApplied;
    private double discountPerc;
    private boolean wasCleanupNeeded;
    private double total;

    Payment(Vehicle vehicle,Customer customer)
    {
        System.out.println("enter the new mileage of the vehicle");
        this.miles = in.nextDouble()-vehicle.getMileage();

        System.out.println("enter date of pickup date(mm/dd/yyyy)");
        String pickup = in.next();
        int m = Integer.valueOf(String.valueOf(pickup.charAt(0)-48)+String.valueOf(pickup.charAt(1)-48));
        int d = Integer.valueOf(String.valueOf(pickup.charAt(3)-48)+String.valueOf(pickup.charAt(4)-48));
        int y = Integer.valueOf(String.valueOf(pickup.charAt(6)-48)+String.valueOf(pickup.charAt(7)-48)
        +String.valueOf(pickup.charAt(8)-48)+String.valueOf(pickup.charAt(9)-48)); 
        month(m,d,y);
        dropoff = LocalDate.now();
        Period diff = Period.between(this.pickup, dropoff);
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
        System.out.println(total);

    }
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
}
