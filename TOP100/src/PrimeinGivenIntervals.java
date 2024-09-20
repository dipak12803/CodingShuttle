import java.util.*;
public class PrimeinGivenIntervals {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
//        int n=in.nextInt();
        System.out.println("Enter starting range ");
        int start=in.nextInt();
        System.out.println("Enter ending range ");
        int end=in.nextInt();
        for(int i=start;i<end;i++){
            if(isPrime(i)){
                System.out.print(i+" ");
            }
        }

    }
    static boolean isPrime(int n){
        if(n<2) return false;
        if(n==2) return true;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        return true;
    }
}
