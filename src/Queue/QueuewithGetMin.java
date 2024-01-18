package Queue;
import java.util.*;
public class QueuewithGetMin {
    public static void main(String[] args) {
        QueuewithGetMin q=new QueuewithGetMin();
        q.enqueue(10);
        q.enqueue(20);
        System.out.println(q.getMin());
        q.dequeue();
        q.enqueue(15);
        System.out.println(q.getMin());
    }
    Queue<Integer> q=new LinkedList<>();
    ArrayDeque<Integer> dq=new ArrayDeque<>();
    public void enqueue(int data){
        q.offer(data);
        while(!dq.isEmpty() && dq.getLast()>data){
            dq.pollLast();
        }
        dq.offerLast(data);
    }
    public int dequeue(){
        if(q.isEmpty()) return -1;

        int temp=q.poll();
        if(temp==dq.getFirst()){
            dq.pollFirst();
        }
        return temp;


    }
    public int getMin(){
        return dq.getFirst();
    }
}
