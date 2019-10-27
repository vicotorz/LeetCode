/**
 * LeetCode-213
 */
public class House_Robber2 {
    public int rob(int[] nums) {
        //第一家和最后一家分别去掉，各算一遍能抢的最大值，然后比较两个值取其中较大的一个即为所求
        //首元素，末元素置为0
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int start=nums[0];
        int end=nums[nums.length-1];
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];

        //1 time
        nums[0]=0;
        dp1[0]=nums[0];
        dp1[1]=Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp1[i] = Math.max(nums[i]+dp1[i-2], dp1[i - 1]);
        }

        //2 time
        nums[0]=start;
        nums[nums.length-1]=0;
        dp2[0]=nums[0];
        dp2[1]=Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp2[i] = Math.max(nums[i]+dp2[i-2], dp2[i - 1]);
        }

        return dp1[nums.length - 1]>dp2[nums.length - 1]?dp1[nums.length - 1]:dp2[nums.length - 1];
    }
}
