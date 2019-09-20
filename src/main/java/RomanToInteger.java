import java.util.HashMap;

/**
 * LeetCode-13
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        int result = 0;

        int i = 0;
        for (; i < s.length() - 1;) {
            String iValue = String.valueOf(s.charAt(i));
            String jValue = String.valueOf(s.charAt(i + 1));
            if (map.get(iValue) < map.get(jValue)) {
                result += (map.get(jValue) - map.get(iValue));
                i = i + 2;
            }
            if (map.get(iValue) >= map.get(jValue)) {
                result += map.get(iValue);
                i = i + 1;
            }
        }
        if (i <= s.length() - 1) {
            result += map.get(String.valueOf(s.charAt(s.length() - 1)));
        }

        return result;

    }
}
