import java.util.Arrays;
/**
 * leetcode-342
 *
 * favorite
 * */
public class Wiggle_Sort_II {
    public void wiggleSort(int[] nums) {
        if(nums.length == 1) return;
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        int smallIndex = (nums.length+1)/2-1;
        int largeIndex = nums.length-1;
        for(int i = 0; i < nums.length; ++i) {
            nums[i] = (i%2 == 0) ? temp[smallIndex--] : temp[largeIndex--];
        }
    }
}
