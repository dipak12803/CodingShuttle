package BitManipulation;

public class Main {
    public static void main(String[] args) {
        int n = 9;
        int i = 2;
        System.out.println(getIthBit(n, i));
        /*
        n=9  ( 1 0 0 1)
  mask  1<<2 ( 0 1 0 0)
  do  & op   ( 0 0 0 0)  it is 0  so ans is 0



         */


        System.out.println(setIthBit(n, i));

        System.out.println(clearBitsInGivenRange(3,1,2));


    }

    static int getIthBit(int n, int i) {
        int mask = 1 << i;
//        int result=(n&mask);
//        if(result==0){
//            return 0;
//        }else{
//            return 1;
//        }
        return (n & mask) == 0 ? 0 : 1;

    }

    static int setIthBit(int n, int i) {
        int mask = 1 << i;
        return n | mask;
    }

    static int clearIthBit(int n, int i) {
        int mask = ~(1 << i);
        return n & mask;
    }

    static int clearBitsInGivenRange(int n, int i, int j) {
        int a = (~0 << (j + 1));
        int b = (1 << i) - 1;
        int mask = a | b;
        return n & mask;
    }
}
