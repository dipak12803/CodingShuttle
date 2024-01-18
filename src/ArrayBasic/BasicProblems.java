package ArrayBasic;

public class BasicProblems {
    public BasicProblems() {
    }
    public static void main(String[] args) {
//        Last number in sorted postion
        int[] a={2,5,6,8,9,4};
        lastnumberinSortedPosition(a);
        for(int it:a){
            System.out.print(it+" ");
        }
    }
    static void lastnumberinSortedPosition(int[] a){
        int n=a.length;
        int last=a[n-1]; //storing the last number in a variable
        int swapIndex=n-2;

        while(swapIndex>=0 && a[swapIndex]>last){
            swapIndex--;

        }
        for(int i=n-1;i>=swapIndex+2;--i){
            a[i]=a[i-1];

        }
        a[swapIndex+1]=a[last];
    }
}
