import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * LeetCode-57
 */
public class Insert_Interval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //基于Merge Intervals
        if(intervals.length==0) {
            int[][] res = new int[1][2];
            res[0][0] = newInterval[0];
            res[0][1] = newInterval[1];
            return res;
        }
        int[] X = new int[intervals.length + 1];
        int[] Y = new int[intervals.length + 1];

        for (int i = 0; i < intervals.length; i++) {
            X[i] = intervals[i][0];
            Y[i] = intervals[i][1];
        }

        X[intervals.length] = newInterval[0];
        Y[intervals.length] = newInterval[1];

        Arrays.sort(X);
        Arrays.sort(Y);

        Map<Integer, Integer> map = new TreeMap();

        int start = 0;
        for (int j = 0; j < intervals.length+1; j++) {
            if (j==intervals.length||X[j + 1] > Y[j]) {
                map.put(X[start], Y[j]);
                start = j + 1;
            }
        }

        int[][] res = new int[map.keySet().size()][2];
        int t = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res[t][0] = entry.getKey();
            res[t][1] = entry.getValue();
            t++;
        }
        return res;
    }
}
