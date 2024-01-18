package Stack;

public class MainStack {
    public static void main(String[] args) {
//        StackArrayImplement stack=new StackArrayImplement(4);
        StackLinkedListImplement stack=new StackLinkedListImplement();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
//        stack.printStack();
        stack.push(5);
        System.out.println(stack.peek()+" Peek value");
        while(!stack.isEmpty()){
            System.out.println(stack.pop()+" ");
        }
//        stack.printStack();


    }
}
