/**
 * LeetCode-75
 * hard for me
 */
public class Sort_Colors {
    public void sortColors(int[] nums) {
        int begin = 0;
        int end = nums.length - 1;
        for (int i = 0; i <=end; i++) {
            if (nums[i] == 0) {
                // swap(nums[i], nums[begin++]);
                // 遇到0与头部交换
                int tmp = nums[i];
                nums[i] = nums[begin];
                nums[begin] = tmp;
                begin++;
            } else if (nums[i] == 2) {
                // swap(nums[i--], nums[end--]);
                // 遇到2与尾部交换
                int tmp = nums[i];
                nums[i] = nums[end];
                nums[end] = tmp;
                end--;
                i--;// 从尾部交换过来的不知道是什么数字，所以要回去判断是不是0
            }
        }
    }
}
