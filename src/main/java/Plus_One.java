import java.math.BigDecimal;

/**
 * leetcode-66
 * */
public class Plus_One {
    public int[] plusOne(int[] digits) {
        StringBuffer str = new StringBuffer();

        for (int i = 0; i < digits.length; i++) {
            str.append(digits[i]);
        }

        BigDecimal num = new BigDecimal(str.toString());
        BigDecimal sum = num.add(new BigDecimal(1));

        String strSum = String.valueOf(sum);

        int[] result = new int[strSum.length()];
        for (int i = 0; i < strSum.length(); i++) {
            result[i] = Integer.valueOf(String.valueOf(strSum.charAt(i)));
        }
        return result;
    }
}
