/**
 * LeetCode-581
 */
public class Shortest_Unsorted_Continuous_Subarray {
    public int findUnsortedSubarray(int[] nums) {
        if(nums==null||nums.length==0) {
            return 0;
        }
        int[] tmp = Arrays.copyOfRange(nums, 0, nums.length);
        Arrays.sort(nums);

        int start = nums.length - 1;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (tmp[i] != nums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return (end-start)>0?(end-start+1):0;
    }
}
