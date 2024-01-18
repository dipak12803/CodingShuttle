package Stack;

import java.util.*;

public class leftrightSmaller {
    public static void main(String[] args) {
//        int a[]={1,6,4,10,2,4};
//        int ans[]=smalleronRight(a);
        int[] a={10,20,30,50,10,70,30};
        int[] ans=maxMinArray(a);
        for(int i:ans){
            System.out.println(i+" ");
        }

    }
    static int[] maxMinArray(int a[]){ //Maximum of minimum of every window size
        int left[]=smalleronLeft(a);
        int right[]=smalleronRight(a);
        int n= a.length;
        int[] ans=new int[n];
        Arrays.fill(ans,Integer.MIN_VALUE);
        for(int i=0;i<n;i++){
            int windowlength=right[i]-left[i]-1;
            ans[windowlength-1]=Math.max(ans[windowlength-1],a[i]);

        }
        for(int i=n-2;i>=0;i--){
            ans[i]=Math.max(ans[i],ans[i+1]);
        }
        return ans;
    }
    static int[] smalleronRight(int[] a){
        int n=a.length;
            int ans[]=new int[n];
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && a[stack.peek()]>=a[i]){
                stack.pop();
            }//after this while loop breaks we get either empty stack or stack which has value less than a[i]
            //on the top of the stack
            if(stack.isEmpty()){
                ans[i]=n;
            }
            else{
                ans[i]=stack.peek();  //element which is at top of stack will be stored in answer
            }
            stack.push(i);
        }
        return ans;


    }
    static int[] smalleronLeft(int[] a){
        int n=a.length;
        int[] ans=new int[n];
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && a[stack.peek()]>=a[i]){
                stack.pop();
            }//after this while loop breaks we get either empty stack or stack which has value less than a[i]
            //on the top of the stack
            if(stack.isEmpty()){
                ans[i]=-1;
            }
            else{
                ans[i]=stack.peek();  //element which is at top of stack will be stored in answer
            }
            stack.push(i);
        }
        return ans;
    }
}
