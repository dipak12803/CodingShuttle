package Advance_Sorting;

public class Quick {
    public static void main(String[] args) {
        int a[]={4,6,2,5,7,9,1,3};
        quickSort(a,0,a.length-1);
        for(int e:a){
            System.out.println(e);
        }

    }
    static void quickSort(int[] a,int l,int r){
        if(l<r){
            int pivot=partition(a,l,r);
            quickSort(a,l,pivot-1);
            quickSort(a,pivot+1,r);
        }
    }
    static int partition(int[] a,int l,int r){
        int pivot=a[l];
        int i=l,j=r;            // i starts from leftmost and j starts from rightmost
        while(i<=j){
            while(i<=r && a[i]<=pivot) i++;
            while(j>=0 && a[j]>pivot) j--;
            if(i<j) swap(a,i,j);
        }
        swap(a,l,j);
        return j;
    }
    static void swap(int[] a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
