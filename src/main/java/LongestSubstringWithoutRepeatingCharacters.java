import java.util.HashMap;

/**
 * LeetCode-3
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashMap<String, Integer> map = new HashMap();
        int max = 1;
        int low = 0;
        int high = 0;
        for (; high < s.length();) {
            String str = String.valueOf(s.charAt(high));
            if (map.get(str) != null) {
                max = max > (high - low) ? max : (high - low);
                low = low > map.get(str) + 1 ? low : (map.get(str) + 1);
            }
            map.put(str, high);
            high++;
        }
        max = max > (high - low) ? max : (high - low);
        if (s.equals("")) {
            max = 0;
        }
        return max;
    }
}
