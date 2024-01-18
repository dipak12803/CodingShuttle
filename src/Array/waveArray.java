package Array;

import java.util.Arrays;

public class waveArray {
    public static void main(String[] args) {
        int a[]={1,2,3,4,5};
        waveArr(a);
        printArray(a);

    }
    static void waveArr(int[] a){  //O(nlogn)
        Arrays.sort(a);
        int n=a.length;
        for(int i=1;i<n;i+=2){
            int temp=a[i];
            a[i]=a[i-1];
            a[i-1]=temp;
        }

    }
    static void waveArrayNotLexographic(int[] a){  //O(n)
        int n=a.length;
        for(int i=1;i<n;i+=2){
            if(a[i]>a[i-1]){
                swap(a,i,i-1);

            }
            if(i<n-1 && a[i]>a[i+1]){
                swap(a,i,i+1);
            }
        }
    }
    static void swap(int[] a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    static void printArray(int[] a){
        for(int e:a){
            System.out.print(e+" ");
        }
    }
}
