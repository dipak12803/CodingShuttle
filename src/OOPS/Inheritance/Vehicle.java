package OOPS.Inheritance;

import org.w3c.dom.ls.LSOutput;

public class Vehicle {
    final int gears=4;
    public static void main(String[] args) {
        Vehicle v1=new Vehicle(2);
//        v1.gears=6; final keyword is used
    }
    int wheelsCount;

    String model;
    Vehicle(){
        System.out.println("Creating a vehicle instance");
    }
    Vehicle(int wheelsCount){
        this.wheelsCount=wheelsCount;
        System.out.println("Creating vehicles with wheels");
    }

    void start(){
        System.out.println("Vehicle is starting");
    }
    final void accelerate(){
        System.out.println("Vehicle is accelerating");
    }
}
