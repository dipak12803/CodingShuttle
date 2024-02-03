package PriorityQueue_Heap;

import javax.swing.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Lec3 {
    public static void main(String[] args) {
//        int[] a={4,1,9,6,3,7};
//        System.out.println(kthLargestElement(a,2));

//        int[] a={90,15,10,7,12,2};
//        System.out.println(isHeap(a,a.length));

//        Integer a[]={1,7,9,2,12,3,3};
        Integer a[]={7,2,5,10,8};
        System.out.println(divideSubsets(a,2));
        //    10 8 7 5 2
        //     0                       0
        //     10+5=15               8+7=15
        //

    }
    static int kthLargestElement(int[] a,int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int e:a){
            pq.add(e);

            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }
    static boolean isHeap(int[] a,int n){

        return isHeapHelper(a,n,0);
    }
    static boolean isHeapHelper(int[] a,int n,int i){
        if(i>=n/2) return true;  //because they are leaf node so they dont need to check
        //left and right node

        int left=2*i+1;
        int right=2*i+2;

        if(a[i]>=a[left] && isHeapHelper(a,n,left)){
            if(right<n){
                return a[i] >= a[right] && isHeapHelper(a, n, right);
            }
            else return true;
        }
        return false;

    }
    static int divideSubsets(Integer a[],int m){
        int n=a.length;
        Arrays.sort(a,Collections.reverseOrder());
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<m;i++){
            pq.add(0);
        }
        for(int e:a){
            int smallest=pq.poll();
            pq.add(smallest+e);
        }

        //remove the (m-1) elements from heap then remaining element is the maximum answer
        for(int i=0;i<m-1;i++){
            pq.poll();

        }

        //pop that remaining element
        return pq.poll();
    }
}
