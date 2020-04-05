/**
 * LeetCode-162
 */

public class Find_Peak_Element {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = 0;

        if (nums.length == 1) {
            return 0;
        } else if (nums.length == 2) {
            return nums[0] > nums[1] ? 0 : 1;
        } else {
            // 三个元素
            for (int i = 1; i <= nums.length - 2; i++) {
                if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                    result = i;
                    break;
                }
            }

            if (nums[0] > nums[1]) {
                result = 0;
            }

            if (nums[nums.length - 1] > nums[nums.length - 2]) {
                result = nums.length - 1;
            }

        }
        return result;
    }
}
