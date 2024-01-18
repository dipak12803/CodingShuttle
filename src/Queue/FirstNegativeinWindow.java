package Queue;

import java.util.ArrayDeque;

public class FirstNegativeinWindow {
    public static void main(String[] args) {
        int[] a={4,6,-1,9,-2,-5,8};
        int[] ans=firstNegativeinWindow(a,3);
        for(int e:ans){
            System.out.print(e+" ");
        }
    }
    public static int[] firstNegativeinWindow(int[] a,int k){
        ArrayDeque<Integer> dq=new ArrayDeque<>();
        int i=0;
        while(i<k){
            if(a[i]<0){
                dq.offerLast(a[i]);
            }
            i++;
        }
        int n=a.length;
        int ans[]=new int[n-k+1];   //n-k+1 are number of windows
        for(;i<n;i++){
            if(dq.isEmpty()){
                ans[i-k]=0;
            }else{
                ans[i-k]=dq.peekFirst();
            }
            if(!dq.isEmpty() && dq.peekFirst()==a[i-k]){
                dq.pollFirst();
            }
            if(a[i]<0){
                dq.offerLast(a[i]);
            }
        }
        if(dq.isEmpty()){
            ans[n-k]=0;
        }else{
            ans[n-k]=dq.peekFirst();
        }
        return ans;
    }
}
