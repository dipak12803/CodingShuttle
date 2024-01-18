package OOPS;

public class Constructor {
    public static void main(String[] args) {
//        Complexx num1=new Complexx(); //default constructor
        Complexx num1=new Complexx(4,8); //parameterised constructor
        Complexx num2=new Complexx(5,6);
        Complexx num3=new Complexx(1);

        num1.print();
        num2.print();
        System.out.println("Adding two number ");
        Complexx result=num1.add(num2);
        result.print();
    }
}
class Complexx{
    int a,b;
//    public Complexx(){
////        by default a and b are 0
//        a=5;
//        b=9;
//    }
//    public Complexx(int real,int imaginary){
//        a=real;
//        b=imaginary;
//    }
    public Complexx(int a,int b){
//        this.a points to the line number 18 ,current object
        this.a=a;
        this.b=b;
    }
//    Constructor overloading
    public Complexx(int real){
        a=real;
        b=12;
    }
    Complexx add(Complexx num2){
        System.out.println(this);//prints reference of current object
//        which is currently num1 -> num1.add(num2);
        this.print(); //prints the current object which is num1
        return new Complexx(a+num2.a,b+num2.b);
    }
    void print(){
        System.out.println(a+" + "+b+"i");
    }
}
