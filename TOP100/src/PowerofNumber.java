import java.util.Scanner;

public class PowerofNumber {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int base= in.nextInt();
        int pow= in.nextInt();
        System.out.println(power(base,pow));


    }
    /*
    Recursive case:
If the exponent is even, split the calculation into smaller parts by calling power(base, exponent / 2) and squaring the result.
If the exponent is odd, reduce the exponent by 1 and multiply by the base at the end.
This approach, known as exponentiation by squaring, works in logarithmic time

O(logn), making it more efficient than the iterative method, especially for large exponents.
     */
    static long power(int base,int exponent){
        if(exponent==0){
            return 1;
        }
        else if(exponent%2==0){
            long halfPower=power(base,exponent/2);
            return halfPower*halfPower;
        }
        else{
            return base*power(base,exponent-1);

        }
    }
}
