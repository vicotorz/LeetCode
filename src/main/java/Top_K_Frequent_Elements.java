import java.util.*;

/**
 * LeetCode-347
 * hard for me
 */
public class Top_K_Frequent_Elements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        ArrayList<Map.Entry<Integer,Integer>> list = new ArrayList();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        list.addAll(map.entrySet());
        //PriorityQueue<Integer> queue = new PriorityQueue();
        //对这个map的value进行排序
        //用Collections,对list进行排序
        Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>() {
            public int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2) {
                // TODO Auto-generated method stub
                return entry2.getValue()-entry1.getValue();
            }
        });

        List<Integer> res = new ArrayList();
        for(int i=0;i<k;i++) {
            res.add(list.get(i).getKey());
        }
        return res;
    }
}
