/**
 * LeetCode-26
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class Remove_Duplicates_from_Sorted_Array {
    public int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==0) {
            return 0;
        }
        int length = nums.length;
        int targetLength = 1;
        int pre = nums[0];
        for(int i=1;i<nums.length;i++) {
            if((pre ^ nums[i])==0) {
                //检测到重复
                length --;
            }else {
                //检测到不重复
                nums[targetLength] = nums[i];
                targetLength++;
            }
            pre = nums[i];
        }
        return length;
    }
}
