import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * LeetCode-863
 */
public class ShortestSubarraywithSumatLeastK {
    public int shortestSubarray(int[] A, int K) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int len = A.length;
        int res = len + 1;

        int[] sum = new int[res];
        //计算和
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + A[i];
        }

        Deque<Integer> d = new ArrayDeque();

        for (int i = 0; i < len + 1; i++) {
            while (d.size() > 0 && sum[i] - sum[d.getFirst()] >= K) {//为了从最大处逼近K，我们从队头依次取索引出来计算：
                res = Math.min(res, i - d.pollFirst());
            }
            while (d.size() > 0 && sum[i] <= sum[d.getLast()]) {
                d.pollLast();
            }
            d.addLast(i);
        }
        return res <= len ? res : -1;
    }

    public static int shortestSubarray1(int[] A, int K) {
        if (A == null || A.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap();// <遍历计算的和，位置>
        map.put(0, -1);//这个地方如果不设置为-1，会到值是否包含第一个元素的用例会变得模糊
        int sum = 0;
        int minSize = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            sum = sum + A[i];
            map.put(sum, i);
            if (A[i] == K) {
                minSize = Math.min(minSize, 1);
                continue;
            }
            if (map.containsKey(sum - K)) {
                System.out.println("check---" + (i) + "," + (sum - K));
                //算不算第一个值，需要特殊处理
                //int delta = map.get(sum - K)==0?1:0;
                minSize = Math.min(minSize, i - map.get(sum - K));
                System.out.println("bingo!==" + minSize);
            } else if (sum > K) {
                // 反向查找
                System.out.println("反向查找" + sum);
                int revSum = 0;
                for (int j = i; j >= 0; j--) {
                    revSum = revSum + A[j];
                    if (sum - revSum <= K) {//可以减去这么多
                        System.out.println(i + "-!!-" + j + "+++" + sum);
                        minSize = Math.min(minSize, i - j + 1);
                        System.out.println("genxin---"+minSize);
                        break;
                    }
                }
            }
        }
        if (minSize == Integer.MAX_VALUE) {
            minSize = -1;
        }
        return minSize;
    }

    public static void main(String[] args) {
        int[] A = {30, 90, 51, 1, -1};
        int K = 120;
        System.out.println(shortestSubarray1(A, K));
    }
}
