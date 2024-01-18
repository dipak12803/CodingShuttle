package OOPS.Encapsulation;

import OOPS.Package.Person;

public class MaininEncapsulation {
    public static void main(String[] args) {
        Person p=new Person();
        p.setAge(12);
        System.out.println(p.getAge());
    }
}
