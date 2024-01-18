package BinarySearch;

public class Main {
    public static void main(String[] args) {
        int[] a={1,2,3,4,4,4,5,6,9};
        int k=4;
//        System.out.println(binarySearchiterative(a,k));
//        System.out.println(binarySearchRecursive(a,k,0,a.length-1));
//        System.out.println(lastOccurence(a,k));
        System.out.println(countOccurence(a,k));
    }
    static int binarySearchiterative(int[] a,int k){
        int l=0,r=a.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(a[mid]==k) return mid;
            if(k<a[mid]) r=mid-1;
            else if(k>a[mid]) l=mid+1;
        }
        return -1;
    }
    static int binarySearchRecursive(int[] a,int k,int l,int r) {
        if (l > r) return -1;
        int mid = l + (r - l) / 2;
        if (a[mid] == k) return mid;
        if (k < a[mid]) return binarySearchRecursive(a, k, l, mid - 1);
        return binarySearchRecursive(a, k, mid + 1, r);


    }
    static int firstOccurence(int[] a,int k){
        //Every thing same as binary search code just check the mid condition
        int l=0,r=a.length-1;
        int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(k<a[mid]) r=mid-1;
            else if(k>a[mid]) l=mid+1;
            else {            //Main Step
                r=mid-1;      //check further left if same number is present if not the mid is the answer
                ans=mid;
            }
        }
        return ans;
    }
    static int lastOccurence(int[] a,int k){
        int l=0,r=a.length-1;
        int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(k<a[mid]) r=mid-1;
            else if(k>a[mid]) l=mid+1;
            else {
                l=mid+1;
                ans=mid;
            }
        }
        return ans;
    }
    static int countOccurence(int[] a,int k){
        int fo=firstOccurence(a,k);
        if(fo==-1) return 0;
        int lo=lastOccurence(a,k);
        return lo-fo+1;
    }
}
