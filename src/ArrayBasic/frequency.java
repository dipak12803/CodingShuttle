package ArrayBasic;
import java.util.*;

public class frequency {
    public static void main(String[] args) {
        int[] array = { 4, 2, 8, 2, 4, 3, 8, 8, 2, 9 };

        Arrays.sort(array);

        int n = array.length;
        int currentElement = array[0];
        int frequency = 1;

        for (int i = 1; i < n; i++) {
            if (array[i] == currentElement) {
                frequency++;
            } else {
                System.out.println(currentElement + " occurs " + frequency + " times.");
                currentElement = array[i];
                frequency = 1;
            }
        }

        // Print the last element's frequency
        System.out.println(currentElement + " occurs " + frequency + " times.");
    }
}
