package classCoding;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int max = 50;
        int[] a = new int[max];
        int n;

        long startTime, endTime;

        Random random = new Random();

        System.out.print("Enter the value of n: ");
        n = 10; // You can change the value of n here

        for (int i = 0; i < n; i++) {
            a[i] = random.nextInt(50);
        }

        System.out.println("\nThe array elements before");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + "\t");
        }

        startTime = System.currentTimeMillis();
        quickSort(a, 0, n - 1);
        endTime = System.currentTimeMillis();

        System.out.println("\nElements of the array after sorting are:");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + "\t");
        }

        System.out.println("\nTime taken: " + (endTime - startTime) + " milliseconds");
    }

    public static void quickSort(int a[], int low, int high) {
        int j;

        if (low < high) {
            j = partition(a, low, high);
            quickSort(a, low, j - 1);
            quickSort(a, j + 1, high);
        }
    }

    public static int partition(int a[], int low, int high) {
        int pivot, i, j;
        pivot = a[high];
        i = low - 1;

        for (j = low; j < high; j++) {
            if (a[j] <= pivot) {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        int temp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = temp;
        return i + 1;
    }
}
