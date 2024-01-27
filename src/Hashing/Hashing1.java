package Hashing;
import java.util.*;
public class Hashing1 {
    public static void main(String[] args) {
        String s="S";
        System.out.println(s.hashCode());

        Boolean a=true;
        System.out.println(a.hashCode());

        Boy b1=new Boy(25,"Dipak");
        System.out.println(b1.hashCode());

        Map<Integer,String> map=new HashMap<>();
    }
    static class Boy{
        int age;
        String name;
        public Boy(int age,String name){
            this.age=age;
            this.name=name;
        }
    }
}
