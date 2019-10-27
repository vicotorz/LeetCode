import java.util.HashMap;
import java.util.Stack;

/**
 * LeetCode-20
 * 注意后面要判断栈是否为空
 */
public class Valid_Parenthess {
    public boolean isValid(String s) {
        HashMap<String, String> map = new HashMap();
        map.put(")", "(");
        map.put("]", "[");
        map.put("}", "{");

        Stack<String> stack = new Stack();
        boolean result = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.add(String.valueOf(s.charAt(i)));
            }
            if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                if (stack.isEmpty()) {
                    result = false;
                    break;
                } else if (stack.peek().equals(map.get(String.valueOf(s.charAt(i))))) {
                    stack.pop();
                } else {
                    result = false;
                    break;
                }
            }
        }
        if(!stack.isEmpty()) {
            result = false;
        }
        return result;
    }
}
