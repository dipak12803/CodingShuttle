import bank.*;
class Shape{
    String color;
    public void area(){
        System.out.println("Display Area");
    }

}
class Triangle extends Shape{
    public void area(int l,int h){
        System.out.println((l*h)/2);
    }

}
class EquilateralTriangle extends Triangle{
    public void area(int l,int h){
        System.out.println((l*h)/2);
    }
}
class Circle extends Shape{
    public void area(int r){
        System.out.println(Math.PI*r*r);
    }
}
public class Inheritance {
    public static void main(String[] args) {
        Triangle t1=new Triangle();
        t1.color="red";

        bank.Account account1=new bank.Account();
        account1.name="Customer 1";

    }
}
