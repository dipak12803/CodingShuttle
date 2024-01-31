package Hashing;
import java.util.*;

public class Hashing4 {
    public static void main(String[] args) {
//        int[] a={1,2,1,3,4,2,3};
//        int k=4;
//        int[] ans=uniqueInEachWindow(a,k);
//        for(int e:ans){
//            System.out.print(e+" ");
//        }

        String s="abcdcbecada";
        System.out.println(longestUniqueSubstring(s));

    }
    static int[] uniqueInEachWindow(int[] a,int k){
        int n=a.length;
        int[] ans=new int[n-k+1];
        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<k;i++){
            if(map.containsKey(a[i])){
                map.put(a[i],map.get(a[i])+1);
            }
            else{
                map.put(a[i],1);
            }
        }
        for(int i=k;i<n;i++){
            ans[i-k]=map.size();
            int left=i-k;  //left most element to be removed from window
            int right=i;  //next right element to be added in window
            int freqLeft=map.get(a[left]);

            if(freqLeft==1){
                map.remove(a[left]);
            }
            else{
                map.put(a[left],freqLeft-1);   //decrement the frequency by 1 because it is not the part of window

            }

            //if the right element is already present then increment its counter
            if(map.containsKey(a[right])){
                map.put(a[right],map.get(a[right])+1);
            }
            else{
                map.put(a[right],1);
            }

        }
        ans[n-k]=map.size();
        return ans;
    }
    static int longestUniqueSubstring(String s){
        Map<Character,Integer> map=new HashMap<>();
        int l=0,r=0;
        int ans=0;
        while(r<s.length()){
            if(!map.containsKey(s.charAt(r)) || map.get(s.charAt(r))<l){
           // map.get(s.charAt(r))<l) : this means that character is present in the map
 // but it is not present in the window so it occurs first time in the window

 //then we will check the size of window
                ans=Math.max(ans,r-l+1);
            }
            else{
    //the character is present in the window , so we will update the window size
    //window left pointer will be updated by the next of current position of the char

                l=map.get(s.charAt(r))+1;
            }
            map.put(s.charAt(r),r);
            r++;

        }
        return ans;
    }
}
