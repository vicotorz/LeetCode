/**
 * LeetCode-136
 */
public class Single_Number {
    //异或就好
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i=0;i<nums.length;i++) {
            result = result ^ nums[i];
        }
        return result;
    }
}
