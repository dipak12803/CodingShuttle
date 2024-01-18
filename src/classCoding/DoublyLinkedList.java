package classCoding;

public class DoublyLinkedList {
    private class Node {
        int data;
        Node prev;
        Node next;
        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    private Node head;
    private Node tail;
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }
    // Method to insert a node at the beginning of the doubly linked list
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }
    // Method to insert a node at the end of the doubly linked list
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }
    // Method to delete a node from the beginning of the doubly linked list
    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }
    // Method to delete a node from the end of the doubly linked list
    public void deleteAtEnd() {
        if (tail == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }
    // Method to display the elements of the doubly linked list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAtBeginning(1);
        dll.insertAtBeginning(2);
        dll.insertAtBeginning(5);
        dll.insertAtBeginning(7);
        dll.insertAtEnd(3);
        dll.insertAtEnd(4);
        dll.insertAtEnd(8);
        dll.insertAtEnd(12);
        System.out.print("Doubly Linked List: ");
        dll.display();
        System.out.println("After deletion at beginning: ");
        dll.deleteAtBeginning();
        dll.display();
        System.out.println("After deletion at end : ");
        dll.deleteAtEnd();
        dll.display();
    }
}
