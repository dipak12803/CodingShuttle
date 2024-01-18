package BitManipulation;

public class Math2 {
    static int m= (int) (1e9+7);   //10^9+7
    public static void main(String[] args) {
        System.out.println(fastPowerm(3,5));
        System.out.println(factorial(5));
        System.out.println(nCr(5,3));

    }
    static int nCr(int n,int r){
        return multiplym(multiplym(factorial(n),inverse(factorial(n-r))),inverse(factorial(r)));
    }
    static int factorial(int n){   // nCr mod m
        int res=1;
        for(int i=1;i<=n;i++){
            res=multiplym(res,i);
        }
        return res;
    }
    static int inverse(int a){
        return fastPowerm(a,m-2);
    }
    static int divm(int a,int b){
        //use of fermet little theorem for fast power (b,m-2)
//        return multiplym(a,fastPowerm(b,m-2));
        return multiplym(a,inverse(b));
    }
    static int fastPowerm(int a,int b){  //   when b is even  a^b=> ((a)^2)^(b/2))
        int res=1;
        while(b>0){
            if((b&1)!=0){  //means b is odd
                res=res*a;   //now it becomes even
                //res=multiplym(res,a);   //because we want to do mod
            }
            a=a*a;
//            a=multiplym(a,a);   //we want to mod
            b=b/2;   //b>>1   means same

        }
        return res;

    }
    static int addm(int a,int b){
        return (a%m+b%m)%m;
    }
    static int multiplym(int a,int b){
        return (int) (((long)a%m*(long)b%m)%m);
    }
    static int subm(int a,int b){
        return (a%m - b%m + m)%m;
    }
}
