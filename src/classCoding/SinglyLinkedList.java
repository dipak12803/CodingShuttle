package classCoding;

public class SinglyLinkedList {
    private Node head;

    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Inserts a new node at the beginning of the linked list.
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Inserts a new node at the end of the linked list.
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    // Deletes the first node of the linked list.
    public void deleteFirst() {
        if (head == null) {
            return;
        }

        head = head.next;
    }

    // Deletes the last node of the linked list.
    public void deleteLast() {
        if (head == null) {
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        current.next = null;
    }

    // Deletes the node with the given data from the linked list.
    public void deleteNode(int data) {
        if (head == null) {
            return;
        }

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        Node previous = null;
        while (current != null && current.data != data) {
            previous = current;
            current = current.next;
        }

        if (current != null) {
            previous.next = current.next;
        }
    }

    // Searches for the node with the given data in the linked list.
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

    // Prints the contents of the linked list.
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();

        linkedList.insertAtBeginning(10);
        linkedList.insertAtBeginning(20);
        linkedList.insertAtEnd(30);
        linkedList.insertAtEnd(40);

        linkedList.print(); // 20 10 30 40

        linkedList.deleteFirst();
        linkedList.deleteLast();

        linkedList.print(); // 10 30

        boolean found = linkedList.search(30);
        System.out.println("30 is found: " + found); // true

        linkedList.deleteNode(10);

        linkedList.print(); // 30
    }
}

