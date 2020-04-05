
/**
 * leetcode-154
 * hard for me
 * */
public class Find_Minimum_in_Rotated_Sorted_Array_2 {
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int minIndex = findMin(0, nums.length - 1, nums);

        return nums[minIndex];
    }

    private static int findMin(int begin, int end, int[] nums) {
        if (begin == end)
            return begin;
        int mid = (begin + end) / 2;
        if (nums[mid] < nums[end]) { // right part is sorted so minimun exists in the left
            while (mid - 1 >= begin && nums[mid] == nums[mid - 1])
                mid--;
            return findMin(begin, mid, nums);
        } else if (nums[mid] > nums[end]) {// left part is sorted so minimun exists in the right
            int i = mid + 1;
            while (i + 1 <= end && nums[i + 1] == nums[i])
                i++;
            return findMin(i, end, nums);
        } else
            return findMin(0, end - 1, nums);
    }
}
