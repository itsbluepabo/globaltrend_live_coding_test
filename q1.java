
//Problem Statement 1
//Write a function to find the longest common subsequence of two given strings.
import java.lang.Math;

public class longseq {
    public static int findlen(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ace";
        int lcsLength = findlen(str1, str2);
        System.out.println("Length = " + lcsLength);
    }
}
