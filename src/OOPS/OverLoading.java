package OOPS;

public class OverLoading {
    public static void main(String[] args) {
        Greet obj=new Greet();
        obj.greetings();
        obj.greetings("Dipak");
        obj.greetings("Dipak",20);
    }


}
class Greet{
    void greetings(){
        System.out.println("Hello Good Morning");
    }
    void greetings(String name){
        System.out.println("Hello"+name+"Good Morning");
    }
    void greetings(String name,int age){
        System.out.println("Hi "+name+" your age is "+age);
    }
}
