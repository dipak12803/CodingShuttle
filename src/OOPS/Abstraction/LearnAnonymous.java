package OOPS.Abstraction;

public class LearnAnonymous {

    //anonymous
    OuterClass obj=new OuterClass(){
        void sing(){

        }
      public void outerMethod(){

      }
    };
    SuperInterface obj2=new SuperInterface() {
        @Override
        public void interfaceMethod() {

        }
    };
    SuperInterface obj3=()->{

    };


    public static void main(String[] args) {
        Walkable w=(int steps)->{
            System.out.println("walked steps"+steps);
            return steps;
        };
        w.walks(6);

        Walkable obj=(int steps)->(2*steps);
        System.out.println(obj.walks(4));
    }

}


interface Walkable{
    int walks(int steps);
}
class OuterClass{
    public void outerMethod(){

    }
}
@FunctionalInterface
interface SuperInterface{
    void interfaceMethod();
}