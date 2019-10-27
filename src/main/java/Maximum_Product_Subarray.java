/**
 * LeetCode-152
 */
public class Maximum_Product_Subarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp_max = new int[nums.length];
        dp_max[0] = nums[0];

        int[] dp_min = new int[nums.length];
        dp_min[0] = nums[0];

        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp_min[i] = Math.min(nums[i], Math.min(nums[i] * dp_max[i - 1], nums[i] * dp_min[i - 1]));
            dp_max[i] = Math.max(nums[i], Math.max(nums[i] * dp_max[i - 1], nums[i] * dp_min[i - 1]));
            max = Math.max(max, dp_max[i]);
        }
        return max;
    }
}
