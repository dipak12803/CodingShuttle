import java.util.Scanner;

public class Stacks {

    private int[] stack;
    private int top;

    public Stacks(int size) {
        stack = new int[size];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == stack.length - 1;
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return stack[top];
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack is full");
            return;
        }
        top++;
        stack[top] = data;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        int data = stack[top];
        top--;
        return data;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the stack: ");
        int size = scanner.nextInt();

        Stacks stack = new Stacks(size);

        while (true) {
            System.out.println();
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Is empty");
            System.out.println("5. Is full");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the data to push: ");
                    int data = scanner.nextInt();
                    stack.push(data);
                    break;
                case 2:
                    int poppedData = stack.pop();
                    if (poppedData != -1) {
                        System.out.println("Popped data: " + poppedData);

                    }
                    break;

                case 3:
                    int peekedData = stack.peek();
                    if (peekedData != -1) {
                        System.out.println("Top element: " + peekedData);
                    }
                    break;
                case 4:
                    System.out.println("Is stack empty? " + stack.isEmpty());
                    break;
                case 5:
                    System.out.println("Is stack full? " + stack.isFull());
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
}