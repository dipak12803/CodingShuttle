package OOPS.Abstraction;

public class LearnInnerClass {
    class Toy{
        int price;
    }
    static class PlayStation{
        int price;
    }
    public static void main(String[] args){
        LearnInnerClass obj=new LearnInnerClass();
        Toy t=obj.new Toy();
        t.price=45;
        PlayStation p=new LearnInnerClass.PlayStation();
    }
}
