package PriorityQueue_Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class LearnPriorityQueue {

    public static void main(String[] args) {
//        Min Heap
//        PriorityQueue<Integer> pq=new PriorityQueue<>();

//        Max Heap
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        pq.add(12);
        pq.add(9);
        pq.add(2);
        pq.add(17);
        pq.add(15);

        System.out.println(pq);
    }

}
