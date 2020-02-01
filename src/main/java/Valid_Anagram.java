import java.util.HashMap;

/**
 * LeetCode-242
 * https://leetcode.com/problems/valid-anagram/
 */
public class Valid_Anagram {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        boolean res = true;

        HashMap<Character, Integer> map = new HashMap();

        // 统计
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        // 判断
        for (int j = 0; j < t.length(); j++) {
            char y = t.charAt(j);
            if (!map.containsKey(y) || map.get(y) <= 0) {
                res = false;
                break;
            } else {
                map.put(y, map.get(y) - 1);
            }
        }
        return res;
    }
}
