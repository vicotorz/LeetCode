import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LeetCode-387
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 */
public class First_Unique_Character_in_a_String {
    public int firstUniqChar(String s) {
        if(s==null||s.length()==0) {
            return -1;
        }

        LinkedHashMap<Character,Integer> map = new LinkedHashMap();



        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }

        int index = -1;
        for(Map.Entry<Character,Integer> entry:map.entrySet()) {
            //System.out.println(entry.getKey()+"---"+entry.getValue());
            if(entry.getValue()==1) {
                index = s.indexOf(entry.getKey());
                break;
            }

        }
        return index;
    }
}
