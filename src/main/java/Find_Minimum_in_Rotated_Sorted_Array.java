
/**
 * leetcode-163
 * */
public class Find_Minimum_in_Rotated_Sorted_Array {
    public int findMin(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        int med;

        int result = -1;

        while (left < right) {
            med = (left + right) / 2;
            //System.out.println("location:::" + left + "--------" + med + "-------" + right);
            //System.out.println("value:::" + nums[left] + "--------" + nums[med] + "-------" + nums[right]);
            if (nums[left] <= nums[med] && nums[med] < nums[right]) {
                // System.out.println("[1]");
                // 整体有序
                return nums[left];
            } else if (nums[left] < nums[med] && nums[med] > nums[right]) {
                // System.out.println("[2]");
                // 需要查看nums[left] 与 nums[right] 之间的关系
                if (nums[left] >= nums[right]) {
                    left = med + 1;
                } else {
                    right = med - 1;
                }
            } else if (nums[left] >= nums[med] && nums[med] > nums[right]) {
                // System.out.println("[3]");
                // 整体逆序
                return nums[right];
            } else if (nums[left] > nums[med] && nums[med] < nums[right]) {
                // System.out.println("[4]");
                // 有可能nums[med]就是，查看一下nums[left]和nums[right]之间的关系
                if (nums[left] >= nums[right]) {
                    right = med;
                } else {
                    left = med;
                }
            }
        }

        result = nums[left];
        return result;
    }
}
