import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode-412
 */
public class Fizz_Buzz {
    public List<String> fizzBuzz(int n) {
        ArrayList<String> result = new ArrayList();

        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 != 0) {
                result.add(String.valueOf(i));
            } else if (i % 3 == 0 && i % 5 != 0) {
                result.add("Fizz");
            } else if (i % 3 != 0 && i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add("FizzBuzz");
            }
        }
        return result;
    }
}
