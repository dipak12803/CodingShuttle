import java.util.*;
public class SumOfDigits {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int sum=0;
        while(n>0){
            sum+=n%10;
            n/=10;
        }
        System.out.println(sum);
    }

    //for sum until the result has single digit
    public int addDigits(int num) {

        if(num==0) return 0;

            //property : if any number is divisible by 9 then its single digit sum is always 9 . eg. 99 => 9+9 -> 18 -> 1+8=9
        else if(num%9==0) return 9;

        // otherwise the number%9 will always give sum of digits in single digit
        return num%9;
    }
    /*
    static int getSum (int num)
   {

     if (num == 0)
       return 0;

     return (num % 10) + getSum (num / 10);
   }
     */
}
