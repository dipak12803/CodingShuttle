import java.util.*;
public class EvenorOdd {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int num=in.nextInt();
//        if(num%2==0) System.out.println("Even");
//        else System.out.println("Odd");

        if((num&1)==1) System.out.println("Odd");
        else System.out.println("Even");
    }
}
