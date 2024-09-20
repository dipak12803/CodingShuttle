import java.util.*;
public class GreatestOf3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n1=in.nextInt();
        int n2=in.nextInt();
        int n3=in.nextInt();
        int maxfrom12=n1>n2?n1:n2;
        int result=maxfrom12>n3?maxfrom12:n3;
        System.out.println(result);
    }
}
