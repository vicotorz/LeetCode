
/**
 * leetcode-43
 *
 * important
 * */


public class Multiply_Strings {

    public String multiply(String num1, String num2) {
        StringBuffer res = new StringBuffer();

        int size1 = num1.length();
        int size2 = num2.length();

        int[] vals = new int[size1 + size2];

        for (int i = size1 - 1; i >= 0; i--) {
            for (int j = size2 - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = mul + vals[p2];
                vals[p1] += sum / 10;
                vals[p2] = sum % 10;
            }
        }

        for (int val : vals) {
            if (!res.toString().isEmpty() || val != 0) {
                res.append(val);
            }
        }
        return res.toString().isEmpty() ? "0" : res.toString();
    }
}
