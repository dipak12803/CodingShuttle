package OOPS.Inheritance;

public class Car extends Vehicle {

    String color;
    void start(){
        Scooter scooterobj=new Scooter();
        scooterobj.breaking(this);
        super.start(); //points to the parent class
        System.out.println(this);
        System.out.println(this.model+"Car is starting");
    }


    Car(){
        super(4); //parent constructor which is parameterised is called
        System.out.println("Car is being created");
    }


    public static void main(String[] args) {
        Car obj=new Car();
        System.out.println(obj.wheelsCount);
        obj.wheelsCount=8;
        obj.model="BMW";
        obj.color="red";
        obj.start();
        obj.accelerate();
        System.out.println(obj.wheelsCount);
    }
}

class Scooter{
    void breaking(Car car){
        System.out.println(car.model+"is braking");
    }
}
