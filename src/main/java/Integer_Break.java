/**
 * Integer Break
 * leetcode-343
 *
 * hard for me
 * */
public class Integer_Break {
    public int integerBreak(int n) {
        //找规律：https://www.cnblogs.com/grandyang/p/5411919.html

        if (n <= 0) {
            return 0;
        }

        int[] dp = new int[n >= 7 ? n + 1 : 7];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 4;
        dp[5] = 6;
        dp[6] = 9;

        for (int i = 7; i <= n; i++) {
            dp[i] = 3 * dp[i - 3];
        }

        return dp[n];
    }
}
