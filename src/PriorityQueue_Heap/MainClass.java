package PriorityQueue_Heap;

public class MainClass {
    public static void main(String[] args) throws Exception {
        MaxHeap heap=new MaxHeap(10);
//        heap.insert(50);
//        heap.insert(100);
//        heap.insert(10);
//
//        System.out.println(heap.pop());
//
//        heap.print();

        int[] b={5,1,8,2,3,15};
//        heap.buildHeap(b);

        heap.heapSort(b);
        for(int e:b){
            System.out.print(e+" ");
        }
    }
}
