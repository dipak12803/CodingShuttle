package OOPS;

public class OOP1 {
    public static void main(String[] args) {
        Dog d1=new Dog();
        d1.name="Tommy";
        d1.bark();
        Dog d2=new Dog();
        d2.name="Leo";
        d2.walk();

        Complex c1=new Complex();
        c1.a=3;
        c1.b=5;
        c1.print();


    }
}

class Complex{
    int a,b;
    void print(){
        System.out.println(a+" + "+b+"i");
    }
}
class Dog{

    //these are properties
    String name;
    int age;
    String color;

//these are features
    void walk(){
        System.out.println(name+" is walking");
    }
    void bark(){
        System.out.println(name+" is barking");
    }
}
