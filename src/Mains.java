import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mains {
    public static long findMaximumProfit(List<Integer> category, List<Integer> price) {
        int n = category.size();
        Map<Integer, Integer> categoryCount = new HashMap<>();
        long totalProfit = 0;

        for (int i = 0; i < n; i++) {
            int cat = category.get(i);
            int p = price.get(i);
            int count = categoryCount.getOrDefault(cat, 0);

            totalProfit += p * (count + 1);
            categoryCount.put(cat, count + 1);
        }

        return totalProfit;
    }

    public static void main(String[] args) {
        // Sample Input
        List<Integer> category = List.of(2, 1, 2);
        List<Integer> price = List.of(3, 2, 4);

        System.out.println(findMaximumProfit(category, price)); // Output: 16
    }
}
