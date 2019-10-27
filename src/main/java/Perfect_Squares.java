/**
 * LeetCode-279
 */
public class Perfect_Squares {
    public int numSquares(int n) {
        //dp[i] = min(dp[i],dp[i-k]+1)
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= n; j++) {
                if (j * j > i) {
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        for (int i : dp) {
            System.out.print(i + " ");
        }
        return dp[n];
    }
}
