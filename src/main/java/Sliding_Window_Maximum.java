import java.util.LinkedList;

/**
 * LeetCode-239
 */
public class Sliding_Window_Maximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||nums.length==0){
            int[] result = {};
            return result;
        }

        // 如果是空，直接放入队列
        // 如果array[i]<queue.peek() 放入队列尾部
        // 如果array[i]>=queue.peek() queue.peek()弹出
        // 如果queue.head >= i-k 说明已经过期，需要弹出

        int[] result = new int[nums.length - k + 1];// 一共生成nums.length-(k-1)个结果
        LinkedList<Integer> indexQueue = new LinkedList<Integer>();// Queue的子实现类
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            while (!indexQueue.isEmpty() && nums[i] >= nums[indexQueue.peekLast()]) {
                indexQueue.pollLast();// array[i] >= 队列
            }
            if (indexQueue.isEmpty() || nums[i] < nums[indexQueue.peek()]) {
                indexQueue.addLast(i);// array[i] < 队列
            }

            if (indexQueue.peekFirst() == (i - k)) {
                indexQueue.pollFirst();// 维持窗口
            }

            if (i >= (k - 1)) {
                result[j++] = nums[indexQueue.peekFirst()];// 获取最大值
            }
        }
        return result;
    }
}
