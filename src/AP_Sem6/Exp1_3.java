package AP_Sem6;

import java.util.PriorityQueue;

class KthLargest {
    private PriorityQueue<Integer> heap = new PriorityQueue<>();
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (var n : nums) add(n);
    }
    public int add(int val) {
        heap.offer(val);
        if (heap.size() > k) heap.poll();
        return heap.peek();
    }
    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4, 5, 8, 2};
        System.out.println("K is "+k);
        KthLargest kthLargest = new KthLargest(k, nums);
        System.out.print("Given initial Array : ");
        for(int i:nums){
            System.out.print(i+" ");
        }
        System.out.println();
        int[] stream={3,5,10,9,4};
        for(int e:stream){
            System.out.println("After adding :"+e+" . Kth largest is : "+kthLargest.add(e));
        }
    }
}

