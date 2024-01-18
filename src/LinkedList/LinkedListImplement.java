package LinkedList;

public class LinkedListImplement {
    public static void main(String[] args) {
//        Node<Integer> head=new Node<>(1); for generic
//        Node<Integer> n1=new Node<>(1);

        Node head=new Node(1);
        Node n1=new Node(2);
        Node n2=new Node(3);
        Node n3=new Node(1);
        Node n4=new Node(1);
        head.next=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
//        for palindrome check
        System.out.println(isLLPalindrome(head));





//        printLinkedList(head);
//        Node newHead=reverseLLRecursion(head);
//        printLinkedList(newHead);


//        head.next=n1;
//        n1.prev=head;
//        n1.next=n2;
//        n2.prev=n1;
//        n2.next=n4;
//        n4.next=n5;
//        n4.prev=n2;
//        printLinkedList(head);
//        insertinLL(2,4,head);
//        printLinkedList(head);

//        head=insertinLL(0,7,head);
//        printLinkedList(head);

//        head=deleteFromLL(2,head);
//        printLinkedList(head);
//        Node middle=findMiddle(head);
//        System.out.println(middle.val);
//        Node newHead=removeDuplicateElements(head);
//        printLinkedList(newHead);



    }
    static boolean isLLPalindrome(Node head){
        Node middle=findMiddle(head);
        Node t2=reverseLLRecursion(middle);
        Node t1=head;
        while(t2!=null){
            if(t1.val!=t2.val){
                return false;
            }
            t1=t1.next;
            t2=t2.next;

        }
        return true;
    }
    static Node reverseLLRecursion(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node headOfSubproblem=reverseLLRecursion(head.next);  //it makes the last node head and reverses the linkedlist after original head
        head.next.next=head;  // it makes the 2nd node pointing to head which reverse the pointer
        head.next=null;  //as head becomes the tail so its next should be null
        return headOfSubproblem;
    }
//    static Node<Integer> removeDuplicateElements(Node head){
//        Node original=head;
//        Node newHead=null;
//        Node temp=head;
//        while(original!=null){
//            while(original.next!=null && original.val==original.next.val){
//                original=original.next;
//            } //when this while loop breaks original pointer will be at last repeating position means its next
//            //node is different
//            if(newHead==null){
//                newHead=temp=original;
//            }
//            else{
//                temp.next=original;
//                temp=original;  //
//            }
//            original=original.next;
//        }
//        return newHead;
//    }
    public static void printLinkedList(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.val+"-> ");
            temp=temp.next;
        }
        System.out.println();
    }
//    public static Node<Integer> insertinLL(int pos,int data,Node<Integer> head){
//        Node<Integer> temp=head;
//        Node<Integer> newNode=new Node<>(data);
//        if(pos==0){
//            newNode.next=head;
////            head.prev=newNode;
//            return newNode;
//        }
//        for(int i=0;i<pos-1;i++){
//            temp=temp.next;
//
//        }
//
//        newNode.next=temp.next;
////        temp.next.prev=newNode;
//        temp.next=newNode;
////        newNode.prev=temp;
//        return newNode;
//    }
//    public static Node<Integer> deleteFromLL(int pos,Node<Integer> head){
//        Node<Integer> temp=head;
//        if(pos==0){
//            return head.next;
//        }
//        for(int i=0;i<pos-1;i++){
//            temp=temp.next;
//
//        }
//        temp.next=temp.next.next;
//        return head;
//    }
    static Node findMiddle(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

        }
        return slow;
    }
    static Node reverseLL(Node head){
        if(head==null || head.next==null) return head;
        Node prev=head;
        Node curr=head.next;
        head.next=null;
        while(curr!=null){
             Node next=curr.next;
             curr.next=prev;
             prev=curr;
             curr=next;


        }
        return prev;

    }
}
class Node{
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}

//Generic class
//class Node<E>{
//    E val;
//    Node<E> next;
////    Node<E> prev;
//
//    public Node(E val) {
//        this.val = val;
//        this.next = null;
////        this.prev=null;
//    }
//}
