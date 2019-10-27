import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * LeetCode-49
 */
public class Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap();
        for (int i = 0; i < strs.length; i++) {
            char[] ca = strs[i].toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (map.containsKey(key)) {
                map.get(key).add(strs[i]);
            } else {
                ArrayList<String> list = new ArrayList();
                list.add(strs[i]);
                map.put(key, list);
            }
        }

        return new ArrayList(map.values());
    }
}
