package JAVA_Sem6;

import java.util.Scanner;

public class Assignment_1 {
  /*  public static void main(String[] args) {
        char char1 = 'x';
        char char2 = 'o';

        // Display the characters in alphabetical order
        if (char1 < char2) {
            System.out.println(char1 + ", " + char2);
        } else {
            System.out.println(char2 + ", " + char1);
        }

    }

   */

    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to reverse: ");
        int number = scanner.nextInt();
        int reversedNumber = reverseNumber(number);
        System.out.println("Reversed number: " + reversedNumber);
        scanner.close();
    }
    // Function to reverse the given number
    public static int reverseNumber(int number) {
        int reversedNumber = 0;
        while (number != 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number /= 10;
        }
        return reversedNumber;
    }

     */

    public static int sumIgnoringRange(int[] arr) {
        int sum = 0;
        boolean skipElements = false;
        for (int num : arr) {
            if (num == 6) {
                skipElements = true;
            } else if (num == 7) {
                skipElements = false;
            } else if (!skipElements) {
                sum += num;
            }
        }

        return sum;
    }
    public static int noSuccession(int[] arr){
        int sum=0;
        for(int i:arr){
            sum+=i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n = in.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter array elements : ");
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int num1 = 6;
        int num2 = 7;
        int foundNum1 = Integer.MIN_VALUE;
        int foundNum2 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] == num1) {
                foundNum1 = i;
                break;
            } if (arr[i] == num2) {
                foundNum2 = i;
                break;
            }
        }
        int ans;
        if (foundNum1 > foundNum2) {
            ans = sumIgnoringRange(arr);

        } else {
            ans = noSuccession(arr);
        }
        System.out.println(ans);
//        int[] arr1 = {10, 3, 6, 1, 2, 7, 9};
//        int[] arr2 = {7, 1, 2, 3, 6};
//        int[] arr3 = {1, 6, 4, 7, 9};
//
//
//        System.out.println("Sum for arr1: " + sumIgnoringRange(arr1));  // Output: 22
//        System.out.println("Sum for arr2: " + noSuccession(arr2));  // Output: 19
//        System.out.println("Sum for arr3: " + sumIgnoringRange(arr3));  // Output: 10
    }

}
