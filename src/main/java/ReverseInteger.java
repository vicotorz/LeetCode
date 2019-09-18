import java.math.BigDecimal;

/**
 * LeetCode-7
 */
public class ReverseInteger {
    public int reverse(int x) {
        boolean negative = x < 0 ? true : false;
        BigDecimal tmp_num = (x < 0) ? new BigDecimal(x).multiply(new BigDecimal(-1)) : new BigDecimal(x);
        //转字符串处理
        char[] str = String.valueOf(tmp_num).toCharArray();

        int i = 0;
        int j = str.length - 1;
        for (; i <= j; i++, j--) {
            char tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
        }

        StringBuffer tt = new StringBuffer();

        for (char e : str) {
            tt.append(e);
        }

        BigDecimal result = new BigDecimal(tt.toString());
        //负值
        if (negative) {
            result = result.multiply(new BigDecimal(-1));
        }
        //是否超界
        if (result.compareTo(new BigDecimal(Math.pow(-2, 31))) == -1
                || result.compareTo(new BigDecimal(Math.pow(2, 31))) == 1) {
            return 0;
        } else {
            return result.intValue();
        }
    }
}
