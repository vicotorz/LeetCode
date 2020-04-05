import java.util.HashMap;

/**
 * leetcode-205
 * */
public class Isomorphic_Strings {

    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) {
            return false;
        }


        HashMap<Character,Character> stMap = new HashMap();
        HashMap<Character,Character> tsMap = new HashMap();

        int length = s.length();

        for(int i=0;i<length;i++) {
            char s_char = s.charAt(i);
            char t_char = t.charAt(i);

            if(stMap.containsKey(s_char) && stMap.get(s_char)!=t_char) {
                return false;
            }else if(tsMap.containsKey(t_char) && tsMap.get(t_char)!=s_char) {
                return false;
            }else {
                stMap.put(s_char, t_char);
                tsMap.put(t_char, s_char);
            }
        }
        return true;
    }
}
