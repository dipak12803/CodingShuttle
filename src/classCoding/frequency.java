package classCoding;
import java.util.*;
public class frequency {
    public static void main(String[] args) {
        int[] arr = {2,5,8,3,5,4,8,5,2,2,6,3,5,8,4,5};
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (int element : arr) {
            if (frequencyMap.containsKey(element)) {
                frequencyMap.put(element, frequencyMap.get(element) + 1);
            } else {
                frequencyMap.put(element, 1);
            }
        }

        System.out.println("The frequency of each element is:");
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }

    }
}
