package classCoding;

public class CircularLinkedList {
    // Node class to represent individual elements of the circular linked list
    private class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    private Node head;
    public CircularLinkedList() {
        this.head = null;
    }
    // Method to insert a node at the beginning of the circular linked list
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            newNode.next = newNode; // Point to itself to make it circular
            head = newNode;
        } else {
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }
            newNode.next = head;
            head = newNode;
            last.next = newNode;
        }
    }
    // Method to insert a node at the end of the circular linked list
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            newNode.next = newNode; // Point to itself to make it circular
            head = newNode;
        } else {
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }
            newNode.next = head;
            last.next = newNode;
        }
    }
    // Method to delete a node from the beginning of the circular linked list
    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        if (head.next == head) {
            head = null;
        } else {
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }
            head = head.next;
            last.next = head;
        }
    }
    // Method to delete a node from the end of the circular linked list
    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        if (head.next == head) {
            head = null;
        } else {
            Node last = head;
            Node secondLast = null;
            while (last.next != head) {
                secondLast = last;
                last = last.next;
            }
            secondLast.next = head;
        }
    }
    public boolean search(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }

            current = current.next;
        }

        return false;
    }
    // Method to display the elements of the circular linked list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.insertAtBeginning(1);
        cll.insertAtBeginning(2);
        cll.insertAtBeginning(5);
        cll.insertAtEnd(3);
        cll.insertAtEnd(4);
        cll.insertAtEnd(7);
        cll.insertAtEnd(16);
        System.out.print("Circular Linked List: ");
        cll.display();
        System.out.println("After deletion at beginning: ");
        cll.deleteAtBeginning();
        cll.display();
        System.out.println("After deletion at end : ");
        cll.deleteAtEnd();
        cll.display();
    }
}

