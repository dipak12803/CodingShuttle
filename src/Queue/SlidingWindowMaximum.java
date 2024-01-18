package Queue;

import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] a={2,3,1,4,5,};
        int[] ans=slidingWindowMaximum(a,3);
        for(int e:ans){
            System.out.print(e+" ");
        }
    }
    public static int[] slidingWindowMaximum(int[] a,int k){
        ArrayDeque<Integer> dq=new ArrayDeque<>();
        int i=0;
        while(i<k){
            while(!dq.isEmpty() && dq.getLast()<a[i]){
                dq.pollLast();
            }
            dq.offer(a[i]);
            i++;
        }
        int n=a.length;
        int ans[]=new int[n-k+1];
        for(;i<n;i++){
            ans[i-k]=dq.peekFirst();
            if(a[i-k]==dq.peekFirst()){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && dq.getLast()<a[i]){
                dq.pollLast();
            }
            dq.offerLast(a[i]);


        }
        ans[n-k]=dq.peekFirst();
        return ans;
    }
}
