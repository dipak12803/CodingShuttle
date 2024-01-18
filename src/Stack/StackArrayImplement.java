package Stack;

public class StackArrayImplement {
    int size;
    int a[];
    int top;
    public StackArrayImplement(int size){
        this.size=size;
        a=new int[size];
        top=-1;
    }
    boolean push(int data){
        if(isFull()){
            System.out.println("Stack Overflow");
            return false;
        }
        else{
            top++;
            a[top]=data;
            return true;
        }

    }
    int pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty ");
            return -1;
        }
        else{
            int temp=a[top];
            top--;
            return temp;

        }
    }
    int peek(){
        if(isEmpty()){
            System.out.println("Stack is Empty ");
            return -1;
        }
        else{
            return a[top];

        }
    }
    boolean isEmpty(){
        return top==-1;

    }
    boolean isFull(){
        return top==size-1;
    }
    void printStack(){
        for(int i=0;i<=top;i++){
            System.out.println(a[i]+" ");
        }
        System.out.println();
    }

}
