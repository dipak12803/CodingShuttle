import org.w3c.dom.ls.LSOutput;

import java.util.*;
public class SumofN_number {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int num=in.nextInt();
//        int ans=num*(num+1)/2;
//        System.out.println(ans);



    //using recursion
        System.out.println(sumRecursion(num));
    }

    public static int sumRecursion(int n){
        if(n==1) return 1;
        else return n+sumRecursion(n-1);
    }
}
