/**
 * LeetCode-134
 * https://leetcode.com/submissions/detail/286381665/
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int begin = -1;
        // gas数组
        // cost数组
        // 在gas[i]>cost[i]处出发，开始循环
        for (int i = 0; i < 2 * gas.length; i++) {
            int loc;
            if (i >= gas.length) {
                loc = i % gas.length;
            } else {
                loc = i;
            }
            if (gas[loc] >= cost[loc]) {
                // 可以从loc处进行遍历
                if (goOnRoad(gas, cost, loc, 0)) {
                    begin = loc;
                    //System.out.println("===bigo!===");
                    //System.out.println("begin from :" + begin);
                    break;
                }
            }
        }
        return begin;
    }

    public static boolean goOnRoad(int[] gas, int[] cost, int start, int gasContainer) {
        boolean res = true;
        int times = 1;
        for (int i = start; i < 2 * gas.length; i++) {
            // 从start+1处开始
            int loc;

            if (i >= gas.length) {
                loc = i % gas.length;
            } else {
                loc = i;
            }
            //System.out.println("!!!!"+loc);
            // add oil
            gasContainer = gasContainer + gas[loc];
            //System.out.println(loc + " add oil " + gas[loc] + "---" + gasContainer);

            // consume oil
            gasContainer = gasContainer - cost[loc];
            //System.out.println(loc + " oil consume: " + cost[loc] + "---" + gasContainer);

            if (gasContainer < 0) {
                //System.out.println("oil insufficient");
                res = false;
                break;
            }

            if (loc == start) {
                if (times == 2) {
                    //System.out.println("return to begin");
                    break;
                } else {
                    times++;
                }
            }
        }
        return res;
    }
}
