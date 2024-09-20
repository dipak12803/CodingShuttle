import java.util.*;
public class LeapYear {
    public static void main(String[] args) {
        /*
        For any year to be a leap year the following two conditions must be checked. If the year satisfies either of the conditions, it's considered a leap year. Following are the conditions
1. The year must be divisible by 400.
2. The year must be divisible by 4 but not 100.
         */
        Scanner in=new Scanner(System.in);
        int year=in.nextInt();
        if(year%400==0 || (year%4==0 && year%100!=0)){
            System.out.println("Leap Year");
        }
        else{
            System.out.println("Not a leap year");
        }

    }
}
