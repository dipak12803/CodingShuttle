import java.util.Scanner;

public class reverseOfNumber {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int num=in.nextInt();
        int rem,reverse=0;
        while(num>0){
            rem=num%10;
            reverse=reverse*10+rem;
            num/=10;

        }
        System.out.println(reverse);
    }
}
