/**
 * LeetCode-494
 * hard for me
 */
public class Target_Sum {
    public int findTargetSumWays(int[] nums, int S) {
        // dp(i,j) 表示添加了前 i个数字的符号，得到总和为 j的方案数
        // dp(i,j + nums[i])=dp(i−1,j+nums[i])+dp(i−1,j−nums[i]).j 的范围是 [−sum,sum]，sum为数组元素的总和
        // 初始值 f(0,0)=0，最终答案为 f(n,S)。
        // 为了方便，第一维的下标从 1 开始；第二维也需要给 sum 的偏移量防止负下标。
        int sum = 0;
        for (int i : nums)
            sum += i;
        if (S > sum || S < -sum) return 0;
        int[][] dp = new int[nums.length][2 * sum + 1];
        dp[0][nums[0] + sum] = 1;
        dp[0][-nums[0] + sum] += 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = -sum; j <= sum; j++) {
                if (dp[i - 1][j + sum] != 0) {
                    dp[i][j + nums[i] + sum] = dp[i][j + nums[i] + sum] + dp[i - 1][j + sum];
                    dp[i][j - nums[i] + sum] = dp[i][j - nums[i] + sum] + dp[i - 1][j + sum];
                }
            }
        }

        return dp[nums.length - 1][S + sum];
    }
}
