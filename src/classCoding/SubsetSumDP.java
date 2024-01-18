package classCoding;

public class SubsetSumDP {

    public static boolean subsetSum(int[] set, int sum) {
        // Create a 2D array to store the results of the subproblems.
        boolean[][] dp = new boolean[set.length + 1][sum + 1];

        // Initialize the base cases.
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = false; // There is no subset of an empty array that can sum to any value.
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true; // The empty subset sums to 0.
        }

        // Fill in the rest of the table.
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                // If the current element is greater than the current sum, then we can't include it in the subset.
                if (set[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j]; // So we just copy the result from the previous row.
                } else {
                    // Otherwise, we can either include the current element in the subset or not.
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - set[i - 1]]; // So we take the maximum of the two cases.
                }
            }
        }

        // Return the result.
        return dp[set.length][sum]; // The result of the algorithm is simply the value of dp[n][sum].
    }

    public static void main(String[] args) {
        int[] set = {3, 34, 4, 12, 5, 2};
        int sum = 9;

        boolean result = subsetSum(set, sum);
        System.out.print("Given array : ");
        for(int it:set){
            System.out.print(it+" ");
        }
        System.out.println();
        if (result) {
            System.out.println("There is a subset with sum " + sum);
        } else {
            System.out.println("There is no subset with sum " + sum);
        }
    }
}