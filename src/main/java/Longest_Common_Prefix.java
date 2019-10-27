import java.util.Arrays;

/**
 * LeetCode-14
 */
public class Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1)
            return "";
        Arrays.sort(strs);
        String candidate = strs[0];
        int len = candidate.length();
        boolean agreed;

        while (len >= 0) {
            agreed = true;
            String sub = candidate.substring(0, len);
            for (int i = 1; i < strs.length; i++)
                if (!strs[i].startsWith(sub)) {
                    agreed = false;
                    break;
                }
            if (agreed)
                return sub;
            else
                len--;
        }

        return "";
    }
}
