/**
 * LeetCode-35
 */
public class Search_Insert_Position {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 1) {
            if (target == nums[0]) {
                return 0;
            } else if (target < nums[0]){
                return 0;
            }else if (target > nums[0]){
                return 1;
            }
        }
        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == target) {//正好
                result = i;
                break;
            } else if (nums[i] < target && nums[i + 1] > target) {//前一个大，后一个小
                result = i + 1;
                break;
            } else if (nums[i] < target && (i + 1) == nums.length - 1) {//注意边界条件
                result = i + 2;
                break;
            }
        }
        if(nums[nums.length-1] == target) {
            return nums.length-1;
        }
        return result;
    }
}
