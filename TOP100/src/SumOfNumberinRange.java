import java.util.*;
public class SumOfNumberinRange {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int num1=in.nextInt();
        int num2=in.nextInt();
        int sum=0;
//        easy for loop
        for(int i=num1;i<=num2;i++){
            sum+=i;

        }

//        System.out.println(sumRange(num1,num2));
        System.out.println(sum);
    }
    public static int sumRange(int start,int end){
        if(start==end) return start;
        return start+sumRange(start+1,end);
    }
}
