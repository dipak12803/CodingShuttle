package BinarySearch;

public class Main2 {
    public static void main(String[] args) {
        int[] a={2,4,5,5,6,7,10};
        int k=5;
        System.out.println(upperBound(a,k));

    }

    static int upperBound(int[] a,int k){  //ceil value
        int l=0,r=a.length-1;
        int ans=a.length;  //if number is greater than last number then answer should be
        // next index of last position
        while(l<=r){
            int mid=l+(r-l)/2;
            if(k<a[mid]){
                ans=mid;  //it can be potential answer
                r=mid-1;  //but still check for less than mid
            }
            else if(k>=a[mid]){
                l=mid+1;  //if target is greater or equal to mid then search after mid
            }

        }
        return ans;
    }
    static int lowerBound(int[] a,int k){  //floor value
        int l=0,r=a.length-1;
        int ans=-1;  //if number is smaller than first indexed element then return -1
        while(l<=r){
            int mid=l+(r-l)/2;
            if(k<=a[mid]){
                r=mid-1; //if k is less than or equal to mid ,then our answer is in left
                //of mid so reduce search space to less than mid.
            }
            else if(k>a[mid]){
                ans=mid;   //mid can be potential answer which can be lesser than k
                l=mid+1;   //but still check for greater than mid
            }

        }
        return ans;
    }
    static int findInSortedRotatedArray(int[] a,int k){
        int l=0,r=a.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(a[mid]==k) return mid;
            //below condition check for duplicate elements
            if(a[mid]==a[l] && a[mid]==a[r]){
                l++;
                r--;
            }

            else if(a[l]<a[mid]){  //left part is sorted
                if(a[l]<=k && k<a[mid]){
                    r=mid-1;
                }
                else{
                    l=mid+1;
                }
            }
            else{  //right part is sorted
                if(a[mid]<k && k<=a[r]){
                    l=mid+1;
                }
                else{
                    r=mid-1;
                }
            }
        }
        return -1;

    }
}
