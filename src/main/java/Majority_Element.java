import java.util.Arrays;

/**
 * LeetCode-149
 * 排序找到中位数就可以了
 */
public class Majority_Element {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
