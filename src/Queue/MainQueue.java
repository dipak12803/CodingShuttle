package Queue;

public class MainQueue {
    public static void main(String[] args) {
//        MyQueue q=new MyQueue(4);
//        MyCircularQueue q=new MyCircularQueue(4);
//        q.enqueue(10);
//        q.enqueue(20);
//        q.enqueue(30);
//        q.enqueue(40);
//        q.enqueue(50);
//        q.printQueue();
//        System.out.println(q.dequeue());
//        q.printQueue();


//        QueueUsingTwoStack q2=new QueueUsingTwoStack();
//        QueueUsingOneStack q2=new QueueUsingOneStack();
//
//
//        q2.enqueue(10);
//        q2.enqueue(20);
//        q2.enqueue(30);
//        q2.enqueue(40);
//        q2.enqueue(80);
//        System.out.println(q2.dequeue());
//        System.out.println(q2.dequeue());
//        System.out.println(q2.dequeue());


        StackUsingOneQueue stack=new StackUsingOneQueue();
        stack.push(10);
        stack.push(20);
        System.out.println(stack.pop());
    }
}
