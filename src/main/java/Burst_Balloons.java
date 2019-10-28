/**
 * LeetCode-312
 * hard for me
 */
public class Burst_Balloons {
    //dp[i][j] 表示打爆区间 [i,j] 中的所有气球能得到的最多金币
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        //数组的前后各填充一个1
        int[] temp = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++)
            temp[i + 1] = nums[i];
        temp[0] = 1;
        temp[nums.length + 1] = 1;
        int n = temp.length;
        int[][] dp = new int[n][n];
        //dp[i][j] = Max(dp[i][j],dp[i][k-1]+num[i-1]*num[k]*num[j+1]+dp[k+1][j])
        for (int len = 1; len < n - 1; len++) {
            for (int i = 1; i < n - len; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++)
                    dp[i][j] = Math.max(dp[i][j], dp[i][k - 1] + temp[i - 1] * temp[k] * temp[j + 1] + dp[k + 1][j]);
            }
        }
        return dp[1][n - 2];
    }
}
