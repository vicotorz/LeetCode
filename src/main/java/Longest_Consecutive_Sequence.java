import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode-128
 */
public class Longest_Consecutive_Sequence {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0||nums==null) {
            return 0;
        }
        Set<Integer> hashSet = new HashSet<Integer>();

        for(int n:nums) {
            //将所有元素添加到set中
            hashSet.add(n);
        }

        int lcs = 0;//最长连续字符串
        //遍历数组的值
        for(int n:nums) {
            int num = n;
            int count = 1;//临时记录
            //找比num小的数
            while(hashSet.contains(--num)) {//有就继续
                count++;
                hashSet.remove(num);
            }
            //找比num大的数
            num = n;
            while(hashSet.contains(++num)) {
                count++;
                hashSet.remove(num);
            }
            lcs = Math.max(lcs, count);
        }
        return lcs;
    }
}
