import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LABMSTAP {
    public static String rearrangeString(String s) {
        // Count frequency of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Create a priority queue (min-heap) based on character frequency
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) ->
                frequencyMap.get(a).equals(frequencyMap.get(b)) ?
                        Character.compare(a, b) :
                        frequencyMap.get(b) - frequencyMap.get(a));

        // Add characters to priority queue
        pq.addAll(frequencyMap.keySet());

        // Build the result string
        StringBuilder result = new StringBuilder();
        while (!pq.isEmpty()) {
            char current = pq.poll();
            if (result.length() > 0 && result.charAt(result.length() - 1) == current) {
                // If the last character of result is the same as current, find another character
                if (pq.isEmpty()) {
                    // No alternate character found
                    return "";
                }
                char next = pq.poll();
                result.append(next);
                frequencyMap.put(next, frequencyMap.get(next) - 1);
                if (frequencyMap.get(next) > 0) {
                    pq.offer(next);
                }
                pq.offer(current); // Put back the current character into the queue
            } else {
                result.append(current);
                frequencyMap.put(current, frequencyMap.get(current) - 1);
                if (frequencyMap.get(current) > 0) {
                    pq.offer(current);
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "aaaabbbcccdda";
        System.out.println(rearrangeString(s));
    }
}

/*
String s we need to arrange the string in such a way that no two adjacent characters are same


 */
