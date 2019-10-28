import java.util.*;

/**
 * LeetCode-621
 * hard for me
 */
public class Task_Scheduler {
    public int leastInterval(char[] tasks, int n) {
        if(tasks.length==0||tasks==null) {
            return 0;
        }
        //需要知道每个字符出现多少次
        //以及按照字符出现频度进行分配任务
        Map<Character,Integer> map = new TreeMap();
        for(int i=0;i<tasks.length;i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0)+1);
        }

        List<Map.Entry<Character,Integer>> list = new ArrayList<Map.Entry<Character,Integer>>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<Character,Integer>>(){

            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                // TODO Auto-generated method stub
                return o2.getValue().compareTo(o1.getValue());
            }

        });

        // (max-1)*(n+1)+c
        int c = 0;
        int max = list.get(0).getValue();
        for(Map.Entry<Character,Integer> entry:list) {
            if(entry.getValue()==max) {
                c++;
            }else {
                break;
            }
        }
        return Math.max(tasks.length, (max-1)*(n+1)+c);
    }
}
