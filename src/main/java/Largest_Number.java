import java.util.Arrays;
import java.util.Comparator;

/**
 * LeetCode-179
 */
public class Largest_Number {
    public String largestNumber(int[] nums) {
        String result = new String();
        if (nums.length == 0) {
            return result;
        }

        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
            // 将int型数组转化为字符数组 方便cmp中的拼接 int型拼接不知道位数不好操作
        }

        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String a, String b) {
                // TODO Auto-generated method stub
                return (a + b).compareTo(b + a);
            }

        });
        //特殊情况0的处理
        if (strs[nums.length - 1].equals("0"))
            return "0"; // nums[]中是一串0
        // 将排序后的字符拼接起来
        for (int i = nums.length - 1; i >= 0; i--) {
            result = result + strs[i];
        }
        return result;
    }
}
