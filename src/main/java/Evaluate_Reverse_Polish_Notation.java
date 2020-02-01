import java.util.Stack;
import java.util.regex.Pattern;

/**
 * LeetCode-150
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
public class Evaluate_Reverse_Polish_Notation {
    public int evalRPN(String[] tokens) {
        if(tokens==null||tokens.length==0) {
            return 0;
        }

        Stack<Integer> stack = new Stack();
        for (int i = 0; i < tokens.length; i++) {
            if (Pattern.matches("^[-]?[\\d]+$", tokens[i])) {
                stack.add(Integer.valueOf(tokens[i]));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int result = calculate(num1, num2, tokens[i]);
                stack.add(result);
            }
        }
        return stack.pop();
    }

    public int calculate(int num1, int num2, String fu) {
        int result = 0;

        if (fu.equals("+")) {
            result = num1 + num2;
        } else if (fu.equals("-")) {
            result = num1 - num2;
        } else if (fu.equals("*")) {
            result = num1 * num2;
        } else if (fu.equals("/")) {
            result = num1 / num2;
        }
        return result;
    }
}
