import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode-27
 */
public class Merge_Intervals {
    public List<Interval> merge(List<Interval> intervals) {
        //start 位置排序，end 位置排序
        //start[i+1]>end[i],说明不连续了，加入start[i+1],end[i+1]
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];
        //构造start end数组
        for(int step = 0;step<start.length;step++) {
            start[step]=intervals.get(step).start;
            end[step]=intervals.get(step).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        List<Interval> res = new ArrayList();
        int j = 0;
        int i  =0;
        for(;i<intervals.size();i++) {
                if(i==intervals.size()-1||(start[i+1]>end[i])) {
                res.add(new Interval(start[j], end[i]));
                j=i+1;
            }
        }
        return res;
    }
}
