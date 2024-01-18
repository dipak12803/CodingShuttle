package ArrayBasic;

public class SortingAlgorithms {
    public static void main(String[] args) {
        int[] a={1,4,8,2,3,7};
//        bubbleSort(a);
//        selectionSort(a)
        insertionSort(a);
        for(int it:a){
            System.out.println(it+" ");
        }
    }

    static void insertionSort(int[] a){
        int n= a.length;
        for(int i=1;i<n-1;i++){  //i=2
            //i=0 is considered to be sorted
            int last=a[i];    //last=8
            int swapIndex=i-1;  //
            while(swapIndex>=0 && a[swapIndex]>last){
                swapIndex--;
            }
            int j=i;
            while(j>swapIndex+1){
                a[j]=a[j-1];
                j--;
            }
            a[swapIndex+1]=last;
        }
    }

    static void selectionSort(int[] a){
        int n=a.length;
        for(int i=0;i<n-1;i++){
            int min=i; // to keep the track of i'th index
            for(int j=i+1;j<n;j++){
                if(a[j]<a[min]){   //it will give the smallest number
                    min=j;   //smallest will be stored here
                }
            }
//            then it is swapped
            int temp=a[i];
            a[i]=a[min];
            a[min]=temp;
        }
    }
    public static void bubbleSort(int[] a){
        int n=a.length;
        for(int i=0;i<n-1;i++){
            boolean didIswap=false;
            for(int j=0;j<n-i-1;j++){
                if(a[j+1]<a[j]){
                    int temp=a[j+1];
                    a[j+1]=a[j];
                    a[j]=temp;
                    didIswap=true;
                }
            }
            if(!didIswap) break;
        }
    }
}
