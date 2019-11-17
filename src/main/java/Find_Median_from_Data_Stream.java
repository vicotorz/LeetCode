import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * LeetCode-295
 */
public class Find_Median_from_Data_Stream {
    //https://leetcode-cn.com/problems/find-median-from-data-stream/solution/you-xian-dui-lie-python-dai-ma-java-dai-ma-by-liwe/
    int count;//大根堆和小根堆元素个数之和
    Queue<Integer> minQueue;//最小堆
    Queue<Integer> maxQueue;//最大堆


    /** initialize your data structure here. */
    public Find_Median_from_Data_Stream() {
        count = 0;
        minQueue = new PriorityQueue();
        maxQueue = new PriorityQueue(new Comparator<Integer>() {

            @Override
            public int compare(Integer x, Integer y) {
                // TODO Auto-generated method stub
                return y-x;
            }
        });//要把大根对元素反过来
    }

    public void addNum(int num) {
        count++;
        maxQueue.offer(num);
        minQueue.add(maxQueue.poll());

        //如果两个堆元素加一起为奇数，则小根堆拿出堆顶元素给大根堆
        if((count & 1)!=0) {
            maxQueue.add(minQueue.poll());
        }
    }

    public double findMedian() {
        if((count & 1)==0) {
            //偶数，中间值为小根堆和大根堆堆顶元素的平均值
            return (double)(maxQueue.peek()+minQueue.peek())/2;
        }else {
            //奇数，数据流中大根堆的堆顶元素
            return (double)maxQueue.peek();
        }
    }
}
