import java.util.ArrayList;
import java.util.HashMap;

/**
 * LeetCode-146
 */
public class LRUCache {
    int capacity = 0;
    HashMap<String, Integer> map;// 获得value
    ArrayList<String> list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap();
        this.list = new ArrayList();
    }

    public int get(int key) {
        if (!map.containsKey(String.valueOf(key))) {
            return -1;
        } else {
            int result = map.get(String.valueOf(key));
            putToStart(key, map.get(String.valueOf(key)));
            return result;
        }
    }

    public void put(int key, int value) {
        map.put(String.valueOf(key), value);
        putToStart(key, value);
    }

    public void putToStart(int key, int value) {
        // get---头插入，删除
        // put---头插入
        list.remove(String.valueOf(key));
        list.add(0, String.valueOf(key));

        if (list.size() > capacity) {
            map.remove(list.get(list.size() - 1));
            list.remove(list.size() - 1);
        }
    }
}
