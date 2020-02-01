import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.regex.Pattern;

/**
 * 227  Basic Calculator Ⅱ
 * https://leetcode.com/problems/basic-calculator-ii/
 */
public class BasicCalculator2 {
    public int calculate(String s) {
        Deque<Object> deque = new ArrayDeque();
        s = s.trim();

        StringBuffer sb = new StringBuffer();// 拼接数字
        // 识别数字
        for (int i = 0; i < s.length(); i++) {

            if (Pattern.matches("[0-9]", String.valueOf(s.charAt(i)))) {
                sb.append(s.charAt(i));
            } else if (Pattern.matches("[\\+|\\-|\\*|\\/]", String.valueOf(s.charAt(i)))) {
                calculatePlusDivide(deque, sb.toString());
                deque.add(String.valueOf(s.charAt(i)));
                sb = new StringBuffer();
            }

        }
        calculatePlusDivide(deque, sb.toString());

        return calculateAddSubStruction(deque);
    }

    public static int calculateAddSubStruction(Deque<Object> deque) {
        int resultSum = Integer.valueOf(deque.pollFirst().toString());
        // 计算剩下的加减法
        Iterator<Object> it = deque.iterator();
        while(it.hasNext()) {
            Object ob = it.next();
            if (ob.toString().equals("+")) {
                deque.pollFirst();
                resultSum += Integer.valueOf(it.next().toString());
            } else {
                deque.pollFirst();
                resultSum -= Integer.valueOf(it.next().toString());
            }
        }
        return resultSum;
    }

    public static void calculatePlusDivide(Deque<Object> deque, String str) {
        if (deque.isEmpty()) {
            deque.add(str);
            return;
        }
        if (deque.peekLast().equals("*")) {
            deque.pollLast();
            int num1 = Integer.valueOf(deque.pollLast().toString());
            deque.add(num1 * Integer.valueOf(str));
        } else if (deque.peekLast().equals("/")) {
            deque.pollLast();
            int num1 = Integer.valueOf(deque.pollLast().toString());
            deque.add(num1 / Integer.valueOf(str));
        } else {
            deque.add(str.toString());
        }
    }
}
