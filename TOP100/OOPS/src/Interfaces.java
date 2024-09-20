interface Animals{
    int eyes=2;
//    All methods are public by default
     void walk();
//    Interface methods can not have body
}
interface Herbivore{

}
class Elephant implements Animals,Herbivore{
   public  void walk(){
       System.out.println("walks on 4 legs");
    }
}
public class Interfaces {
    public static void main(String[] args) {

    }
}
