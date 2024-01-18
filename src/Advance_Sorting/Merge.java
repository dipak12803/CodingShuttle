package Advance_Sorting;

public class Merge {
    public static void main(String[] args) {
        int[] a={6,5,12,10,9};
        mergeSort(a,0,a.length-1);
        for(int e:a){
            System.out.print(e+" ");
        }

    }
    static void mergeSort(int[] a,int l,int r){
        if(l<r){
            int mid=(l+r+1)/2;
            mergeSort(a,l,mid-1);
            mergeSort(a,mid,r);
            merge(a,l,mid,r);
        }

    }
    static void merge(int[] a,int l,int mid,int r){
        int n1=mid-l;
        int n2=r-mid+1;
        int[] L=new int[n1];
        int[] R=new int[n2];
        for(int i=l;i<mid;i++){
            L[i-l]=a[i];

        }
        for(int i=mid;i<=r;i++){
            R[i-mid]=a[i];
        }
        //i is for left array , j is for right array , k is for original array

        int i=0,j=0,k=l;
        while(i<n1 && j<n2){
            if(L[i]<R[j]){
                a[k]=L[i];
                i++;
            }
            else{
                a[k]=R[j];
                j++;
            }
            k++;
        }
        while(i<n1){  //  j is exhausted and some elements remaining  in left array so fill them as it is
            a[k]=L[i];
            i++;
            k++;
        }
        while(j<n2){
            a[k]=R[j];
            j++;k++;
        }

    }
}
