package BitManipulation;

import java.util.Arrays;

public class Math1 {
    public static void main(String[] args) {
//        System.out.println(isPrime(17));
//        int n=100;
//        boolean[] isPrime=seiveofEratosthenes(n);
//        for(int i=2;i<=n;i++){
//            if(isPrime[i]){
//                System.out.print(i+" ");
//            }
//        }
        int a=20;
        int b=36;
        System.out.println(gcd(a,b));
        System.out.println(lcm(a,b));
       
    }
    static int lcm(int a,int b){
//        lcm*gcd=a*b
        int ans=(a*b)/gcd(a,b);
        return ans;

    }
    static int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);             //(12,18)->(18,12)->(12,6)->(6,0)
    }
    static int[] primeQueries(int q[][]){
        int n=q.length;
        int len=0;
        for(int i=0;i<n;i++){
            len=Math.max(len,q[i][1]);
        }
        boolean isPrime[]=seiveofEratosthenes(len);
        int count[]=new int[len+1];
        for(int i=1;i<=len;i++){
            if(isPrime(i)){
                count[i]=count[i-1]+1;
            }else{
                count[i]=count[i-1];
            }
        }
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            int leftCount=count[q[i][0]-1];
            int rightCount=count[q[i][1]];
            ans[i]=rightCount-leftCount;
        }
        return ans; 
    }
    static boolean isPrime(int n){
        for(int i=2;i*i<=n;i++){
            // i<=sqrt(n)  --> i*i<=n
            if(n%i==0) return false;
        }
        return true;
    }
    static boolean[] seiveofEratosthenes(int n){
        boolean isPrime[]=new boolean[n+1];
        Arrays.fill(isPrime,true);
        isPrime[0]=isPrime[1]=false;
        for(int i=2;i*i<=n;i++){
            for(int j=i*i;j<=n;j+=i){
                isPrime[j]=false;
            }
        }
        return isPrime;

    }
}
