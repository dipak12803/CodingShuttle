package OOPS.Abstraction;

public class LearnInterface {
    public static void main(String[] args) {
        Monkey m=new Monkey();
        m.eats();
        m.drinks();
    }
}
interface pet{
    void sing();
    void drinks();
}
interface Animal{
    int legs=4;  //they are by default public static final
    void eats();
    void drinks();

    default void walk(){
        System.out.println("Animal is walking");
    }
}
class Monkey implements Animal,pet{
    public void eats(){
        System.out.println("Monkey is eating");
    }

    @Override
    public void drinks() {
        System.out.println("Monkey is drinking");
    }

    @Override
    public void sing() {

    }
}