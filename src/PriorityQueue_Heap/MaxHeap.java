package PriorityQueue_Heap;

public class MaxHeap {
    int[] a;
    int capactity;
    int size;
    public MaxHeap(int capactity){
        this.capactity=capactity;
        a=new int[capactity];
        size=0;
    }
    public boolean insert(int e){
        if(size==capactity) return false;
        a[size]=e;
        int i=size;
        while(i>0){
            int parent=(i-1)/2;
            if(a[parent]<a[i]){
                swap(i,parent);
                i=parent;
            }
            else break;

        }
        size++;
        return true;

    }
    public int pop() throws Exception {
        if(size==0) throw new Exception("Empty Priority Queue");
        size--;
        int temp=a[0];    //storing the root node which is parent
        a[0]=size;

        a[0]=a[size];     //parent node is replaced with parent node
        heapify(0);
        return temp;
    }
    public void heapify(int i){
        if(i>=size) return;
        int left=2*i+1;
        int right=2*i+2;

        int larger=i;
        if(left<size && a[left]>a[i]){
            larger=left;
        }
        if(right<size && a[right]>a[larger]){
            larger=right;
        }
        if(larger!=i){
            swap(larger,i);
            heapify(larger);
        }

    }
    public void swap(int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    public void print(){
        for(int i=0;i<size;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

 ///////////////// Priority Queue 2 ////////////////////////////////////
   public void buildHeap(int[] b){
        if(b.length>capactity) return;
        for(int i=0;i<b.length;i++){
            a[i]=b[i];
        }
        size=b.length;

        for(int i=size/2;i>=0;i--){  //leaf nodes does not have left and right so need to heapify
            heapify(i);
        }
        for(int i=0;i<b.length;i++){
            b[i]=a[i];
        }
   }
   public void heapSort(int[] b) throws Exception {
        buildHeap(b);
        for(int i=b.length-1;i>=0;i--){
            b[i]=pop();
        }
   }

}
