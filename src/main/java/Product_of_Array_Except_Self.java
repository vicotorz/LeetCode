/**
 * LeetCode-238
 * 计算从左到右的结果
 * 计算从右到左的结果
 * 结果=左i-1  *  右i+1
 */
public class Product_of_Array_Except_Self {
    public int[] productExceptSelf(int[] nums) {
        if(nums==null||nums.length==0) {
            return null;
        }
        int[] FromLeft = new int[nums.length];
        int[] FromRight = new int[nums.length];
        int[] res = new int[nums.length];

        int plux = nums[0];
        int plux2 = nums[nums.length - 1];
        FromLeft[0] = plux;
        FromRight[nums.length - 1] = plux2;
        for (int i = 1; i < nums.length-1; i++) {
            plux *= nums[i];
            plux2 *= nums[nums.length - 1 - i];
            FromLeft[i] = plux;
            FromRight[nums.length - 1 - i] = plux2;
        }

        res[0] = FromRight[1];
        res[nums.length - 1] = FromLeft[nums.length - 2];
        for (int j = 1; j < nums.length - 1; j++) {
            res[j] = FromLeft[j - 1] * FromRight[j + 1];
        }
        return res;
    }
}
