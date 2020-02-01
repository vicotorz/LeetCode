import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode-554
 *
 */
public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> sumMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < wall.size(); i++) {
            List<Integer> list = wall.get(i);
            int tmpSum = 0;
            for (int j=0;j<list.size()-1;j++) {
                tmpSum += list.get(j);
                sumMap.put(tmpSum, sumMap.getOrDefault(tmpSum, 0) + 1);
            }
        }

        int res = Integer.MAX_VALUE;
        for (Map.Entry entry : sumMap.entrySet()) {
            //System.out.println(entry.getKey()+"---"+entry.getValue());
            res = Math.min(wall.size() - Integer.valueOf(entry.getValue().toString()), res);
        }
        if (res == Integer.MAX_VALUE) {
            res = wall.size();
        }
        return res;
    }
}
