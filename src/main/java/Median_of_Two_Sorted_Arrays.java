/**
 * LeetCode-4
 */
public class Median_of_Two_Sorted_Arrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        int length = length1+length2;
        if(length % 2 == 0) {
            //长度如果是奇数，最中间那个就是中位数
            return (findKth(nums1, nums2, 0, 0, length/2) + findKth(nums1, nums2, 0, 0, length/2+1))/ 2.0;
        } else {
            //长度是偶数，中间位置+1那个就是中位数
            return findKth(nums1, nums2, 0, 0, length/2 + 1);
        }
    }

    //找到第K个位置
    public double findKth(int[] nums1, int[]nums2, int starta, int startb, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        //如果A到头了，那就是B了
        if(starta >= len1){
            return nums2[startb + k - 1];//index starts from 0
        }
        if(startb >= len2){
            return nums1[starta + k - 1];//index starts from 0
        }
        if(k == 1){
            //This block means:
            //When we need to find the 1th min element in two Array
            //We just return the first element which is the element pointed by the 'start index' in each Array and compare them.
            //The reason for we picking the smaller one is when the two arrays merged, the smaller one will stand in front of the bigger one;
            //The smaller one will be the Kth, and the bigger one actually become the (k+1)th element in the merge Array.
            return Math.min(nums1[starta], nums2[startb]);

        }

        int mid = k/2 - 1;//index starts from 0, so the mid of K is K/2 - 1
        int keypoint1 = starta + mid >= len1? Integer.MAX_VALUE : nums1[starta + mid];//keypoint1 is the k/2 one of nums1
        int keypoint2 = startb + mid >= len2? Integer.MAX_VALUE : nums2[startb + mid];//keypoint2 is the k/2 one of nums2

        if(keypoint1 > keypoint2){
            //When we cut off some elements from one array, the 'start' index moves forward by [start + k/2]
            //k-k2 means that we have eliminated K/2 elements, so k-k/2 elements left
            return findKth(nums1, nums2, starta, startb + k/2, k - k/2);//A比B大，B向后，抛弃了k/2个元素，因此要找k-k/2的
        } else {
            return findKth(nums1, nums2, starta + k/2, startb, k - k/2);//A向后
        }
    }
}
