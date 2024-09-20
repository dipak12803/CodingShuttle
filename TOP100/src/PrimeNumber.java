import java.util.*;
public class PrimeNumber {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        boolean isPrime=true;
        if(n<2) isPrime=false;
        if(n==2) isPrime=true;
        //check from 3 and for every odd number till sqrt of n
        for(int i=3;i<=Math.sqrt(n);i+=2){
            if(n%i==0){
               isPrime=false;
            break;
            }
        }
        if(isPrime) System.out.println("Prime number");
        else System.out.println("Not a prime number");
    }
}
