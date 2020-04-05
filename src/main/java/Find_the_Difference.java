import java.util.Arrays;
/**
 * leetcode-389
 * */
public class Find_the_Difference {
    public char findTheDifference(String s, String t) {
        if (s == null || t == null) {
            return ' ';
        }

        char[] chrs = s.toCharArray();
        char[] chrt = t.toCharArray();

        Arrays.sort(chrs);
        Arrays.sort(chrt);

        char diff = '%';
        for (int i = 0; i < s.length(); i++) {
            if (chrs[i] != chrt[i]) {
                diff = chrt[i];
                break;
            }
        }

        diff = diff == '%' ? chrt[chrt.length - 1] : diff;

        return diff;
    }
}
