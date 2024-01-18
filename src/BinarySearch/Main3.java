package BinarySearch;

public class Main3 {
    public static void main(String[] args) {
//        System.out.println(sqrt(150));
        System.out.println(sqrt(2199));
//        int[] a={3,5,6};
//        int[] b={2,4,10,12};
//        System.out.println(medianOfTwoSortedArray(a,b));
        int[] a={165, 242, 335, 460, 541, 646, 709, 796, 924, 997};
        int[] b={24 ,58 ,102, 149 ,200 ,333 ,453 ,627 ,725 ,744 ,871 ,935};
        System.out.println(medianOfTwoSortedArray(a,b));
    }
    static int sqrt(int n){
        int l=1,r=n;
        int ans=-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(mid*mid==n) return mid;
            if(mid*mid>n) r=mid-1;   //search in left half
            else{  //search in right half
                ans=mid;  //this can be potential answer
                l=mid+1;
            }


        }
        return ans;
    }
    static double medianOfTwoSortedArray(int[] a,int[] b){
//        HARD question
        int n1=a.length;
        int n2=b.length;
        int n=n1+n2;
        int left=(n+1)/2;
        if(n1>n2){
            return medianOfTwoSortedArray(b,a);
        }
        int l=0,r=n1;
        while(l<=r){
            int mid1=(l+r)/2;
            int mid2=left-mid1;
            int l1=mid1<=0?Integer.MIN_VALUE:a[mid1-1];
            int l2=mid2<=0?Integer.MIN_VALUE:b[mid2-1];
            int r1=mid1==n1?Integer.MAX_VALUE:a[mid1];
            int r2=mid2==n2?Integer.MAX_VALUE:b[mid2];

            if(l1<=r2 && l2<=r1){  //found the median postion
                if(n%2==0){  //even no. of elements
                    return (double)(Math.max(l1,l2)+Math.min(r1,r2))/2;
                }
                else{ //odd number of elements
                    return Math.max(l1,l2);
                }

            }
            else if(l1>r2){
                r=mid1-1;
            }
            else if(l2>r1){
                l=mid1+1;
            }

        }
        return 0;
    }
}
