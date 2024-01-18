package classCoding;
import java.util.*;
public class KMP {

    public static int[] computeLpsArray(String pattern) {
        int[] lpsArray = new int[pattern.length()];

        int j = 0;
        int i = 1;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                lpsArray[i] = j + 1;
                i++;
                j++;
            } else {
                if (j > 0) {
                    j = lpsArray[j - 1];
                } else {
                    lpsArray[i] = 0;
                    i++;
                }
            }
        }

        return lpsArray;
    }

    public static List<Integer> findAllOccurrences(String string, String pattern) {
        List<Integer> occurrences = new ArrayList<>();

        int[] lpsArray = computeLpsArray(pattern);
        int i = 0;
        int j = 0;

        while (i < string.length()) {
            if (string.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (j > 0) {
                    j = lpsArray[j - 1];
                } else {
                    i++;
                }
            }

            if (j == pattern.length()) {
                occurrences.add(i - pattern.length());
                j = lpsArray[j - 1];
            }
        }

        return occurrences;
    }

    public static void main(String[] args) {
        String string = "heyhihey";
        String pattern = "hey";

        List<Integer> occurrences = findAllOccurrences(string, pattern);

        for (int occurrence : occurrences) {
            System.out.println(occurrence);
        }
    }
}