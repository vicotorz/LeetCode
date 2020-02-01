import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode-697
 * https://leetcode.com/problems/degree-of-an-array/
 */
public class Degree_of_an_Array {
    public int findShortestSubArray(int[] nums) {
        if(nums==null||nums.length==0) {
            return 0;
        }

        int maxDegree = 0;
        HashMap<Integer, Integer> map = new HashMap();

        for (int e : nums) {
            int degree = map.getOrDefault(e, 0) + 1;
            map.put(e, degree);
            maxDegree = Math.max(degree, maxDegree);
        }
        // 获取度数最大的数字
        ArrayList<Integer> list = new ArrayList();

        for (Map.Entry entry : map.entrySet()) {
            if (Integer.valueOf(entry.getValue().toString()) == maxDegree) {
                list.add(Integer.valueOf(entry.getKey().toString()) );
            }
        }

        int minResult = Integer.MAX_VALUE;
        // 找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度
        // 如果x为度数最大的数字，度数是N，则子数组一定要包含N个x
        for (int maxNum : list) {
            // 以maxNum为根本，查找nums
            int tmpCount = 0;
            int tmpLength = 0;
            boolean isCounting = false;
            for (int num : nums) {
                if (num == maxNum) {
                    tmpCount++;
                    isCounting = true;
                }
                if (isCounting) {
                    tmpLength++;
                }
                if (tmpCount == maxDegree) {
                    break;
                }
            }
            minResult = Math.min(minResult, tmpLength);
        }
        return minResult;
    }
}
