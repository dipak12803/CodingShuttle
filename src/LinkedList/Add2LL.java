package LinkedList;

public class Add2LL {
    public static void main(String[] args) {
        Node l1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
//        Node n5 = new Node(5);
        l1.next = n2; n2.next = n3; n3.next = n4; 
//
//        Node l1=new Node(6);
//        Node n2=new Node(4);
//        Node n3=new Node(2);
//        Node n4=new Node(7);
//        Node n5=new Node(2);
//        l1.next=n2; n2.next=n3; n3.next=n4; n4.next=n5;
        printLinkedList(l1);
        Node reorder=reOrderLL(l1);
        printLinkedList(reorder);
//
//        Node l2=new Node(2);
//        Node d2=new Node(5);
//        l2.next=d2;
//        printLinkedList(l1);
//        printLinkedList(l2);
//
//        Node sum=addTwoLL(l1,l2);
//        printLinkedList(sum);
    }
    static Node reverseLinkedList(Node head) {
        if(head == null || head.next == null) return head;
        Node prev = head;
        Node cur = head.next;
        head.next = null;

        while(cur != null) {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
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
    static Node reOrderLL(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node l2 = reverseLLRecursion(slow);
        Node l1 = head;

        while (true) {
            if(l1 == l2) {
                l1.next = null;
                break;
            }
            if(l2.next == null){   //even case checking
                l1.next = l2;
                l2.next = null;
                break;
            }
            Node l1Next = l1.next;
            Node l2Next = l2.next;
            l1.next = l2;
            l2.next = l1Next;

            l1 = l1Next;
            l2 = l2Next;
        }
        return head;
    }
//    static Node addTwoLL(Node l1,Node l2){
//        Node r1=reverseLLRecursion(l1);
//        Node r2=reverseLLRecursion(l2);
//        int carry=0;
//        Node ans=null;
//        Node temp=null;
//        while(r1!=null || r2!=null || carry!=0){
//            int sum=carry;
//            if(r1!=null){
//                sum+=r1.val;
//                r1=r1.next;
//
//            }
//            if(r2!=null){
//                sum+=r2.val;
//                r2=r2.next;
//            }
//            int digit=sum%10;
//            carry=sum/10;
//            Node newNode=new Node(digit);
//            if(ans==null){
//                ans=temp=newNode;
//            }else{
//                temp.next=newNode;
//                temp=newNode;
//
//            }
//        }
//        return reverseLLRecursion(ans);
//    }

    public static void printLinkedList(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.val+"-> ");
            temp=temp.next;
        }
        System.out.println();
    }
}


