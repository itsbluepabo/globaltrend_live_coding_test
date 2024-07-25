import java.util.*;

public class Knap {
    public static int knapsack(int[] wts, int[] vals, int cap) {
        int n = wts.length;
        int[][] dp = new int[n + 1][cap + 1];

        // Build the dp array
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= cap; w++) {
                if (wts[i - 1] <= w) {
                    dp[i][w] = Math.max(vals[i - 1] + dp[i - 1][w - wts[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][cap];
    }

    public static void main(String[] args) {
        int[] wts = {1, 2, 3};
        int[] vals = {10, 15, 40};
        int cap = 6;
        int maxVal = knapsack(wts, vals, cap);
        System.out.println("Max value obtained: " + maxVal);
    }
}
