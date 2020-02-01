/**
 * LeetCode-171
 */
public class Excel_Sheet_Column_Number {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int length = s.length();
        int result = 0;

        for (int i = 0; i < length; i++) {
            result = (int) (result + Math.pow(26, i) * ((byte) s.charAt(length - i - 1) - 64));
        }

        return result;
    }
}
