package BitManipulation;

public class Bit3Lecture {
    public static void main(String[] args) {
//        int n=26;
//        System.out.println(clearLastSetBit(n));
//        System.out.println(countSetBits(n));
//        System.out.println(OptimisedCountBits(n));

//        int a[]={1,2,3,1,2,5};
//        int[] ans=twoUniqueNumbers(a);
//        System.out.println(ans[0]+" "+ans[1]);

        int a[]={1,3,4,8};
        int l=1;
        int r=3;
        System.out.println(xorQueries(a,l,r));
    }
    static int xorQueries(int[] a,int l,int r){
        int[] xor=new int[a.length];
        xor[0]=a[0];
        for(int i=1;i<a.length;i++){
            xor[i]=xor[i-1]^a[i];
        }
        int left=l==0?0:xor[l-1];
        int right=xor[r];
        return left^right;

    }
    static int[] twoUniqueNumbers(int[] a){
        int xor=0;
        for(int e:a){
            xor=xor^e;
        }
        int mask=xor&(-xor);
        int firstNumber=0;
        for(int e:a){
            if((mask&e)==0){
            firstNumber=firstNumber^e;
            }
        }
        int secondNumber=xor^firstNumber;
        int[] ans=new int[2];
        ans[0]=firstNumber;
        ans[1]=secondNumber;
        return ans;

    }

static int clearLastSetBit(int n){
    return n&(n-1);
}
static int countSetBits(int n){
        int count=0;
        while(n!=0){
            if((n&1)!=0){
                count++;
            }
            n=n>>1;
        }
        return count;
}
static int OptimisedCountBits(int n){
        int count=0;
        while(n!=0){
            n=n&(n-1);
            count++;
        }
        return count;
}
}
