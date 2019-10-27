import java.util.Arrays;

/**
 * LeetCode-217
 */
public class Kth_Largest_Num {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);

        return nums[nums.length-1-k+1];
    }
}
