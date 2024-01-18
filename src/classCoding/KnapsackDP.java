package classCoding;

public class KnapsackDP {

    public static int knapsack(int[] weights, int[] values, int capacity) {
        // Create a table to store the results of the subproblems.
        int[][] dp = new int[weights.length + 1][capacity + 1];

        // Initialize the base cases.
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0; // There is no value in an empty knapsack.
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0; // A knapsack with capacity 0 can hold no items.
        }

        // Fill in the rest of the table.
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (weights[i - 1] > j) {
                    // The current item is too heavy for the knapsack, so we cannot include it.
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // We can either include the current item in the knapsack or not.
                    dp[i][j] = Math.max(dp[i - 1][j], values[i - 1] + dp[i - 1][j - weights[i - 1]]);
                }
            }
        }

        // Return the result.
        return dp[weights.length][capacity]; // The maximum value that can be put in the knapsack is stored in the bottom right corner of the table.
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5};
        int[] values = {6, 10, 12, 15, 20};
        int capacity = 10;

        int max_value = knapsack(weights, values, capacity);
        System.out.print("Weights : ");
        for(int it:weights){
            System.out.print(it+" | ");
        }
        System.out.println();
        System.out.print("Values : ");
        for(int its:values){
            System.out.print(its+" | ");
        }
        System.out.println();
        System.out.println("Knapsack Capacity is : "+capacity);
        System.out.println("The maximum value that can be put in the knapsack is: " + max_value);
    }
}
