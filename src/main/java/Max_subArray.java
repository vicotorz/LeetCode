/**
 * LeetCode-53
 */
public class Max_subArray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = max + nums[i] > nums[i] ? max + nums[i] : nums[i];
            result = result > max ? result : max;
        }
        return result;
    }
}
