/**
 * LeetCode-189
 * https://leetcode.com/problems/rotate-array/
 */
public class Rotate_Array {
    public void rotate(int[] nums, int k) {
        if (nums.length == 0 || nums == null) {
            return;
        }
        // i位置的移动到 (i+k+length)%length
        int beReplaced;
        int tmp = -1;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            beReplaced = nums[i];
            for (int j = i + k;; j = j + k) {
                if (j > nums.length - 1) {
                    j = j % nums.length;
                }

                tmp = nums[j];// 给下一次用
                nums[j] = beReplaced;
                beReplaced = tmp;
                //print(nums);
                sum += j;
                if (j == i || j < i) {
                    //System.out.println("break---" + i);
                    break;
                }
            }
            // 循环一遍可能都走遍了
            if (sum == (nums.length - 1) * nums.length / 2) {
                break;
            }
        }
        //System.out.println("=========");
        //print(nums);
    }
}
