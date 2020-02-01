/**
 * LeetCode-31
 * https://leetcode.com/problems/next-permutation/
 *
 * hard for me
 */
//// https://www.acwing.com/solution/LeetCode/content/103/
// 1.从后找降序的位置 xi
// 2.找到，从后向前找比这个值大的 xj 没找到，说明本来就是最大，将数组逆序即可
// 3.交换xi xj
// 4.将xi后面的数字逆序输出
public class Next_Permutation {
    public void nextPermutation(int[] nums) {
        if(nums==null||nums.length==0||nums.length==1) {
            return;
        }

        // 找逆序的位置
        int revLoc = -1;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i - 1] < nums[i]) {
                revLoc = i - 1;
                break;
            }
        }

        if (revLoc == -1) {
            reverseArray(nums, 0, nums.length - 1);
            return;
        } else {

            int revLoc2 = -1;
            // 从后向前找到比revLoc位置大的数字
            for (int j = nums.length - 1; j > revLoc; j--) {
                if (nums[j] > nums[revLoc]) {
                    revLoc2 = j;
                    break;
                }
            }

            // 交换后逆序
            swap(nums, revLoc, revLoc2);

            reverseArray(nums, revLoc + 1, nums.length - 1);
        }
    }

    public void reverseArray(int[] nums, int start, int end) {
        for (int i = start, j = end; i <= j; i++, j--) {
            swap(nums, i, j);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
