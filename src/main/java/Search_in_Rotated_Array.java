/**
 * LeetCode-33
 */
public class Search_in_Rotated_Array {
    public int search(int[] nums, int target) {
        if(nums.length==0||nums==null) {
            return -1;
        }
        int start=0;
        int end=nums.length-1;
        while(start<=end) {
            int mid = (end+start)/2;
            if(nums[mid]==target) {
                return mid;
            }

            if(nums[mid]<nums[end]) {
                //右面有序
                if(target>nums[mid]&&target<=nums[end]) {
                    start=mid +1;
                }else {
                    end = mid -1;
                }
            }else {
                //左面有序
                if(target<nums[mid]&&target>=nums[start]) {
                    end = mid -1;
                }else {
                    start=mid +1;
                }
            }
        }
        return -1;
    }
}
