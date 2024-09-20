import bank.Account;

class Pen{
    String color;
    String type;  //ballpen,gel pen
    public void write(){
        System.out.println("Writing something");
    }
    public void printColor(){
        System.out.println(this.color);
    }
}
class Student{
    String name;
    int age;
    public void printInfo(){
        System.out.println(this.name);
        System.out.println(this.age);
    }
    //constructors
    //non parametrized
    Student(){
        System.out.println("Constructor called");
    }
    //parameterized constructor

    Student(String name,int age){
        this.name=name;
        this.age=age;
    }
    //Copy constructor
    Student(Student s2){
        this.name=s2.name;
        this.age=s2.age;
    }



}
public class OOP {
    public static void main(String[] args) {
        Student s1=new Student();
        s1.name="Dipak";
        s1.age=21;
        s1.printInfo();

        Student s2=new Student("Dipak Rajbhar",21);
        s2.printInfo();

        Student s3=new Student(s2);
        s3.printInfo();





//        Pen pen1=new Pen();
//        pen1.color="Blue";
//        pen1.type="Gel";
//        pen1.write();
//
//
//        Pen pen2=new Pen();
//        pen2.color="Black";
//        pen2.type="Ball point";
//
//        pen1.printColor();
//        pen2.printColor();


    }
}
