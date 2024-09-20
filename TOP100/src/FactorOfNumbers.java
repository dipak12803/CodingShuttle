import java.util.Scanner;

public class FactorOfNumbers {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n= in.nextInt();
       findFactorsRecursion(n);
        System.out.println("Prime factors : ");
        findPrimeFactors(n);

    }
    static boolean isPrime(int n){
        if(n<2) return false;
        if(n==2) return true;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        return true;
    }
    public static void findPrimeFactors(int number) {
        System.out.print("Factors of " + number + " are: ");
        for (int i = 1; i <= number; i++) {
            if (number % i == 0 && isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static void findFactorsRecursion(int number) {
        System.out.print("Factors of " + number + " are: ");

        // Loop from 1 to sqrt(number) to find factors
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                System.out.print(i + " "); // First factor
                if (i != number / i) { // To avoid printing the square root twice
                    System.out.print((number / i) + " "); // Second factor
                }
            }
        }
    }
}
