import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        System.out.println(fact(n));

    }
    static int fact(int num){
        if(num==0) return 1;
        return num*fact(num-1);
    }
}
