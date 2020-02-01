import java.util.Arrays;

/**
 * LeetCode-88
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class Merge_Sorted_Array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = nums1.length - n; i < nums1.length; i++) {
            nums1[i] = nums2[i-m];
        }

        Arrays.sort(nums1);
    }
}
