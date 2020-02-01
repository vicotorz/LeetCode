import java.math.BigDecimal;
import java.util.regex.Pattern;

/**
 * LeetCode-8
 *https://leetcode.com/problems/string-to-integer-atoi/
 */
public class String_to_Integer {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();

        String pattern = "(\\-|\\+)?\\d+(.*)?";

        boolean isMatch = Pattern.matches(pattern, str);

        StringBuffer sb = new StringBuffer();

        if (!isMatch) {
            // System.out.println("not match");
            return 0;
        } else {
            // System.out.println("already match");
            // 获取值
            for (int i = 0; i < str.length(); i++) {
                if (((byte) str.charAt(i)) >= 48 && ((byte) str.charAt(i) <= 57)
                        || ((byte) str.charAt(i) == 45 && i == 0) || ((byte) str.charAt(i) == 43 && i == 0)) {
                    sb.append(str.charAt(i));
                } else {
                    break;
                }
            }
        }
        if (sb.toString().isEmpty()) {
            return 0;
        } else {

            // 判断是否大于
            BigDecimal bd = new BigDecimal(sb.toString());
            if (bd.compareTo(new BigDecimal(Integer.MAX_VALUE)) == 1) {
                return Integer.MAX_VALUE;
            } else if (bd.compareTo(new BigDecimal(Integer.MIN_VALUE)) == -1) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.valueOf(sb.toString());
            }
        }
    }
}
