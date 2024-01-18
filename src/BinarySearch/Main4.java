package BinarySearch;
import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        int[] a={1,7,6,3,4,7};
        int k=8;
        System.out.println(woodCutter(a,k));
    }

    static int aggressiveCows(int[] a,int k){
        int l=0,h=(int)1e9;
        Arrays.sort(a);
        int ans=-1;

        while(l<=h){
            int mid=l+(h-l)/2;
            if(isPossible(a,k,mid)){
                ans=mid;
                l=mid+1;
            }
            else{
                l=mid-1;
            }
        }
        return ans;


    }
    static boolean isPossible(int[] a,int k,int dist){
        int count=1;   //because first cow is placed
        int prev=a[0];  //first cow
        for(int i=1;i<a.length;i++){
            if(a[i]-prev>=dist){
                count++;
                prev=a[i];
            }
        }
        return count>=k;
    }
    static int woodCutter(int[] a,int k){
        int l=0,h=(int)1e9;
        while(l<=h){
            int mid=l+(h-l)/2;
            int totalWoodLength=getWoodAtCut(a,mid);
            if(totalWoodLength==k) return mid;
            else if(totalWoodLength>k){
                //increase the size of cut to reduce the wood length
                l=mid+1;
            }
            else{//woodlength is smaller so decrease the cut
                h=mid-1;

            }

        }
        return -1;
    }
    static int getWoodAtCut(int[] a,int cut){
        int ans=0;
        for(int e:a){
            ans+=(e>cut)?e-cut:0;   //if height of tree is less than cut than it adds 0 otherwise add subtract cut length from height


    
        }
        return ans;
    }
}
