import java.util.*;
public class NumPositiveOrNegative {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int num=in.nextInt();
        if(num==0){
            System.out.println("Zero");
        }
        else{
        String ans=(num>0)?"Positive":"Negative";
        System.out.println(ans);
        }
    }
}
