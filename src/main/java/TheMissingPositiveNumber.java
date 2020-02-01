/**
 * LeetCode-41
 *
 * hard for me
 * https://leetcode.com/problems/first-missing-positive/
 */
public class TheMissingPositiveNumber {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // 只换正数，并且只针对1-n的数进行更换
        // 把nums[i]放在nums[i]-1的位置
        for (int i = 0; i < nums.length; i++) {
            //用while的原因是，每次nums[nums[i] - 1] 与 nums[i]交换
            //更换过来以后，i位置不一定换过来什么值，还要继续判断
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums[i] - 1, i, nums);
                //System.out.println("交换---" + (nums[i] - 1) + "%%" + "    " + i);
                //printArray(nums);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
