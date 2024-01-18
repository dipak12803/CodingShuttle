package Recursion;

public class fibonacci {
    public static void main(String[] args) {
        int ans=fiboofN(9);
        System.out.println(ans);
    }
    static int fiboofN(int n){
        if(n<=1) return n;
        return fiboofN(n-1)+fiboofN(n-2);
    }
}
