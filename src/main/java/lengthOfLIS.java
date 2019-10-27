/**
 * LeetCode-300
 */
public class lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }

        for (int i : dp) {
            System.out.print(i + " ");
        }
        System.out.println();
        return max;
    }
}
