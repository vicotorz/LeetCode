/**
 * LeetCode-268
 * https://leetcode.com/problems/missing-number/
 */
public class Missing_Number {
    public int missingNumber(int[] nums) {
        if(nums==null|| nums.length==0) {
            return 0;
        }
        int sum = 0;
        for(int i=0;i<nums.length;i++) {
            sum += nums[i];
        }
        return (nums.length*(nums.length+1)/2) - sum;
    }
}
