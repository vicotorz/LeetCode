/**
 * LeetCode-503
 * https://leetcode.com/problems/next-greater-element-ii/
 */
public class Next_Greater_Element_II {
    public int[] nextGreaterElements(int[] nums) {
        if(nums==null||nums.length==0) {
            return new int[] {};
        }

        int[] res = new int[nums.length];

        for(int i=0;i<nums.length;i++) {
            int afterMax = -1;
            //找后面的最大值
            for(int j=i+1;;j++) {
                int loc =j;
                if(j>=nums.length) {
                    loc = j % nums.length;
                }
                if(loc == i) {
                    break;
                }
                if(nums[loc]>nums[i]) {
                    afterMax = nums[loc];
                    break;
                }
            }
            res[i] = afterMax;
        }
        return res;
    }
}
