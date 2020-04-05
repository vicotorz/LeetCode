import java.math.BigInteger;

/**
 * leetcode-67
 */
public class Add_Binary {
    public String addBinary(String a, String b) {
//          int num_a = Integer.valueOf(a,2);
//         int num_b = Integer.valueOf(b, 2);

//         int sum = num_a + num_b;

//         return Integer.toBinaryString(sum);
        return (new BigInteger(a, 2).add(new BigInteger(b, 2)).toString(2));
    }
}
