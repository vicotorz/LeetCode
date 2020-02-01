import java.util.*;

/**
 * LeetCode-438
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 *
 * commit many times for me
 */
public class Find_All_Anagrams_in_a_String {
    public List<Integer> findAnagrams(String s, String p) {
        if(s==null||p==null||s.isEmpty()||p.isEmpty()||p.length()>s.length()) {
            return new ArrayList();
        }
        // 统计子串
        HashMap<Character, Integer> map = new HashMap();// 字母，频数
        for (int i = 0; i < p.length(); i++) {
            if (map.containsKey(p.charAt(i))) {
                map.put(p.charAt(i), map.get(p.charAt(i)) + 1);
            } else {
                map.put(p.charAt(i), 1);
            }
        }

        Set<Character> chSet = map.keySet();

        // 可以利用滑动窗口
        // 确定左右边界
        int left = 0;
        int right = 0;

        ArrayList<Integer> resList = new ArrayList();

        for (; right <= p.length() - 1; right++) {
            if (chSet.contains(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
            }
        }
        right--;
        if (check(map)) {
            resList.add(0);
        }
        // 开始滑动
        while (true) {
            // 把过去的剪掉
            if (chSet.contains(s.charAt(left))) {
                map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
            }
            left++;
            right++;
            // 把新来的纳入
            if (right >= s.length()) {
                break;
            }
            if (chSet.contains(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
            }
            if (check(map)) {
                resList.add(left);
            }
        }
        return resList;
    }

    public static boolean check(HashMap<Character, Integer> map) {
        boolean res = true;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            // System.out.println(entry.getKey() + "---" + entry.getValue());
            if (entry.getValue() != 0) {
                res = false;
                break;
            }
        }
        return res;
    }
}
