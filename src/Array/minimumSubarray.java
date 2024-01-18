package Array;

public class minimumSubarray {
    public static void main(String[] args) {
        int a[]={1,2,5,6,7,2};
        int target=9;
        System.out.println(minimumSumsubArray(a,target));
    }
    public static int minimumSumsubArray(int a[],int target){
        int l=0,r=0;  //initialise left and right pointer
        int x=-1,y=-1;  //initialise the index range
        int currSum=0;  //cumulative sum initially 0
        int minLength=Integer.MAX_VALUE;
        int n=a.length;
        while(r<n){
            currSum+=a[r];  //finding cumulative sum
            while(currSum>=target){  //when cumulative sum is greater than equal to target
//                minLength=Math.min(minLength,r-l+1);  //r-l+1 --> window length
                if(r-l+1<minLength){  //check if current window length is less than minimum length
                    minLength=r-l+1;  //if it is then update the minimum length
                    x=l;     //update the starting index
                    y=r;     //update the ending index

                }
                currSum-=a[l];  //now reduce the cumulative sum from left
                l++;   //by incrementing the left
            }
            r++;   //further calculate the cumulative sum after no subarray is greater than equal to target
        }
        if(minLength==Integer.MAX_VALUE){  // if no subarray or cumulative sum found greater than target
            minLength=0;              //then the length is zero
        }
        System.out.println("From index "+x+" to  "+y);
        return minLength;
    }
}
