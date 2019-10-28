import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode-771
 */
public class Jewels_and_Stones {
    public int numJewelsInStones(String J, String S) {
        int res = 0;
        Set<Character> jewelsSet = new HashSet();
        for(int i=0;i<J.length();i++) {
            jewelsSet.add(J.charAt(i));
        }
        for(int j=0;j<S.length();j++) {
            if(jewelsSet.contains(S.charAt(j))) {
                res++;
            }
        }
        return res;
    }
}
