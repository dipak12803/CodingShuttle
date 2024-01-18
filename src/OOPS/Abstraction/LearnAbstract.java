package OOPS.Abstraction;

public class LearnAbstract {
    public static void main(String[] args) {
        Car c1=new Car();
        c1.accelerate();
        c1.brakes(4);
    }
}
abstract class Vehicle{
    abstract void accelerate();
    abstract int brakes(int wheels);

}
class Car extends Vehicle{

    @Override
    void accelerate() {
        System.out.println("Car is accelerating");
    }

    @Override
    int brakes(int wheel) {
        return wheel;
    }
}
