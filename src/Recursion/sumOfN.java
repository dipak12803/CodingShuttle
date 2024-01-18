package Recursion;

public class sumOfN {
    public static void main(String[] args) {
        int ans=sumofN(5);
        System.out.println(ans);
    }
    static int sumofN(int n){
        if(n==1) return 1;
        return sumofN(n-1)+n;


    }
}
