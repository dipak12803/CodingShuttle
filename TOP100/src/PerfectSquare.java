import java.util.Scanner;

public class PerfectSquare {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int num=in.nextInt();
        int numsquareroot=(int)Math.sqrt(num);
        if(numsquareroot*numsquareroot==num){
            System.out.println("Perfect Square");
        }
        else{
            System.out.println("Not a perfect square");
        }
    }
    /*
    static void checkperfectsquare(int n)
{

	if (Math.ceil((double)Math.sqrt(n)) == Math.floor((double)Math.sqrt(n)))
	{
		System.out.print("True");
	}
	else
	{
		System.out.print("False");
	}
}
     */
}
