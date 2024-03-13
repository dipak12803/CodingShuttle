import java.util.Arrays;

public class APLABMSTT {
    public static String rearrangeString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        StringBuilder rearranged = new StringBuilder();

        for (int i = 0; i < s.length() / 2; i++) {
            rearranged.append(chars[i]);
            rearranged.append(chars[i + s.length() / 2]);
        }

        if (s.length() % 2 != 0) {
            rearranged.append(chars[s.length() - 1]);
        }

        return rearranged.toString();
    }

    public static void main(String[] args) {
        String s = "hello";
        String rearranged = rearrangeString(s);
        System.out.println("Rearranged string with adjacent characters being the same: " + rearranged);
}
}
